package users;

import java.util.Date;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import communication.ResearchProject;
import education.Course;
import enums.Gender;

public class Professor extends Teacher {

	private static final long serialVersionUID = 1L;
	private String biography;
	private Vector<GraduateStudent> assistants = new Vector<>();

	public Professor(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			boolean isAdvisor, Vector<Course> courses, String biography, Vector<GraduateStudent> assistants) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, isAdvisor, courses);
		this.biography = biography;
		this.assistants = assistants;
	}

	public Professor() {
	}

	public Vector<GraduateStudent> getAssistants() {
		return assistants;
	}
	
	public void setAssistants(GraduateStudent student) {
		this.assistants.add(student);
	}

	public void setAssistants(String username) {
	    Data.getInstance().getGraduateStudents().stream()
	            .filter(s -> s.getUsername().equals(username))
	            .findFirst()
	            .ifPresent(this::setAssistants);
	}
	
	public void removeAssistants(GraduateStudent student) {
		this.assistants.remove(student);
	}
	
	public void removeAssistants(String username) {
	    Data.getInstance().getGraduateStudents().stream()
	            .filter(s -> s.getUsername().equals(username))
	            .findFirst()
	            .ifPresent(this::removeAssistants);
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	@Override
    public void editPersonalData() {
    	while(true) {
    		System.out.println(this);
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number"
    				+ "\n6.Set Pasport Number\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username"
    				+ "\n12.Set Email\n13.Add Assistant\n14.Remove Assistant\n15.Set Biography\n0.to exit");
    		String choose = commonBuffer.readInput();
    		if(choose.equals("0")) {break;}
    		else if(choose.equals("1")) {System.out.print("Enter new password: "); setPassword(commonBuffer.readInput());}
    		else if(choose.equals("2")) {System.out.println("Write a New Name: "); setFirstName(commonBuffer.readInput());}
    		else if(choose.equals("3")) {System.out.println("Write a New Last Name: "); setLastName(commonBuffer.readInput());}
    		else if(choose.equals("4")) {System.out.println("Write a Birth Day: "); setBirthDay(commonBuffer.readInput());}
    		else if(choose.equals("5")) {System.out.println("Write a Phone Number: "); setPhoneNumber(commonBuffer.readInput());}
    		else if(choose.equals("6")) {System.out.println("Write a Pasport Number: "); setPasportNumber(commonBuffer.readInput());}
    		else if(choose.equals("7")) {System.out.println("Write a Gender: "); setGender(commonBuffer.readInput());}
    		else if(choose.equals("8")) {System.out.println("Write a Nationality: "); setNationality(commonBuffer.readInput());}
    		else if(choose.equals("9")) {System.out.println("Write a Citizenship: "); setCitizenship(commonBuffer.readInput());}
    		else if(choose.equals("10")) {System.out.println("Write an Id: "); setId(commonBuffer.readInput());}
    		else if(choose.equals("11")) {System.out.println("Write a username: "); setUsername(commonBuffer.readInput());}
    		else if(choose.equals("12")) {System.out.println("Write a email: "); setEmail(commonBuffer.readInput());}
    		else if(choose.equals("13")) {System.out.println("Write an assistant Username: "); setAssistants(commonBuffer.readInput());}
    		else if(choose.equals("14")) {System.out.println("Write an assistant Username: "); removeAssistants(commonBuffer.readInput());}
    		else if(choose.equals("15")) {System.out.println("Write your Biography: "); setBiography(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
	    }
    }
	
    @Override
    public void createResearchProject() {
    	System.out.println("----WINDOW FOR CREATING RESEARCH PROJECT");
    	System.out.println("Write Journal Name: ");
    	String journalName = commonBuffer.readInput();
    	System.out.println("Write Project Topic: ");
    	String topic = commonBuffer.readInput();
    	ResearchProject project = new ResearchProject(journalName, topic, this.getUsername());
    	Data.getInstance().setResearchProjects(project);
    }

	@Override
	public String toString() {
		return super.toString() + "\n Biography = " + biography + "\n Assistants=" + assistants;
	}
    
}
