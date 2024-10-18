package pojo;

public class Condition {
	private String columnName;
	private String operator="=";
	private Object value;
	
	public Condition(String columnName, String operator, Object value) {
		super();
		setColumnName(columnName);
		setOperator(operator);
		setValue(value);
	}
	public Condition(String columnName,Object value) {
		super();
		setColumnName(columnName);
		setValue(value);
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
