package pkgPerson;

public class Student extends Person {

	private int rollNo;
	private int std;
	private String division;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	    
	
	public Student(String name, String emailId, String address, String phoneNumber, String dob, int rollNo, int std,
			String division) {
		super(name, emailId, address, phoneNumber, dob);
		this.rollNo = rollNo;
		this.std = std;
		this.division = division;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", std=" + std + ", division=" + division + ", name=" + name + ", emailId="
				+ emailId + ", address=" + address + ", phoneNumber=" + phoneNumber + ", dob=" + dob + "]";
	}
	
	
}
