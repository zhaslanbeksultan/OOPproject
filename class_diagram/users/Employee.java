package users;

import java.util.Date;
import communication.*;
import enums.Gender;

public class Employee extends User {

    private double salary;
    private Date hireDate;
    private String insuranceNumber;
    private Message message;
    
    
	public Employee(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			Message message) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
		this.message = message;
	}
	private double getSalary() {
        return this.salary;
    }
    private void setSalary(double salary) {
        this.salary = salary;
    }
    private Date getHireDate() {
        return this.hireDate;
    }
    private void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    private String getInsuranceNumber() {
        return this.insuranceNumber;
    }
    private void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    public Message getMessage() {
        return this.message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }

    public String getEmployeeId() {
        return "";
    }
    public void sentComplaintMessage() {
       
    }
    public String performInsuranceNumber() {
        return "";
    }
    
    
}
