package pkgPerson;

import java.util.regex.Pattern;

abstract public class Person {
	
	protected String name;
 	protected String emailId;
	protected String address;
	protected String phoneNumber;
	protected String dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		boolean isValidName = Pattern.matches("[a-z A-Z]+", name);
	  if(isValidName)
		this.name = name;
	  else
		  this.name = "dafault name";
		  
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		boolean isValidDob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
		if (isValidDob)
		this.dob = dob;
		else
			this.dob = "01-06-2005";
	}
	public Person(String name, String emailId, String address, String phoneNumber, String dob) {
		super();
		this.setName(name); //this is encapsulation
		this.emailId = emailId;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.setDob(dob);
	}
	public Person() {
		super();
	}
	
	
}
