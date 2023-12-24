package users;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import common.*;
import communication.*;
import education.*;
import enums.*;
import userCapabilities.*;


public class Manager extends Employee implements Managable, Subscriber {

	private static final long serialVersionUID = 1L;
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
	
	public void viewAcademicStatistics() {
		
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
	
	public void viewRequestsFromUsers() {
		while(true){
			System.out.println("----WINDOW FOR PROCESSING REQUESTS----");
			System.out.println("0 - to exit. 'requestId' - to process.");
			if(this.managerPosition.equals(ManagerPosition.OR)) {
				Data.getInstance().getRequests().stream().filter(r->
						r.getHelpType().equals(HelpType.TRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY) ||
						r.getHelpType().equals(HelpType.TRANSCRIPT_FOR_THE_SEMESTER) ||
						r.getHelpType().equals(HelpType.CERTIFICATE_OF_EDUCATION_IN_ENGLISH) ||
						!r.getRequestStatus().equals(RequestStatus.NOT_ACCEPTED) ||
						r.getHelpType().equals(HelpType.TRANSCRIPT_FOR_THE_YEAR))
				.forEach(System.out::println);
				String choice = commonBuffer.readInput();
				if(choice.equals("0")) return;
				else processRequest(Integer.parseInt(choice)-1, false);
			}
			if(this.managerPosition.equals(ManagerPosition.DEANS_OFFICE)) {
				Data.getInstance().getRequests().stream().filter(r->
						r.getHelpType().equals(HelpType.COORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA) ||
						r.getHelpType().equals(HelpType.HELP_FOR_FINANCING_KAZENERGY) ||
						r.getHelpType().equals(HelpType.WORKAROUND_SHEET) ||
						r.getHelpType().equals(HelpType.REQUEST_FOR_CREATING_ORGAIZATION) ||
						!r.getRequestStatus().equals(RequestStatus.NOT_ACCEPTED) ||
						r.getHelpType().equals(HelpType.REQUEST_FOR_ACADEMIC_MOBILITY))
				.forEach(System.out::println);
				String choice = commonBuffer.readInput();
				if(choice.equals("0")) return;
				else processRequest(Integer.parseInt(choice)-1, true);
			}
			if(this.managerPosition.equals(ManagerPosition.DEPARTMENT)) {
				Data.getInstance().getRequests().stream().filter(r->
						r.getHelpType().equals(HelpType.RESTORING_ONAY_CARD) ||
						r.getHelpType().equals(HelpType.INFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT) ||
						r.getHelpType().equals(HelpType.HELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS) ||
						r.getHelpType().equals(HelpType.HELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES) ||
						!r.getRequestStatus().equals(RequestStatus.NOT_ACCEPTED) ||
						r.getHelpType().equals(HelpType.HELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER))
				.forEach(System.out::println);
				String choice = commonBuffer.readInput();
				if(choice.equals("0")) return;
				else processRequest(Integer.parseInt(choice)-1, false);
			}
		}
	}
	public void processRequest(int id, boolean needSign) {
		System.out.println(Data.getInstance().getRequests().get(id));
		if(needSign) {	
			Faculty faculty = Data.getInstance().getRequests().get(id).getFaculty();
			Data.getInstance().getDeans().stream()
			.filter(d->d.getFaculty().equals(faculty))
			.forEach(d->d.setIncomingRequests(Data.getInstance().getRequests().get(id)));
			Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.ACCEPTED);
		}
		else {
			System.out.println("'0' - ACCEPTED, '1' - APPROVED, '2' - NOT_APPROVED");
			String choose = commonBuffer.readInput();
			if(choose.equals("0"))
				Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.ACCEPTED);
			if(choose.equals("1"))
				Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.APPROVED);
			if(choose.equals("2"))
				Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.NOT_APPROVED);
		}
	}

	public void viewLessonSchedule() {
		System.out.println("----WINDOW STUDENT'S/TEACHER'S LESSON SCHEDULE");
		System.out.println("'0' - to exit. 'Student', 'Teacher' - to check Schedule.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			if(choice.equals("Student")) {
				System.out.println("Student Username: ");
				String name = commonBuffer.readInput();
				Data.getInstance().getStudents().stream().filter(s->s.getUsername().equals(name)).forEach(s->s.viewLessonSchedule());
			}
			if(choice.equals("Teacher")) {
				System.out.println("Teacher Username: ");
				String name = commonBuffer.readInput();
				Data.getInstance().getStudents().stream().filter(s->s.getUsername().equals(name)).forEach(s->s.viewLessonSchedule());
			}
		}
	}
	public void viewUserPersonalData() {
		System.out.println("----WINDOW FOR VIEWING PERSON'S DATA----");
		System.out.println("'0' - to exit. 'username' - to check info.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			Data.getInstance().getUsers().entrySet().stream()
	        .filter(entry -> entry.getKey().equals(choice))
	        .map(Map.Entry::getValue)
	        .findFirst()
	        .ifPresent(user -> user.getUserInformation());
		}
	}

	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. View Academic Statistics\n2. Add/Drop Discipline\n3. View Student/Teacher Lesson Schedule"
					+ "\n4. View My Requests\n5. Edit My Personal Datas\n6. View Newa\n7. View User's Personal Datas"
					+ "\n8. View Requests From Users\n9. View Discipline Schedule\n10. View Student Exam Schedule"
					+ "\n11. Discipline Registration\n12. View My Social Transcript"
					+ "\n13. View Office Hour Schedule\n14. Research Cabinet\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					return;
				case "1":
					this.viewAcademicStatistics();
					break;
				case "2":
					this.viewLessonSchedule();//done
					break;
				case "3":
					this.viewRequests();//done
					break;
				case "4":
					this.editPersonalData();//done
					break;
				case "5":
					this.viewNews();//done
					break;
				case "6":
					this.viewUserPersonalData();//done
					break;
				case "7":
					this.viewRequestsFromUsers();//done
					break;
				case "8":
					this.viewDisciplineSchedule();//done
					break;
				case "9":
					this.viewStudentExamSchedule();//done
					break;
				case "10":
					this.viewSocialTranscript();//done
					break;
				case "11":
					this.viewOfficeHourSchedule();//done
					break;
				case "12":
					this.researchCabinet();//done
					break;
				case "13":
					this.postNews();//done
			}
		}
	}
	private void viewStudentExamSchedule() {
		System.out.println("----WINDOW STUDENT'S EXAM SCHEDULE");
		System.out.println("'0' - to exit. 'username' - to check info.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			Data.getInstance().getStudents().stream().filter(s->s.getUsername().equals(choice)).forEach(s->s.viewExamsSchedule());
		}
	}

	private void viewDisciplineSchedule() {
		System.out.println("----WINDOW STUDENT'S DISCIPLINE SCHEDULE");
		System.out.println("'0' - to exit. 'username' - to check info.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			Data.getInstance().getStudents().stream().filter(s->s.getUsername().equals(choice)).forEach(s->s.viewDisciplineSchedule());
		}
		
	}

	public void viewOrganizations() {
		System.out.println("----WINDOW ORGANIZATIONS");
		System.out.println("'0' - to exit.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			Data.getInstance().getStudents().forEach(System.out::println);
		}
	}
	public void viewOfficeHourSchedule() {
		System.out.println("----WINDOW TEACHER'S OFFICE HOUR SCHEDULE");
		System.out.println("'0' - to exit. 'username' - to check info.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else {
			Data.getInstance().getTeachers().stream().filter(s->s.getUsername().equals(choice)).forEach(s->s.viewOfficeHourSchedule());
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
	@Override
	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
	}

	@Override
	public String toString() {
		return super.toString() + "\nManager Position" + managerPosition;
	}
    
}
