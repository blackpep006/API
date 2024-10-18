package pojo;

import java.util.List;

public class SQLArguments{
	private List<String> select;
	private List<Condition> update;
	private List<Condition> where;
	private boolean useOr;
	private Class<?>  joinTable;
	private String joinCondition;
	private int limit;
	private Boolean isDescending; 
	private String sortByColumn;
	private boolean getAll; 

	public List<String> getSelect() {
		return select;
	}


	public void setSelect(List<String> select) {
		this.select = select;
	}


	public Class<?> getClazz() {
		return clazz;
	}


	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	private Class<?> clazz;
	public SQLArguments() {
	}
	
	
	public List<Condition> getUpdate() {
		return update;
	}


	public void setUpdate(List<Condition> update) {
		this.update = update;
	}


	public List<Condition> getWhere() {
		return where;
	}


	public void setWhere(List<Condition> where) {
		this.where = where;
	}

	
	public boolean isUseOr() {
		return useOr;
	}
	public void setUseOr(boolean useOr) {
		this.useOr = useOr;
	}
	
	public Class<?> getJoinTable() {
		return joinTable;
	}


	public void setJoinTable(Class<?> joinTable) {
		this.joinTable = joinTable;
	}


	public String getJoinCondition() {
		return joinCondition;
	}
	public void setJoinCondition(String joinCondition) {
		this.joinCondition = joinCondition;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Boolean getIsDescending() {
		return isDescending;
	}
	public void setIsDescending(Boolean isDescending) {
		this.isDescending = isDescending;
	}
	public String getSortByColumn() {
		return sortByColumn;
	}
	public void setSortByColumn(String sortByColumn) {
		this.sortByColumn = sortByColumn;
	} 

	public boolean getGetAll() {
		return getAll;
	}
	public void setGetAll(boolean isGetAll) {
		this.getAll = isGetAll;
	}
}
