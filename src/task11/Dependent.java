package task11;

public class Dependent {
    private int employeeId;
    private String employeeName;
    private String dependentName;
    private int age;
    private String relationship;

    public Dependent(int employeeId, String employeeName, String dependentName, int age, String relationship) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dependentName = dependentName;
        this.age = age;
        this.relationship = relationship;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getDependentName() {
        return dependentName;
    }
    public int getAge() {
        return age;
    }
    public String getRelationship() {
        return relationship;
    }
    @Override
    public String toString() {
        return "Dependent{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", dependentName='" + dependentName + '\'' +
                ", age=" + age +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
