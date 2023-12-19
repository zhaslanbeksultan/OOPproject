package users;
import java.util.Date;
import java.io.*;
import common.*;
import communication.*;
import app.*;
import enums.Gender;
public class Admin extends Employee{
    public Admin(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}
    public Admin() {
    	
    }
	Data d= Data.getInstance();
    public void createStudent() throws IOException {
    	Student student= new Student();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	student.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	student.setPassword(password);
    	d.addUser(logname, student);
    	d.addStudent(student);
    	System.out.println("Successfully added!");
    	save();
    }

    public void showMenu(){
    	System.out.println("Welcome!\n Please choose:\n 1.Add student\n 2.Log out");
    	String input=commonBuffer.readInput();
    	switch(input) {
    		case "1":
    			try {
    			createStudent();
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		    break;
    		case "2":
    			break;
    	}
    }
	@Override
	void addRequest() {
		// TODO Auto-generated method stub
		
	}

                               
    
    
}
