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
    
    public void createDean() throws IOException {
    	Dean dean = new Dean();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	dean.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	dean.setPassword(password);
    	d.addUser(logname, dean);
    	d.addDean(dean);
    	System.out.println("Successfully added!");
    	save();	
    }
    public void createGraduateStudent() throws IOException {
    	GraduateStudent graduateStudent = new GraduateStudent();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	graduateStudent.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	graduateStudent.setPassword(password);
    	d.addUser(logname, graduateStudent);
    	d.addTeacher(graduateStudent);
    	System.out.println("Successfully added!");
    	save();	
    }
    public void createLibrarian() throws IOException {
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
    public void createManager() throws IOException {
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
    public void createProfessor() throws IOException {
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
    public void createTechSupportSpecialist() throws IOException {
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
    public void EmployeeResearcher() throws IOException {
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
	public void addRequest() {
		while(true) {
			System.out.println("----ADD REQUEST WINDOW----");
			System.out.println("Select the Form: 'Paper', 'Electronic'");
			String form = commonBuffer.readInput(); 
			System.out.println("Select the Type:\nREQUEST_FOR_ACADEMIC_MOBILITY\nWORKAROUND_SHEET"
					+ "\nHELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"
					+ "\nHELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES\nHELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"
					+ "\nINFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT");
			String type = commonBuffer.readInput();
			System.out.println("Select the Language: 'EN', 'RU', 'KZ'");
			String language = commonBuffer.readInput();
			Request request = new Request(this.getUsername(), form, type, language);
			System.out.println("'0' - Cancel");
			System.out.println("'1' - If You Want Add Additionally Information");
			System.out.println("'2' - Save");
			String choice = commonBuffer.readInput();
			if(choice.equals("0")) break;
			if(choice.equals("1")) {
				String info = commonBuffer.readInput();
				request.setAdditionallyInfo(info);
				choice = commonBuffer.readInput();}
			if(choice.equals("2"))
				Data.getInstance().addRequest(request);
				break;
		}
	}

}
