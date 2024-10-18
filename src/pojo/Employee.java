package pojo;


public class Employee extends User{
	private Integer branchId; 
	public Employee() {
		
	}
	public int getBranchId() {
	    return branchId;
	}

	public void setBranchId(int branch_id) {
	    this.branchId = branch_id;
	}

	public String toString() {
        return "Employee{" +this.toString()+
                ", BranchId=" + branchId +
                '}';
    }
}
