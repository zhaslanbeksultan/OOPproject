package users;
import java.util.Date;
import java.util.Map;
import java.io.*;
import common.*;
import communication.*;
import app.*;
import enums.Gender;
public class Admin extends Employee{

	private static final long serialVersionUID = 1L;
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
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
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
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
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
    	d.setDeans(dean);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
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
    	d.setGraduateStudents(graduateStudent);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
    public void createLibrarian() throws IOException {
    	Librarian librarian = new Librarian();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	librarian.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	librarian.setPassword(password);
    	d.addUser(logname, librarian);
    	d.setLibriarians(librarian);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
    public void createManager() throws IOException {
    	Manager manager = new Manager();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	manager.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	manager.setPassword(password);
    	d.addUser(logname, manager);
    	d.setManagers(manager);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
    public void createProfessor() throws IOException {
    	Professor professor = new Professor();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	professor.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	professor.setPassword(password);
    	d.addUser(logname, professor);
    	d.setProfessors(professor);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
    public void createTechSupportSpecialist() throws IOException {
    	TechSupportSpecialist techSupportSpecialist = new TechSupportSpecialist();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	techSupportSpecialist.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	techSupportSpecialist.setPassword(password);
    	d.addUser(logname, techSupportSpecialist);
    	d.setTechSupportSpecialists(techSupportSpecialist);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
    public void createEmployeeResearcher() throws IOException {
    	EmployeeResearcher employeeResearcher = new EmployeeResearcher();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	employeeResearcher.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	employeeResearcher.setPassword(password);
    	d.addUser(logname, employeeResearcher);
    	d.setEmployeeResearchers(employeeResearcher);
    	System.out.println("Successfully added!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    	save();	
    }
   @Override
    public void showMenu(){
	   while(true) {
	    	System.out.println("----MAIN WINDOW----");
	    	System.out.println("1. Create User\n2. Requests Window\n3. Edit User Personal Datas\n4. Delete User\n0. Log Out");
	    	String choice = commonBuffer.readInput();
	    	switch(choice) {
	    	case "0":
	    		return;
	    	case "1":
	    		this.createUser();
	    		break;
	    	case "2":
	    		this.viewRequests();
	    		break;
	    	case "3":
	    		this.editUserPersonalData();
	    		break;
	    	case "4":
	    		this.deleteUser();
	    		break;
	    	}
	    	
	   }
    }
   
   public void editUserPersonalData() {
	   System.out.println("----WINDOW FOR EDITING DATAS----");
	   System.out.println("Enter Username: ");
	   String input = commonBuffer.readInput();
	   Data.getInstance().getUsers().entrySet().stream()
       .filter(entry -> entry.getKey().equals(input))
       .map(Map.Entry::getValue)
       .findFirst()
       .ifPresent(user -> user.editPersonalData());

   }
   

   		
   public void createUser() {
   	while(true) {
   		System.out.println("----WINDOW CREATE USERS----");
   		System.out.println("Please choose:\n1.Add Student\n2.Add Teacher\n3.Add Manager\n4.Add Dean"
   				+ "\n5.Add Employee Researcher\n6.Add Graduate Student"
   				+ "\n7.Add Tech Support Specialist\n8.Add Professor\n9.Add Librarian\n0.to exit");
	    	String input=commonBuffer.readInput();
	    	switch(input) {
	    		case "0":
	    			return;
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
	    		case "3":
	    			try {
	        			createManager();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "4":
	    			try {
	        			createDean();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "5":
	    			try {
	        			createEmployeeResearcher();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "6":
	    			try {
	        			createGraduateStudent();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "7":
	    			try {
	        			createTechSupportSpecialist();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "8":
	    			try {
	        			createProfessor();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    		case "9":
	    			try {
	        			createLibrarian();
	        			} catch(IOException e){
	        				e.printStackTrace();
	        			}
	    			break;
	    	}
   	}
    }
   	public void deleteUser() {
   	
   	   		System.out.println("----WINDOW DELETE USERS----");
   		    System.out.println("Enter username:");
   		    String username=commonBuffer.readInput();
   		    User user = Data.getInstance().getUsers().get(username);
   		    System.out.println("WARNING!\nYou are deleting user from the system!\nPlease confirm it:\n1.Confirm\nAny key.Cancel");
   		    String input = commonBuffer.readInput();
   		    if(input.equals("1")) {
   		    	Data.getInstance().getUsers().remove(username);
   	   		    Data.getInstance().deleteUser(user);
   	   		System.out.println("User is deleted");
   		    }
   		    else {
   		    	System.out.println("Canceled");
   		    }
   	   	
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
