package pojo;

public class Branch  extends Bank{
	private Integer id;
	private String ifsc;
	private String branchName;
	private String location;
	private Integer managerId;
	private Integer createdBy;
	private Long createdTime;
	private Integer modifiedBy;
	private Long modifiedTime;
	private String status;
    public Branch() {
    	
    }
    
    
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getIfsc() {
		return ifsc;
	}


	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getManagerId() {
		return managerId;
	}


	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public Integer getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public Long getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Long getModifiedTime() {
		return modifiedTime;
	}


	public void setModifiedTime(Long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String toString() {
        return "Branch{" +
                "id=" + id +
                ", ifsc='" + ifsc + '\'' +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                ", managerId=" + managerId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", modifiedBy=" + modifiedBy +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
