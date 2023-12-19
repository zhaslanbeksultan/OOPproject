package users;
import java.util.Date;

import common.*;
import communication.*;
import enums.Gender;
public class Admin extends Employee{
    public Admin(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}
	Data d= Data.getInstance();
    public void createStudent() {
    	Student beks= new Student();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	beks.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	beks.setPassword(password);
    	d.setLogs(logname, password);
    	d.addStudent(beks);
    	System.out.println("Successfully added!");
    }
	@Override
	void addRequest() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		
	}
    
                               
    
    
}
