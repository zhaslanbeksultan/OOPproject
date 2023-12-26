package users;
import java.io.IOException;
import java.util.Date;
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
    private Vector<Course> coursesRegisterTo = new Vector<>();

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
	}


	public ManagerPosition getManagerPosition() {
        return this.managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
    	if(managerPosition.equals("OR")) {
        	this.managerPosition = ManagerPosition.OR;}
    	if(managerPosition.equals("DEANS_OFFICE")) {
        	this.managerPosition = ManagerPosition.DEANS_OFFICE;}
    	if(managerPosition.equals("DEPARTMENT")) {
        	this.managerPosition = ManagerPosition.DEPARTMENT;}
    }

    public Vector<Course> getCoursesRegisterTo() {
        return this.coursesRegisterTo;
    }

    public void setCoursesRegisterTo(Vector<Course> coursesRegisterTo) {
        this.coursesRegisterTo = coursesRegisterTo;
    }
    public void createCourse() {
    	Course course = new Course();
    	System.out.println("Enter name of the course:");
    	String input=commonBuffer.readInput();
    	course.setCourseName(input);
    	System.out.println("Enter ID of the course:");
    	input=commonBuffer.readInput();
    	course.setCourseId(input);
    	System.out.println("Enter ECTS of the course:");
    	input=commonBuffer.readInput();
    	course.setNumberOfCredits(Integer.parseInt(input));
//    	System.out.println("Choose faculty: SITE, SEOGI, SG, SNSS, BS, ISE, KMA, SAM, SMSGT, SCE");
//    	input=commonBuffer.readInput();
//    	Faculty faculty;
//    	if(input.equals("SITE")) {
//    		faculty=Faculty.SITE;
//    	}
    	Data.getInstance().addCourse(course);
    	try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println("New course added to the system!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
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
			System.out.println("1. View Academic Statistics\n2. View Student/Teacher Lesson Schedule"
					+ "\n3. View My Requests\n4. Edit My Personal Datas\n5. View News\n6. View User's Personal Datas"
					+ "\n7. View Requests From Users\n8. View Discipline Schedule\n9. View Student Exam Schedule"
					+ "\n10. View My Social Transcript\n11. View Office Hour Schedule\n12. Research Cabinet\n13. Create new Course"
					+ "\n14. Post News\n15. Send Message\n16. Show Incoming Messages\n17. Edit Courses\n0.Log Out");
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
					this.createCourse();//done
					break;
				case "14":
					this.postNews();//done
					break;
				case "15":
					this.sendMessage();//done
					break;
	    		case "16":
	    			this.showMessages();//done
	    			break;
	    		case "17":
	    			this.editCourses();//done
	    			break;
			}
		}
	}
	public void editCourses() {
		
			System.out.println("Available courses to edit:");
			for(Course course: Data.getInstance().getCourses()) {
				System.out.println(course.getCourseName()+" "+course.getCourseId()+" "+course.getNumberOfCredits()+" "+course.getStudents().size());

			}
			while(true) {
				System.out.println("Enter courseID or type 0 to exit:");
				
				String courseID = commonBuffer.readInput();
				if(courseID.equals("0")) {
					break;
				}
				Course course;
				for(Course course1: Data.getInstance().getCourses()) {
				
					if(course1.getCourseId().equals(courseID)) {
						course1.editCourse();
						break;
					}
				}
				System.out.println("There is no course with this ID!");
			}
			try {
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	@Override
    public void editPersonalData() {
    	while(true) {
    		System.out.println(this);
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number"
    				+ "\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username\n12.Set Email\n13.Set Manager Position");
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
    		else if(choose.equals("13")) {System.out.println("Write a Manager Position: "); setManagerPosition(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
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
