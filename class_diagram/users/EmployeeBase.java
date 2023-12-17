package users;

import java.util.Date;
import java.util.HashMap;

import common.Data;
import common.commonBuffer;
import communication.*;
import enums.*;

public class EmployeeBase extends User implements Employee{

    private double salary;
    private Date hireDate;
    private String insuranceNumber;
    private Message message;
    
    
	public EmployeeBase(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
	}
	public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getHireDate() {
        return this.hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }
    public void setInsuranceNumber(String insuranceNumber) {
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
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		
	}
    
    
}
