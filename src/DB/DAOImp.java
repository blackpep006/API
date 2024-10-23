package DB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pojo.Bank;
import pojo.Condition;
import pojo.SQLArguments;
import util.CustomException;
import util.Helper;

public class DAOImp {
	private static String url = "jdbc:mysql://localhost:3306/bank"; 
    private static String user = "root";
    private static String password = "Pass#word.09";

    public static int insert(Bank obj) throws CustomException {
        Integer insertedValue = null;
        String autoIncrementColumn = null;
        Class<?> currentClass = obj.getClass();
        Stack<Class<?>> classHierarchy = new Stack<>();

        while (!currentClass.getSimpleName().equals("Bank")) {
            classHierarchy.push(currentClass);
            currentClass = currentClass.getSuperclass();
        }

        while (!classHierarchy.isEmpty()) {
            currentClass = classHierarchy.pop();
            System.out.println(currentClass);

            String tableName = (String) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("tableName");
            StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
            StringBuilder valuesPlaceholder = new StringBuilder("VALUES (");
            
            List<Object> params = new ArrayList<>();
            StringBuilder columnNames = new StringBuilder();
            int noOfColumns = 0;
            Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("fields");
            Field[] fields = currentClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + "-");
                try {
                    Object value = field.get(obj);
                    System.out.print(value);
                    String column = ((Map<String,String>) fieldMapping.get(field.getName())).get("columnName");

                    if (value != null && column != null) {
                        columnNames.append(column).append(", ");
                        valuesPlaceholder.append("?, ");
                        noOfColumns++;
                        params.add(value);
                    }
                } catch (IllegalAccessException e) {
                    throw new CustomException("Error accessing field: " + field.getName(), e);
                }
            }

            if (insertedValue != null && autoIncrementColumn != null) {
                columnNames.append(autoIncrementColumn).append(", ");
                valuesPlaceholder.append("?, ");
                noOfColumns++;
                params.add(insertedValue);
            }

            if (columnNames.length() > 0) {
                columnNames.setLength(columnNames.length() - 2);
            }
            if (valuesPlaceholder.length() > 0) {
                valuesPlaceholder.setLength(valuesPlaceholder.length() - 2);
            }

            sql.append(columnNames).append(") ").append(valuesPlaceholder).append(")");

            System.out.println(sql);
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {

                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }

                statement.executeUpdate();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        insertedValue = resultSet.getInt(1);
                    }
                }
            } catch (SQLException e) {
                throw new CustomException("SQL Exception in insert into " + tableName, e);
            }

            String tempAutoIncrementColumn = (String) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("autoIncrementColumn");
            autoIncrementColumn=tempAutoIncrementColumn==null ? autoIncrementColumn : tempAutoIncrementColumn;
        }

        return insertedValue;
    }

    
    public static void delete(SQLArguments arguments) throws CustomException {
    	String tableName = (String) ((Map<String, Object>) Helper.map.get(arguments.getClazz().getSimpleName())).get("tableName");
        StringBuilder sql = new StringBuilder("DELETE FROM " + tableName);
        sql.append(buildWhereClause(arguments.getWhere(), arguments.isUseOr()));

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {
        	List<Condition> condition=arguments.getWhere();
        	int size=condition.size();
            for (int i = 0; i < size; i++) {
                statement.setObject(i + 1, condition.get(i).getValue());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Exception in delete DAOImp", e);
        }
    }


    public static <T> List<T> get(SQLArguments arguments) throws CustomException {
    	List<T> results = new ArrayList<>();
        String tableName = (String) ((Map<String, Object>) Helper.map.get(arguments.getClazz().getSimpleName())).get("tableName");
        String joinTable;
        StringBuilder sql = new StringBuilder("SELECT ");
        List<String> selectColumn=arguments.getSelect();
        if(selectColumn!=null) {
        	for(String column:selectColumn) {
        		sql.append(column+", ");
        	}
        	sql.setLength(sql.length()-2);
        }else {
        	sql.append("* ");
        }
        sql.append( "FROM " + tableName);
        if (arguments.getJoinTable() != null && arguments.getJoinCondition() != null) {
        	joinTable=(String) ((Map<String, Object>) Helper.map.get(arguments.getJoinTable().getSimpleName())).get("tableName");
            sql.append(" JOIN ").append(joinTable).append(" ON ").append(arguments.getJoinCondition());
        }
        if(!arguments.getGetAll()) {
        	sql.append(buildWhereClause(arguments.getWhere(), arguments.isUseOr()));
        }

        if (arguments.getLimit() > 0) {
            sql.append(" LIMIT ").append(arguments.getLimit());
        }

        if (arguments.getIsDescending() != null) {
            sql.append(" ORDER BY ").append(arguments.getSortByColumn());
            sql.append(arguments.getIsDescending()? " DESC" : " ASC");
        }
        System.out.println(sql);
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {
        	List<Condition> condition=arguments.getWhere();
        	int size=condition.size();
            for (int i = 0; i < size; i++) {
                statement.setObject(i + 1, condition.get(i).getValue());
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                results = (List<T>) resultSetToListObject(resultSet, arguments.getClazz());
            }

        } catch (SQLException e) {
            throw new CustomException("SQL Exception in get into DAOIMP ", e);
        }
        return results;
    }



    private static <T> List<T> resultSetToListObject(ResultSet resultSet, Class<T> clazz) throws SQLException {
        List<T> list = new ArrayList<>();
        try {
        	while (resultSet.next()) {
        	    T obj = clazz.getDeclaredConstructor().newInstance();
        	    
        	    Class<?> currentClass = clazz;

        	    while (!currentClass.getSimpleName().equals("Bank")) {
        	    	Map<String, Object> tempMap = (Map<String, Object>) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("fields");

        	    	Field[] fields=currentClass.getDeclaredFields(); 
        	        for (Field field : fields) { 
        	            field.setAccessible(true);
        	            String columnName = ((Map<String,String>) tempMap.get(field.getName())).get("columnName");
        	            if (columnName != null) {
        	                Object value = resultSet.getObject(columnName);
        	                if(value!=null) {
        	                	field.set(obj, value);
        	                }
        	            }
        	        }
        	        currentClass = currentClass.getSuperclass();
        	    }
        	    list.add(obj);
        	}
        }catch (Exception e) {
            throw new SQLException("Error mapping result set to " + clazz.getSimpleName(), e);
        }
        
        return list;
    }
	
	
    public static void update(SQLArguments arguments) throws CustomException {
    	Class<?> currentClass=arguments.getClazz();
    	while(!currentClass.getSimpleName().equals("Bank")) {
    		String tableName = (String) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("tableName");
    		Map<String, Object> tempMap = (Map<String, Object>) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("fields");

    		StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
    		boolean argsAdded=true;
    		List<Object> params=new ArrayList<>();
    		int size,sizeOfParams;
    		if(arguments.getUpdate()!=null) {
    			List<Condition> condition=arguments.getUpdate();
    			size=condition.size();
    			for (int i = 0; i < size; i++) {
    				Map<String,String> temp=(Map<String,String>) tempMap.get(condition.get(i).getColumnName());
    				if(temp==null) {
    					continue;
    				}
    				String columnName = (temp).get("columnName");
    				if(columnName!=null) {
    					sql.append(columnName).append(" = ?, ");
    					params.add(condition.get(i).getValue());
    					argsAdded=false;
    				}
    			}
    		}
    		if(!argsAdded) {
    		
    			if ((size=sql.length()) > 0) {
    				sql.setLength(size - 2);
    			}
    			if(!arguments.getGetAll()) {
    				sql.append(buildWhereClause(arguments.getWhere(), arguments.isUseOr()));
    			}
    			System.out.println(sql);
    			try (Connection connection = DriverManager.getConnection(url, user, password);
    				PreparedStatement statement = connection.prepareStatement(sql.toString())) {
            
    				sizeOfParams = params.size();
    				for (int i = 0; i < sizeOfParams; i++) {
    					statement.setObject(i + 1, params.get(i));
    				}
    				List<Condition> condition=arguments.getWhere();
    				size=condition.size();
    				for (int i = 0; i < size; i++) {
    					statement.setObject(sizeOfParams + i+1, condition.get(i).getValue());
    				}

    				statement.executeUpdate();
    			} catch (SQLException e) {
    				throw new CustomException("SQL Exception in update ", e);
    			}
    		}
    		currentClass=currentClass.getSuperclass();
    	}
    }
    public static void  updateObject(Bank obj) throws CustomException {

        Class<?> currentClass = obj.getClass();
	    List<Condition> primaryValues=new ArrayList<>();
	    Stack<Class<?>> classHierarchy = new Stack<>();

        while (!currentClass.getSimpleName().equals("Bank")) {
            classHierarchy.push(currentClass);
            currentClass = currentClass.getSuperclass();
        }

        while (!classHierarchy.isEmpty()) {
            currentClass = classHierarchy.pop();
            System.out.println(currentClass);
            String tableName = (String) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("tableName");
            StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
    	    List<Object> params = new ArrayList<>();
    	    List<String> primaryKey=(List<String>) ((Map<String, Object>)   Helper.map.get(currentClass.getSimpleName())).get("primaryKey");
            Map<String, Object> fieldMapping = (Map<String, Object>) ((Map<String, Object>) Helper.map.get(currentClass.getSimpleName())).get("fields");
            Field[] fields = currentClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + "-");
                try {
                    Object value = field.get(obj);
                    System.out.print(value);
                    String columnName = ((Map<String,String>) fieldMapping.get(field.getName())).get("columnName");

                    if (value != null && columnName != null) {
    	                if (primaryKey.contains(columnName)) {
    	                	System.out.println(columnName);
    	                	primaryValues.add(new Condition(columnName,value));
    	                	continue;
    		            }
                        sql.append(columnName).append(" = ?, ");
    	                params.add(value);
                    }
                } catch (IllegalAccessException e) {
                    throw new CustomException("Error accessing field: " + field.getName(), e);
                }
            }

            if (sql.length() > 0) {
    	        sql.setLength(sql.length() - 2);
    	    }
            sql.append(buildWhereClause(primaryValues,false));
            System.out.println(sql);
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement statement = connection.prepareStatement(sql.toString())) {
            	int sizeOfParams=params.size();
                for (int i = 0; i < sizeOfParams; i++) {
                    statement.setObject(i + 1, params.get(i));
                    System.out.print(params.get(i));
                }

                int size=primaryValues.size();
                for (int i = 0; i < size; i++) {
                    statement.setObject(sizeOfParams + i+1 , primaryValues.get(i).getValue());
                    System.out.print(primaryValues.get(i).getValue());
                }
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new CustomException("SQL Exception in update into " + tableName, e);
            }

        }
	}


	
	
	private static String buildWhereClause(List<Condition> condition,boolean useOr) {
	    StringBuilder whereClause = new StringBuilder();
	        whereClause.append(" WHERE ");
	        int size=condition.size();
	        for (int i = 0; i < size; i++) {
	            String operator = condition.get(i).getOperator();
	            String columnName = condition.get(i).getColumnName();

	            if (operator.equalsIgnoreCase("BETWEEN")) {
	                whereClause.append(columnName).append(" ").append(operator).append(" ? AND ? ");
	                i++;
	            } else if (operator.equalsIgnoreCase("NOT")) {
	                whereClause.append("NOT ").append(columnName).append(" ? ");
	            } else {
	                whereClause.append(columnName).append(" ").append(operator).append(" ? ");
	            }

	            if (i < size - 1) {
	                whereClause.append(useOr ? " OR " : " AND ");
	            }
	        }

	    return whereClause.toString();
	}
	private static List<String> multiply(String string, int count) {
	    return Stream.generate(() -> string)
	                 .limit(count)
	                 .collect(Collectors.toList());
	}
	private static String repeatString(String string, int count) {
	        return Stream.generate(() -> string)
	                     .limit(count)
	                     .collect(Collectors.joining());
	}
}

