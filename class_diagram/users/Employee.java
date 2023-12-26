package users;

import java.util.Date;
import common.Data;
import common.commonBuffer;
import communication.*;
import enums.*;

public abstract class Employee extends User{

	private static final long serialVersionUID = 1L;
	private double salary;
    private Date hireDate;
    private String insuranceNumber;
    private Message message;
    
    
	public Employee(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
	}
	public Employee() {
		
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
    public void addOrder() {
    	System.out.println("----THE ORDER WINDOW----");
    	System.out.println("Please Write Order Details: ");
    	String info = commonBuffer.readInput();
    	Order order = new Order(this.getUsername(), info);
    	Data.getInstance().getOrders().add(order);
    }
    
    public void sentComplaintMessage() {
       
    }
    public String performInsuranceNumber() {
        return "";
    }
	@Override
	public String toString() {
		return super.toString() + "Salary=" + salary + "\n Hire Date=" + hireDate + "\n Insurance Number=" + insuranceNumber;
	}
    
}
