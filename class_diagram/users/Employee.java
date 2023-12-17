package users;

import java.util.Date;

import communication.Message;

public interface Employee {
	public double getSalary();
    public void setSalary(double salary);
    public Date getHireDate();
    public void setHireDate(Date hireDate);
    public String getInsuranceNumber();
    public void setInsuranceNumber(String insuranceNumber);
    public Message getMessage();
    public void setMessage(Message message);
    public String getEmployeeId();
    public void sentComplaintMessage();
    public String performInsuranceNumber();
}
