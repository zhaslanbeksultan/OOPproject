package users;

import Date;
import communication.Message;
import enums.Gender;

public class Employee extends User {

    private double salary;
    private Date hireDate;
    private String insuranceNumber;
    private Message message;
    private Message message;
    
    public Employee(String firstName, String lastName, java.util.Date birthDay, String id, String username,
			String password, String email, java.util.Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, Request request, News news, users.Message message,
			double salary, users.Date hireDate, String insuranceNumber, Message message2) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, request, news, message);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
		message = message2;
	}
	private double getSalary() {
        return this.salary;
    }
    private double setSalary(double salary) {
        this.salary = salary;
    }
    private Date getHireDate() {
        return this.hireDate;
    }
    private Date setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    private String getInsuranceNumber() {
        return this.insuranceNumber;
    }
    private String setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    public Message getMessage() {
        return this.message;
    }
    public Message setMessage(Message message) {
        this.message = message;
    }
    public Message getMessage() {
        return this.message;
    }
    public Message setMessage(Message message) {
        this.message = message;
    }
    public String getEmployeeId() {
        return "";
    }
    public String sentComplaintMessage() {
        return "";
    }
    public double getSalary() {
        return 0.0;
    }
    public String performInsuranceNumber() {
        return "";
    }
    
    
}
