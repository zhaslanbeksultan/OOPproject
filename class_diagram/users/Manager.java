package users;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import communication.News;
import education.Courses;
import enums.*;
import userCapabilities.*;


public class Manager extends Employee implements Managable, Administrationable {
	
    private ManagerPosition managerPosition;
    private Vector coursesRegisterTo;
    private Vector requests;

    public Manager(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber);
		this.managerPosition = managerPosition;
	}

    public ManagerPosition getManagerPosition() {
        return this.managerPosition;
    }

    public void setManagerPosition(ManagerPosition managerPosition) {
        this.managerPosition = managerPosition;
    }

    public Vector getCoursesRegisterTo() {
        return this.coursesRegisterTo;
    }

    public void setCoursesRegisterTo(Vector coursesRegisterTo) {
        this.coursesRegisterTo = coursesRegisterTo;
    }

    public Vector getRequests() {
        return this.requests;
    }

    public void setRequests(Vector requests) {
        this.requests = requests;
    }

    public Vector getManagerDuties() {
        return null;
    }

    public boolean isCapableToPostNews() {
        return false;
    }

	
	public boolean disciplineRegistration(String discipline) {
		return false;
	}

	
	public boolean addDiscipline(String discipline) {
		return false;
	}

	
	public boolean dropDiscipline(String discipline) {
		return false;
	}

	
	public boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed) {
		return false;
	}

	
	public void viewAcademicStatistics() {
		
	}

	
	public void makeOfficeHoursSchedule() {
		
	}

	
	public void obtainingProgressStatistics() {
		
	}

	
	public void gettingPassingStatistics() {
		
	}

	
	public void viewRegisteredSchedule() {
		
	}

	public void postNews() {
		if(!managerPosition.equals(ManagerPosition.OR)) {
			System.out.println("Only OR Manager Can Post News!");
			return;
		}
		System.out.println("----WINDOW POST NEWS----");
    	System.out.print("Recipients 'Students' or 'Employees': ");
    	String recipients = commonBuffer.readInput();
    	System.out.print("News Type: "); 
    	String newsType = commonBuffer.readInput();
    	System.out.print("News Wording: ");
    	String newsTitle = commonBuffer.readInput();
    	System.out.print("News Title: ");
    	String newsWording = commonBuffer.readInput(); 
    	News post = new News(recipients, newsType, newsTitle, newsWording);
    	Data.getInstance().setNews(post);
	}

	public void manageNewsWording(String newsTitle, String newWording) {
		
	}

	public boolean accessRespondsFromNews() {
		return false;
	}

	public String answerToComplaints(String complaint) {
		return null;
	}

	
	public boolean dropDiscipline(Courses discipline) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addDiscipline(Courses discipline) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public HashMap<String, HashMap<WeekDays, Teacher>> getLessonSchedule() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
