package users;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import communication.Message;
import communication.News;
import communication.Request;
import education.Course;
import education.Courses;
import enums.*;
import userCapabilities.*;


public class Manager extends Employee implements Managable, Administrationable, Subscriber {
	
    private ManagerPosition managerPosition;
    private Vector<Course> coursesRegisterTo;

	public Manager(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			ManagerPosition managerPosition, Vector<Course> coursesRegisterTo) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
		this.managerPosition = managerPosition;
		this.coursesRegisterTo = coursesRegisterTo;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}


	public ManagerPosition getManagerPosition() {
        return this.managerPosition;
    }

    public void setManagerPosition(ManagerPosition managerPosition) {
        this.managerPosition = managerPosition;
    }

    public Vector<Course> getCoursesRegisterTo() {
        return this.coursesRegisterTo;
    }

    public void setCoursesRegisterTo(Vector<Course> coursesRegisterTo) {
        this.coursesRegisterTo = coursesRegisterTo;
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
    	System.out.print("Recipients 'Students', 'Employees', 'All': ");
    	String recipients = commonBuffer.readInput();
    	System.out.print("News Wording: ");
    	String newsTitle = commonBuffer.readInput();
    	System.out.print("News Title: ");
    	String newsWording = commonBuffer.readInput(); 
    	News post = new News(recipients, newsTitle, newsWording);
    	Data.getInstance().setNews(post);
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

	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSalary(double salary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getHireDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHireDate(Date hireDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInsuranceNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInsuranceNumber(String insuranceNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessage(Message message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sentComplaintMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String performInsuranceNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. \n2. \n3. \n4. \n5. \n6. \n7. "
					+ "\n8. \n9. \n10. \n11. \n12. "
					+ "\n13. \n14. \n15. \n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					break;
				case "1":
					this.viewTranscript();
				case "2":
					this.addDropDiscipline();
				case "3":
					this.viewJournal();
				case "4":
					this.viewRequests();
				case "5":
					System.out.println(this);
				case "6":
					this.viewNews();
				case "7":
					this.attendanceMark();
				case "8":
					this.viewAttestation();
				case "9":
					this.viewDisciplineSchedule();
				case "10":
					this.viewLessonSchedule();
				case "11":
					this.viewExamsSchedule();
				case "12":
					this.registrationForFx();
				case "13":
					this.disciplineRegistration(choice, false);
				case "14":
					this.viewSocialTranscript();
				case "15":
					this.viewOfficeHourSchedule();
				case "16":
					this.researchCabinet();
				case "17":
					this.viewOrganizations();
			}
		}
	}

	@Override
	public void addDropDiscipline() {
		// TODO Auto-generated method stub
		
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
	@Override
	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
	}
    
}
