package task11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.CustomException;
import common.Helper;

public class DBProcess {
	String url = "jdbc:mysql://localhost:3306/incubationDB"; 
    String user = "root";
    String password = "Pass#word.09"; 
    private void execute(String query) throws CustomException {
    	Helper.validate(query);
    	try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement()) {

               statement.executeUpdate(query);

           } catch (SQLException e) {
               throw new CustomException("Exception in creating DB",e);
           }
    }
    public void createTable(String DBName) throws CustomException {
    	Helper.validate(DBName);

               String query = "CREATE TABLE "+DBName+"("
                       + "EMPLOYEE_ID INT PRIMARY KEY, "
                       + "NAME VARCHAR(100) NOT NULL, "
                       + "MOBILE VARCHAR(15), "
                       + "EMAIL VARCHAR(100) UNIQUE, "
                       + "DEPARTMENT VARCHAR(50)"
                       + ");";
         execute(query);
    }
    public void addDetail(String DBName,int id,String name,String mobileNo,String email,String dept) throws CustomException {
    	Helper.validate(id);
    	Helper.validate(DBName);

    		String insertSQL = "INSERT INTO "+DBName+" (EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT) "
                    + "VALUES (" + id + ", '" + name + "', '" + mobileNo + "', '" + email + "', '" + dept + "');";

       execute(insertSQL);
    }
    public List<Employee> getDetailForName(String DBName,String name) throws CustomException {
    	String query = "SELECT * FROM "+DBName+" WHERE NAME = '" + name + "'";
    	try(Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();){
                ResultSet resultSet = statement.executeQuery(query);
                List<Employee> result=new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Employee(resultSet.getInt("EMPLOYEE_ID"),resultSet.getString("NAME"),resultSet.getString("MOBILE"),resultSet.getString("EMAIL"),resultSet.getString("DEPARTMENT")));
                }
                return result;
    	}catch(SQLException e) {
    		throw new CustomException("Exception in getDetailForName",e);
    	}
    }
    public void update(String DBName,int id,String column,String value) throws CustomException {
    	Helper.validate(DBName);
    	Helper.validate(id);
    	Helper.validate(column);
    	String updateSQL = "UPDATE " + DBName + " SET " + column + " = ? WHERE EMPLOYEE_ID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, value); 
            preparedStatement.setInt(2, id); 
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
               throw new CustomException("Exception in update DB",e);
           }
    }
    public List<Employee> firstNData(String DBName,int limitNo) throws CustomException {
    	Helper.validate(DBName);
    	Helper.validate(limitNo);
    	String query="SELECT * FROM "+DBName+" LIMIT ?;";
    	try(Connection connection=DriverManager.getConnection(url,user,password);
    			PreparedStatement preparedStatement=connection.prepareStatement(query);){
    		preparedStatement.setInt(1,limitNo);
    		ResultSet resultSet=preparedStatement.executeQuery();
    		List<Employee> result=new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Employee(resultSet.getInt("EMPLOYEE_ID"),resultSet.getString("NAME"),resultSet.getString("MOBILE"),resultSet.getString("EMAIL"),resultSet.getString("DEPARTMENT")));
            }
            return result;
    	}catch(SQLException e) {
    		throw new CustomException("Exception in firstNData",e);
    	}
    }
    public List<Employee> firstNDataWithSort(String DBName,String column,String sort,int limitNo) throws CustomException {
    	Helper.validate(DBName);
    	Helper.validate(column);
    	Helper.validate(sort);
    	Helper.validate(limitNo);
    	String query="SELECT * FROM "+DBName+" ORDER BY "+column+" "+sort+" LIMIT ?;";
    	try(Connection connection=DriverManager.getConnection(url,user,password);
    			PreparedStatement preparedStatement=connection.prepareStatement(query);){
    		
    		preparedStatement.setInt(1,limitNo);
    		ResultSet resultSet=preparedStatement.executeQuery();
        	List<Employee> result=new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Employee(resultSet.getInt("EMPLOYEE_ID"),resultSet.getString("NAME"),resultSet.getString("MOBILE"),resultSet.getString("EMAIL"),resultSet.getString("DEPARTMENT")));
            }
            return result;
        }catch(SQLException e) {
        	throw new CustomException("Exception in firstNDataWithSort",e);
        }
    }
    public void deleteWithId(String DBName,int id) throws CustomException {
    	Helper.validate(DBName);
    	Helper.validate(id);
    	String query="DELETE FROM "+DBName+" WHERE EMPLOYEE_ID = ?;";
    	try(Connection connection=DriverManager.getConnection(url,user,password);
		PreparedStatement preparedStatement=connection.prepareStatement(query);){
    		preparedStatement.setInt(1,id);
    	    preparedStatement.execute();
    	}catch(SQLException e) {
    		throw new CustomException("Exception in deleteWithId DB",e);
    	}
		
    }
    
    public void createDepadentTable(String DBName,String depadentTableName) throws CustomException {
    	Helper.validate(DBName);
    	Helper.validate(depadentTableName);
               String query = "CREATE TABLE "+depadentTableName+" ("
               		+ "    EMPLOYEE_ID INT,"
               		+ "    NAME VARCHAR(100),"
               		+ "    AGE INT,"
               		+ "    RELATIONSHIP VARCHAR(50),"
               		+ "    FOREIGN KEY (EMPLOYEE_ID) REFERENCES "+DBName+" (EMPLOYEE_ID)"
               		+ ");";
         execute(query);
    }
    public void addDetailForDependent(String DBName,int id,String name,int age,String relation) throws CustomException {
    	Helper.validate(id);
    	Helper.validate(DBName);
    		String query = "INSERT INTO "+DBName+" (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) "
                    + "VALUES (" + id + ", '" + name + "', '" + age + "', '" + relation + "');";

        execute(query);
    }
	public List<Data> dependentDetailsOf(String dependentTableName,int id) throws CustomException {
		Helper.validate(id);
    	Helper.validate(dependentTableName);
    	String query="SELECT * FROM "+dependentTableName+" WHERE EMPLOYEE_ID =?";
    	List<Data> result=new ArrayList<Data>();
    	try(Connection connection=DriverManager.getConnection(url,user,password);
    			PreparedStatement preparedStatement=connection.prepareStatement(query);){
    		preparedStatement.setInt(1,id);
    		ResultSet resultSet=preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Data data=new Data();
                data.setAttribute("EMPLOYEE_ID",resultSet.getInt("EMPLOYEE_ID"));
                data.setAttribute("NAME",resultSet.getString("NAME"));
                data.setAttribute("AGE",resultSet.getString("AGE"));
                data.setAttribute("RELATIONSHIP",resultSet.getString("RELATIONSHIP"));
                result.add(data);
            }
    		return result;
    	}catch(SQLException e) {
    		throw new CustomException("Exception in firstNData",e);
    	}
	}
	public List<Data> dependentDetailsOfFirstNEmployees(String dependentTableName, int n) throws CustomException {
	    Helper.validate(n);
	    Helper.validate(dependentTableName);
	    
	    String query = "SELECT e.EMPLOYEE_ID, e.NAME AS EmployeeName, d.NAME AS DependentName, d.AGE, d.RELATIONSHIP " +
	                   "FROM Employee e " +
	                   "JOIN " + dependentTableName + " d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID " +
	                   "ORDER BY d.NAME ASC " +
	                   "LIMIT ?";
	    List<Data> result=new ArrayList<Data>();
	    try (Connection connection = DriverManager.getConnection(url, user, password);
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setInt(1, n);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            Data data=new Data();
                data.setAttribute("EMPLOYEE_ID",resultSet.getInt("EMPLOYEE_ID"));
                data.setAttribute("EmployeeName",resultSet.getString("EmployeeName"));
                data.setAttribute("DependentName",resultSet.getString("DependentName"));
                data.setAttribute("AGE",resultSet.getString("AGE"));
                data.setAttribute("RELATIONSHIP",resultSet.getString("RELATIONSHIP"));
                result.add(data);
	        }
	        return result;
	    } catch (SQLException e) {
	        throw new CustomException("Exception in fetching dependent details", e);
	    }
	}

}
