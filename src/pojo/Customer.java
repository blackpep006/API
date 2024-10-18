package pojo;


public class Customer extends User{
	private String panNo;
	private Long aadhar;
	private String address;

    public Customer() {
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String pan_no) {
        this.panNo = pan_no;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer{" + super.toString()+
                ", pan_no='" + panNo + '\'' +
                ", aadhar=" + aadhar +
                ", address='" + address + '\'' +
                ", " +
                '}';
    }
}
