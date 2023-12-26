package users;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import app.Login;
import common.*;
import communication.*;
import education.*;
import enums.*;
import userCapabilities.*;
public class Student extends User implements CanBorrowBook, Educationable, Serializable, Subscriber, Researcher	{

	private static final long serialVersionUID = 1L;
	private double[] gpa;
    private int studyYear;
    private Faculty faculty;
    private Date enrollmentDate;
    private Category category;
    private Vector<Course> CourseEnrolled;
    private String major;    
    private Vector<Organization> organizations = new Vector<>();
    private HashMap<Lesson, Mark> marks;
	private int availableECTS;

	{
		CourseEnrolled= new Vector<Course>();
	}
    public Student(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, int studyYear, Faculty faculty, Date enrollmentDate, Category category, String major) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.studyYear = studyYear;
		this.faculty = faculty;
		this.category = category;
		this.enrollmentDate = enrollmentDate;
		this.major = major;
		this.availableECTS=21;
		this.gpa = new double[4];
	}

	public Student() {
	}
	public void setAvailiableECTS(int num) {
		this.availableECTS=num;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if(category.equals("STUDENT")) {
			this.category = Category.STUDENT;
		}
		else if (category.equals("LISTENER")) {
			this.category = Category.LISTENER;
		} else if (category.equals("APEC_STUDENT")) {
			this.category = Category.APEC_STUDENT;
		} else if (category.equals("FS_STUDENT")) {
			this.category = Category.FS_STUDENT;
		} else if (category.equals("EXCHANGE_STUDENT")) {
			this.category = Category.EXCHANGE_STUDENT;
		} else if (category.equals("LISTENER_UOL")) {
			this.category = Category.LISTENER_UOL;
		} else if (category.equals("CONDITIONALLY_ENROLLED")) {
			this.category = Category.CONDITIONALLY_ENROLLED;
		} else if (category.equals("STUDENT_SOCIAL_CATEGORY1_2")) {
			this.category = Category.STUDENT_SOCIAL_CATEGORY1_2;
		} else if (category.equals("STUDENT_SOCIAL_CATEGORY3_4")) {
			this.category = Category.STUDENT_SOCIAL_CATEGORY3_4;
		} else {
	    System.out.println("Invalid category: " + category);
	}
	}

	private void setGpa(double gpa) {
        this.gpa[studyYear-1] = gpa;
    }
    private int getStudyYear() {
        return this.studyYear;
    }
    private void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    private void setFaculty(String faculty) {
    	if (faculty.equals("SITE")) {
    	    this.faculty = Faculty.SITE;
    	} else if (faculty.equals("SEOGI")) {
    	    this.faculty = Faculty.SEOGI;
    	} else if (faculty.equals("SG")) {
    	    this.faculty = Faculty.SG;
    	} else if (faculty.equals("SNSS")) {
    	    this.faculty = Faculty.SNSS;
    	} else if (faculty.equals("BS")) {
    	    this.faculty = Faculty.BS;
    	} else if (faculty.equals("ISE")) {
    	    this.faculty = Faculty.ISE;
    	} else if (faculty.equals("KMA")) {
    	    this.faculty = Faculty.KMA;
    	} else if (faculty.equals("SAM")) {
    	    this.faculty = Faculty.SAM;
    	} else if (faculty.equals("SMSGT")) {
    	    this.faculty = Faculty.SMSGT;
    	} else if (faculty.equals("SCE")) {
    	    this.faculty = Faculty.SCE;
    	} else {
    	    System.out.println("Invalid faculty: " + faculty);
    	}

    }
    private Date getEnrollmentDate() {
        return this.enrollmentDate;
    }
    private void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    private Vector<Course> getCourseEnrolled() {
        return this.CourseEnrolled;
    }
  

    private String getMajor() {
        return this.major;
    }    
    private void setMajor(String major) {
        this.major = major;
    }

    public Vector<Organization> getOrganizations() {
        return this.organizations;
    }
    public void setOrganizations(Organization organization) {
        this.organizations.add(organization);
    }

    public double[] getGpa() {
        return this.gpa;
    }
    
    public String getTranscipt() {
        return null;
    }

	public void enterCourse(Course course) {
		this.CourseEnrolled.add(course);
		course.addStudent(this);
	}
	public void dropCourse(Course course) {
		this.CourseEnrolled.remove(course);
	}
	
	public void disciplineRegistration(String discipline, boolean isRegistrationAllowed) {//isRegistrationAllowed is a static method in Admin
		this.viewAvailableCourses();
		System.out.println("Please choose:\n1.Major\n2.Minor");
		String input=commonBuffer.readInput();
		System.out.println("Please enter course's ID:");
    	input = commonBuffer.readInput();
    	for(Course course:Data.getInstance().getCourses()) {
    		if(course.getCourseId().equals(input)) {
    			if(this.availableECTS<course.getNumberOfCredits()) {
    				System.out.println("Not enough credits!\nPress any key");
    				input = commonBuffer.readInput();
    			}
    			else {
    				this.availableECTS-=course.getNumberOfCredits();
    				this.CourseEnrolled.add(course);
    				course.addStudent(this);
    			}
    		}
    	}
    	
    	
	}
	
	public void borrowBook(String bookName) {
		if(Book.isBookAvailable(bookName)) {
			for(Book book: Data.getInstance().getBooks()) {
				if(book.getBookName().equals(bookName)) {
					book.setBorrowed(true);
					book.setReader(this);
				}
			}
		}
	}


	
	public void returnBook(String bookName) {
		for(Book book: Data.getInstance().getBooks()) {
			if(book.getReader().getUsername().equals(this.getUsername()) && book.getBookName().equals(bookName)) {
				book.setBorrowed(false);
				book.setReader(null);
			}
		}
	}
    
	public HashMap<Lesson, Mark> getMarks() {
	        return getMarks();
	    }

	public void addMark(Lesson lesson, Mark mark) {
			marks.put(lesson, mark);
	    }
	
	public void addDropDiscipline() {
		System.out.println("ADD/DROP WINDOW");
		System.out.println("Enter a semester: ");
		int semester = Integer.parseInt(commonBuffer.readInput());
		System.out.println("Enter an ECTS: ");
		int ects = Integer.parseInt(commonBuffer.readInput());
//		this.viewAvailableCourse(this.faculty, semester, ects);//Надо узнать подробнее. Потом сделать.
	}
	@Override
	public void addRequest() {
		while(true) {
			System.out.println("----ADD REQUEST WINDOW----");
			System.out.println("Select the Form: 'Paper', 'Electronic'");
			String form = commonBuffer.readInput(); 
			System.out.println("Select the Type:\nREQUEST_FOR_ACADEMIC_MOBILITY\nCOORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA\nWORKAROUND_SHEET"
					+ "\nCERTIFICATE_OF_EDUCATION_IN_ENGLISH\nRESTORING_ONAY_CARD\nHELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"
					+ "\nHELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES\nHELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"
					+ "\nHELP_FOR_FINANCING_KAZENERGY\nINFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT\nTRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY"
					+ "\nTRANSCRIPT_FOR_THE_YEAR\nTRANSCRIPT_FOR_THE_SEMESTER\nREQUEST_FOR_CREATING_ORGAIZATION");
			String type = commonBuffer.readInput();
			System.out.println("Select the Language: 'EN', 'RU', 'KZ'");
			String language = commonBuffer.readInput();
			Request request = new Request(this.getUsername(), form, type, language, this.getFaculty());
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
	public void viewJournal() {}
	public void attendanceMark() {}
	public void viewDisciplineSchedule() {}
	public void registrationForFx() {}
	public void viewTranscript() {}
	@Override
	public void viewExamsSchedule() {}
		
	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Transcript\n2. ADD/DROP Disciplines\n3. Journal\n4. Requests\n5. Personal Datas\n6. News\n7. Attendance Mark"
					+ "\n8. View Attestation\n9. Discipline Schedule\n10. Lesson Schedule\n11. Exams Schedule\n12. Registration For FX"
					+ "\n13. Registration For Disciplines\n14. Social Transcript\n15. View Office Hours Schedule\n16. Research Cabinet"
					+ "\n17. View Organizations\n18. Send Message\n19. Show Incoming Messages\n20. View All Books\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					return;
				case "1":
					this.viewTranscript();
					break;
				case "2":
					this.addDropDiscipline();
					break;
				case "3":
					this.viewJournal();
					break;
				case "4":
					this.viewRequests();
					break;
				case "5":
					this.editPersonalData();
					break;
				case "6":
					this.viewNews();
					break;
				case "7":
					this.attendanceMark();
					break;
				case "8":
					this.viewAttestation();
					break;
				case "9":
					this.viewDisciplineSchedule();
					break;
				case "10":
					this.viewLessonSchedule();
					break;
				case "11":
					this.viewExamsSchedule();
					break;
				case "12":
					this.registrationForFx();
					break;
				case "13":
					this.disciplineRegistration(choice, false);
					break;
				case "14":
					this.viewSocialTranscript();
					break;
				case "15":
					this.viewOfficeHourSchedule();
					break;
				case "16":
					this.researchCabinet();
					break;
				case "17":
					this.viewOrganizations();
					break;
	    		case "18":
	    			this.sendMessage();
	    			break;
	    		case "19":
	    			this.showMessages();
	    			break;
	    		case "20":
	    			this.viewAllBooks();
	    			break;
			}
		}
	}
	
	@Override
	public void viewAllBooks() {
		while(true) {
			System.out.println("----WINDOW ALL BOOKS----");
			System.out.println("'0' - to exit.'1' - to borrow book. '2' - to return book.");
			Data.getInstance().getBooks().forEach(System.out::println);
			String choice = commonBuffer.readInput();
			if(choice.equals("0")) {return;}
			else if(choice.equals("1")) {
				System.out.println("Write Book Name: ");
				String bookName = commonBuffer.readInput();
				this.borrowBook(bookName);}
			else if(choice.equals("2")) {
				System.out.println("Write Book Name: ");
				String bookName = commonBuffer.readInput();
				this.returnBook(bookName);}
		}
	}
	
	public void viewOrganizations() {
		while(true) {
			System.out.println("----ORGANIZATIONS----");
			System.out.println("'0' - to exit. '1' - Create Organization. '2' - Organize Event. '3' - Remove Member. 'Organization Name' - to join.");
			Data.getInstance().getOrganizations().forEach(System.out::println);
			String choice = commonBuffer.readInput();
			if(choice.equals("0")) return;
			else if(choice.equals("1")) {
				boolean hasApprovedRequest = Data.getInstance().getRequests().stream()
					    .filter(f -> f.getRequester().equals(this.getUsername()) && 
					                 f.getHelpType().equals(HelpType.REQUEST_FOR_CREATING_ORGAIZATION) &&
					                 f.getRequestStatus().equals(RequestStatus.APPROVED))
					    .anyMatch(request -> true);
				if(!hasApprovedRequest) {
					System.out.println("Organizations are created only with the consent of the dean!");
					continue;
				}
				System.out.println("Enter Organization Name: ");
				String name = commonBuffer.readInput();
				System.out.println("Enter Information About Organization: ");
				String info = commonBuffer.readInput();
				Organization organization = new Organization(name, info, this.getUsername());
				Data.getInstance().setOrganizations(organization);
			}
			else if(choice.equals("2")) {
				boolean head = Data.getInstance().getOrganizations().stream()
					    .filter(f -> f.getHead().equals(this.getUsername()))
					    .anyMatch(request -> true);
				if(!head) {
					System.out.println("Only the head of the organization can organize events!");
					continue;
				}
				System.out.println("Enter Announcment Title: ");
				String title = commonBuffer.readInput();
				System.out.println("Enter Announcment Words: ");
				String text = commonBuffer.readInput();
				System.out.println("Recipient 'All', 'Employees', 'Students': ");
				String recipient = commonBuffer.readInput();
				News post = new News(recipient, title, text);
				Data.getInstance().setNews(post);
			}
			else if(choice.equals("3")) {
				boolean head = Data.getInstance().getOrganizations().stream()
					    .filter(f -> f.getHead().equals(this.getUsername()))
					    .anyMatch(request -> true);
				if(!head) {
					System.out.println("Only the head of the organization can remove members!");
					continue;
				}
				System.out.println("Enter Member Username: ");
				String username = commonBuffer.readInput();
				Data.getInstance().getOrganizations().stream()
				.filter(h->h.getHead().equals(this.getUsername()))
				.forEach(h->h.removeMembers(username));;
			}
			else {Data.getInstance().getOrganizations().stream()
				.filter(o -> o.getOrganizationName().equals(choice))
				.forEach(o -> o.setMembers(this.getUsername()));
			}
		}

	}
	
    @Override
    public void researchCabinet() {
    	while(true) {
    		System.out.println("----RESEARCH CABINET----");
    		System.out.println("'0' - to exit.\n'1' - Show All Research Papers\n'2' - Show All Research Journals"
    				+ "\n'3' - Show Papers Of Subscribed Journals\n'5' - Top Cited Researcher\n'6' - Show My Research Papers"
    				+ "\n'7' - Add Research Paper\n'8' - Create Research Project");
    		String choice = commonBuffer.readInput();
    		switch(choice) {
    		case "0":
    			return;
    		case "1":
    			this.showAllResearchPapers();
    			break;
    		case "2":
    			this.showAllJournals();
    			break;
    		case "3":
    			this.showPapersOfSubscribedJournals();
    			break;
    		case "4":
    			System.out.println(this.findHIndex()); 
    			break;
    		case "5":
    			this.topCitedResearcher();
    			break;
    		case "6":
    			this.showMyPapers();
    			break;
    		case "7":
    			this.addResearchPaper();
    			break;
    		case "8":
    			this.createResearchProject();
    			break;
    		}
    	}
    }
    
    @Override
    public void createResearchProject() {
		try {
			if (this.findHIndex() < 3)
				throw new LowHIndexException("Supervisor's h-index is less than 3.");
		}catch(LowHIndexException e){
			System.out.println(e.getMessage());
			return;
		}
    	System.out.println("----WINDOW FOR CREATING RESEARCH PROJECT");
    	System.out.println("Write Journal Name: ");
    	String journalName = commonBuffer.readInput();
    	System.out.println("Write Project Topic: ");
    	String topic = commonBuffer.readInput();
    	ResearchProject project = new ResearchProject(journalName, topic, this.getUsername());
    	Data.getInstance().setResearchProjects(project);
    }
    
    @Override
    public void addResearchPaper() {
    	try {
	    	if(!(this instanceof Researcher)) {
	    		throw new InvalidResearcherException("Only Researchers Can Add Research Papers!");
	    	}
    	}catch(InvalidResearcherException e) {
            System.err.println(e.getMessage());
            return;
    	}
    	System.out.println("----WINDOW FOR RESEARCHING----");
    	while(true) {
        	System.out.println("'0' - to exit.'1' - Add Paper.");
    		String choice = commonBuffer.readInput();
    		switch(choice) {
    		case "0":
    			return;
    		case "1":
    			System.out.println("Research Project Name: ");
    			String researchProject = commonBuffer.readInput();
    			System.out.println("Paper Title: ");
    			String title = commonBuffer.readInput();
    			System.out.println("Paper Wording: ");
    			String wording = commonBuffer.readInput();
    			ResearchPaper paper = new ResearchPaper(researchProject, title, wording, this.getUsername());
    			System.out.println("Links To The Papers Used In Research: ");
    			while(true) {
    				System.out.println("'0' - end adding references.");
    				String reference = commonBuffer.readInput();
    				if(reference.equals("0")) break;
    				paper.setReferences(reference);
    			}
    			Data.getInstance().setResearchPapers(paper);
    			Data.getInstance().getResearchProjects().stream()
    				.filter(p->p.getJournalName().equals(paper.getResearchProject()))
    				.forEach(p->p.setPublishedPapers(paper));
    			Data.getInstance().getResearchProjects().stream()
					.filter(p->p.getJournalName().equals(paper.getResearchProject()))
					.forEach(p->p.setParticipants(this.getUsername()));
    			News post = new News("All", "Research", "A New Research Article From: " + this.getUsername() + "Research Title: " + title);
    			Data.getInstance().getNews().add(post);
    			break;
    		}
    	}
    }
    @Override
    public void showMyPapers() {
    	System.out.println("----MY RESEARCH PAPERS----");
    	System.out.println("Choose sorting order: 'Length', 'Citations', 'Date'");
    	String choice = commonBuffer.readInput();
    	switch(choice) {
    	case("Length"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByArticleLengthComparator())
    		.forEach(System.out::println);
    		this.readPaper();
    		break;
    	case("Citations"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByCitationComparator())
    		.forEach(System.out::println);
    		this.readPaper();
    		break;
    	case("Date"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByDateComparator())
    		.forEach(System.out::println);
    		this.readPaper();
    		break;
    	}
    }
    public void viewAvailableCourses() {
    	Vector<Course> availableMajor = new Vector<>();
    	Vector<Course> availableMinor = new Vector<>();
    	for(int i=0; i<Data.getInstance().getCourses().size();i++) {
    		if(Data.getInstance().getCourses().elementAt(i).getSpecialty().getFaculty().equals(this.getFaculty())) {
    			availableMajor.add(Data.getInstance().getCourses().elementAt(i));
    		}
    		else {
    			availableMinor.add(Data.getInstance().getCourses().elementAt(i));
    		}
    	}
    	System.out.println("Available Majors:");
    	for(Course course: availableMajor) {
    		System.out.println(course.getCourseName() + " "+ course.getCourseId() + " "+ course.getNumberOfCredits());
    	}
    	System.out.println("Available Minors:");
    	for(Course course: availableMinor) {
    		System.out.println(course.getCourseName() + " "+ course.getCourseId() + " "+ course.getNumberOfCredits());
    	}
    }
//	public void viewAvailableCourse(Faculty faculty, int semester, int ects) {
//		this.courseList = new Vector<Course>();
//		if (faculty == Faculty.SITE) {
//        	if(semester==1) {
//	        	courseList.add(new Course( "Programming Principles I", 6));
//	            courseList.add(new Course( "Calculus I", 5));
//	            courseList.add(new Course("Discrete Structures", 5));
//	            courseList.add(new Course("English", 10));
//            }
//        	else if(semester == 2) {
//	        	courseList.add(new Course( "Programming Principles II", 6));
//        	    courseList.add(new Course( "Calculus II", 5));
//        	    courseList.add(new Course( "Physics I", 5));
//        	    courseList.add(new Course( "Statistics ", 5));
//        	    courseList.add(new Course( "Merging Personal and Global Evolution", 8));
//        	    courseList.add(new Course( "Linear Algebra", 5));
//            }
//            else if(semester == 3) {
//        	    courseList.add(new Course( "Databases", 5));
//        	    courseList.add(new Course( "Algorithms and Data Structure", 5));
//        	    courseList.add(new Course( "Computer Architecture", 5));
//        	    courseList.add(new Course( "Object-Oriented Programming and Design", 5));
//        	    courseList.add(new Course( "Physical Education I", 4));
//        	    courseList.add(new Course( "Kazakh/Russian Language", 5));
//            }
//            else if (semester == 4) {
//        	    courseList.add(new Course( "WEB Development ", 6));
//        	    courseList.add(new Course( "Computer NetWorks", 6));
//        	    courseList.add(new Course( "Introduction to Business Management", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Physical Education II", 4));
//        	    courseList.add(new Course( "Kazakh Language", 5));
//            }
//            else if(semester == 5) {
//        	    courseList.add(new Course( "Software Engineering", 5));
//        	    courseList.add(new Course( "Fundamentals of Business for Information Systems", 5));
//        	    courseList.add(new Course( "Basics of Information Systems", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Information and Communication Technology", 5));
//        	    courseList.add(new Course( "History of Kazakhstan", 5));
//            }
//            else if(semester == 6) {
//        	    courseList.add(new Course( "Fields Projects for Information Systems", 5));
//        	    courseList.add(new Course( "Cyber Security Fundamentals", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Philosophy", 5));
//            }
//            else if(semester == 7) {
//        	    courseList.add(new Course( "IT Project Management ", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));
//        	    courseList.add(new Course( "Elective", 5));	   
//           }
//            else if (semester == 8) {
//        	    courseList.add(new Course( "Research Tools and Methods", 4));
//        	    courseList.add(new Course( "Pre-diploma Internship", 5));
//        	    courseList.add(new Course( "Final attestation", 8));
//        	    courseList.add(new Course( "Elective", 5));
//            }
//        }
//        else if (faculty == Faculty.SEOGI) {
//        	if(semester==1) {
//        		courseList.add(new Course( "Kazakh/Russian Language", 5));
//	        	courseList.add(new Course( "English language", 10));
//	        	courseList.add(new Course("Modern history of Kazakhstan", 5));
//	        	courseList.add(new Course("Physical Education I", 4));
//	        	courseList.add(new Course("Introducation to petroleum engineering", 5));
//	        	}
//            else if(semester == 2) {
//             	courseList.add(new Course( "Kazakh/Russian Language", 5));
//             	courseList.add(new Course( "Physics I", 5));
//             	courseList.add(new Course( "Physical education II", 4));
//             	courseList.add(new Course( "Merging Personal and Global Evolution", 8));
//             	courseList.add(new Course( "Calculus I", 5));
//            }
//            else if(semester == 3) {
//             	courseList.add(new Course( "Petroleum Chemistry", 5));
//             	courseList.add(new Course( "Calculus II ", 6));
//             	courseList.add(new Course( "Teoretical and Applied Mechanics", 5));
//             	courseList.add(new Course( "Physics II ", 5));
//             	courseList.add(new Course( "Information and Communication Technologies ", 4));
//             	courseList.add(new Course( "Descriptive geometry and engineering graphics", 4));
//            }
//            else if (semester == 4) {
//             	courseList.add(new Course( "Strength of materials", 5));
//             	courseList.add(new Course( "Differential equations", 5));
//             	courseList.add(new Course( "Physical Geology", 5));
//             	courseList.add(new Course( "Philosophy", 5));
//             	courseList.add(new Course( "Drilling oil ang gas wells ", 5));
//             	courseList.add(new Course( "Introductory Internship", 4));
//                }
//            else if(semester == 5) {
//         	    courseList.add(new Course( "Production Technology(with practice) ", 5));
//         	    courseList.add(new Course( "Numerical methods. Matlab", 5));
//         	    courseList.add(new Course( "Fluid Mechanics", 5));
//         	    courseList.add(new Course( "Reservoir Engineering", 5));
//         	    courseList.add(new Course( "Petroleum Geology", 5));
//         	    courseList.add(new Course( "Specialization discipline ", 5));
//            }
//            else if(semester == 6) {
//         	    courseList.add(new Course( "Pipeline Engineering(with practice)", 5));
//         	    courseList.add(new Course( "Well logging", 5));
//         	    courseList.add(new Course( "Thermodynamics and heat engineering ", 5));
//         	    courseList.add(new Course( "Specialization discipline", 5));
//         	    courseList.add(new Course( "Elective", 5));
//         	    courseList.add(new Course( "Specialization discipline", 5));
//            }
//            else if(semester == 7) {
//         	    courseList.add(new Course( "Industrial safety", 5));
//         	    courseList.add(new Course( "Fundamentals of financial analysis", 5));
//         	    courseList.add(new Course( "Gathering and Preparation Well Production", 5));
//         	    courseList.add(new Course( "Workover", 5));
//         	    courseList.add(new Course( "Specialization discipline", 5));
//         	    courseList.add(new Course( "Elective", 5));	   
//            }
//            else if (semester == 8) {
//         	    courseList.add(new Course( "Industrial  Internship", 8));
//         	    courseList.add(new Course( "Graduation Project Internship", 5));
//         	    courseList.add(new Course( "Preparation and Defense of the graduation work", 12));
//            }
//        }
//        if(courseList.isEmpty()) {
//	        if(Login.language == Language.ENGLISH ) {
//	        	System.out.println("No available disciplines to register! ");
//	        }
//	        else if(Login.language == Language.KAZAKH ) {
//	        	System.out.println("Registras`iyag`a mumkin bolatyn sabaq joq!");	
//	        }
//	        else {
//	        	System.out.println("Нет доступных дисциплин для регистрации !");
//	        }
//	    }
//	    else {
//	        for (Course element : courseList) {
//	        	System.out.println(element);
//	        }
//	    }
        
//courseList.clear();
        	
//    }

	@Override
	public String toString() {
		return super.toString() + "\n Study Year = " + studyYear + "\n Faculty="
				+ faculty + "\n enrollmentDate=" + enrollmentDate + "\n Major=" + major + "\n Organizations = " + organizations;
	}

	@Override
	public void viewAttestation() {
        System.out.println("---- ATTESTATION RESULTS ----");
        for(Course course: this.getCourseEnrolled()) {
        	course.viewStudentAttestation(this);
        }
        System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    }
	
	@Override
    public void editPersonalData() {
    	while(true) {
    		System.out.println(this);
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number"
    				+ "\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username\n12.Set Email\n13.Set Faculty\n14.Set Category");
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
    		else if(choose.equals("13")) {System.out.println("Write a faculty: "); setFaculty(commonBuffer.readInput());}
    		else if(choose.equals("14")) {System.out.println("Write a category: "); setCategory(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
	    }
    }

	@Override
	public void viewLessonSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOfficeHourSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override

	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
	}


	public boolean addDiscipline(Course discipline) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
