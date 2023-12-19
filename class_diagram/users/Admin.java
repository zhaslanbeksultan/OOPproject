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
    public void createTeacher() throws IOException {
    	Teacher teacher = new Teacher();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	teacher.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	teacher.setPassword(password);
    	d.addUser(logname, teacher);
    	d.addTeacher(teacher);
    	System.out.println("Successfully added!");
    	save();	
    }
   
    public void showMenu(){
    	System.out.println("Welcome!");
    	boolean c= true;
    	while(c) {
    		System.out.println("Please choose:\n1.Add student\n2.Add teacher\n0.Log out");
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
	    			try {
	        			createTeacher();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "0":
	    			c=false;
	    		default:
	                System.out.println("Invalid choice. Please try again.");
	    	}
    	}
    	Main.main(null);
    }
	@Override
	void addRequest() {
		// TODO Auto-generated method stub
		
	}

                               
    
    
}
