package users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import app.Login;
import common.*;
import communication.*;
import education.*;
import enums.*;
import userCapabilities.*;
public class Student extends User implements CanBorrowBook, Educationable, Administrationable, Serializable {
    private double gpa;
    private int studyYear;
    private Faculty faculty;
    private Date enrollmentDate;
    private Category category;
    private Vector<Course> coursesEnrolled;
    private String major;    
    private Vector<Organization> organizations;
    private HashMap<Lesson, Mark> marks;
	private Vector<Courses> courseList;

    public Student(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double gpa, int studyYear, Faculty faculty, Date enrollmentDate, Category category,
			Vector<Course> coursesEnrolled, String major, Vector<Organization> organizations) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.gpa = gpa;
		this.studyYear = studyYear;
		this.faculty = faculty;
		this.category = category;
		this.enrollmentDate = enrollmentDate;
		this.coursesEnrolled = coursesEnrolled;
		this.major = major;
		this.organizations = organizations;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private void setGpa(double gpa) {
        this.gpa = gpa;
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

    private void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    private Date getEnrollmentDate() {
        return this.enrollmentDate;
    }
    private void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    private Vector<Course> getCoursesEnrolled() {
        return this.coursesEnrolled;
    }
    private void setCoursesEnrolled(Course course) {
        this.coursesEnrolled.add(course);
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

    public double getGpa() {
        return this.gpa;
    }
    public String getReport() {
        //TODO
        return "";
    }
    public String getTranscipt() {
        //TODO
        return null;
    }

	public int getCourse() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed) {//isRegistrationAllowed is a static method in Admin
		// TODO Auto-generated method stub
		return false;
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
	
	@Override
	public void addDropDiscipline() {
		System.out.println("ADD/DROP WINDOW");
		System.out.println("Enter a semester: ");
		int semester = Integer.parseInt(commonBuffer.readInput());
		System.out.println("Enter an ECTS: ");
		int ects = Integer.parseInt(commonBuffer.readInput());
		this.viewAvailableCourses(this.faculty, semester, ects);//Надо узнать подробнее. Потом сделать.
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
					+ "\nTRANSCRIPT_FOR_THE_YEAR\nTRANSCRIPT_FOR_THE_SEMESTER");
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
					+ "\n13. Registration For Disciplines\n14. Social Transcript\n15. View Office Hours Schedule\n0.Log Out");
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
			}
		}
	}
	
	public void viewAvailableCourses(Faculty faculty, int semester, int ects) {
		this.courseList = new Vector<Courses>();
		if (faculty == Faculty.SITE) {
        	if(semester==1) {
	        	courseList.add(new Courses( "Programming Principles I", 6));
	            courseList.add(new Courses( "Calculus I", 5));
	            courseList.add(new Courses("Discrete Structures", 5));
	            courseList.add(new Courses("English", 10));
            }
        	else if(semester == 2) {
	        	courseList.add(new Courses( "Programming Principles II", 6));
        	    courseList.add(new Courses( "Calculus II", 5));
        	    courseList.add(new Courses( "Physics I", 5));
        	    courseList.add(new Courses( "Statistics ", 5));
        	    courseList.add(new Courses( "Merging Personal and Global Evolution", 8));
        	    courseList.add(new Courses( "Linear Algebra", 5));
            }
            else if(semester == 3) {
        	    courseList.add(new Courses( "Databases", 5));
        	    courseList.add(new Courses( "Algorithms and Data Structure", 5));
        	    courseList.add(new Courses( "Computer Architecture", 5));
        	    courseList.add(new Courses( "Object-Oriented Programming and Design", 5));
        	    courseList.add(new Courses( "Physical Education I", 4));
        	    courseList.add(new Courses( "Kazakh/Russian Language", 5));
            }
            else if (semester == 4) {
        	    courseList.add(new Courses( "WEB Development ", 6));
        	    courseList.add(new Courses( "Computer NetWorks", 6));
        	    courseList.add(new Courses( "Introduction to Business Management", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Physical Education II", 4));
        	    courseList.add(new Courses( "Kazakh Language", 5));
            }
            else if(semester == 5) {
        	    courseList.add(new Courses( "Software Engineering", 5));
        	    courseList.add(new Courses( "Fundamentals of Business for Information Systems", 5));
        	    courseList.add(new Courses( "Basics of Information Systems", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Information and Communication Technology", 5));
        	    courseList.add(new Courses( "History of Kazakhstan", 5));
            }
            else if(semester == 6) {
        	    courseList.add(new Courses( "Fields Projects for Information Systems", 5));
        	    courseList.add(new Courses( "Cyber Security Fundamentals", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Philosophy", 5));
            }
            else if(semester == 7) {
        	    courseList.add(new Courses( "IT Project Management ", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));
        	    courseList.add(new Courses( "Elective", 5));	   
           }
            else if (semester == 8) {
        	    courseList.add(new Courses( "Research Tools and Methods", 4));
        	    courseList.add(new Courses( "Pre-diploma Internship", 5));
        	    courseList.add(new Courses( "Final attestation", 8));
        	    courseList.add(new Courses( "Elective", 5));
            }
        }
        else if (faculty == Faculty.SEOGI) {
        	if(semester==1) {
        		courseList.add(new Courses( "Kazakh/Russian Language", 5));
	        	courseList.add(new Courses( "English language", 10));
	        	courseList.add(new Courses("Modern history of Kazakhstan", 5));
	        	courseList.add(new Courses("Physical Education I", 4));
	        	courseList.add(new Courses("Introducation to petroleum engineering", 5));
	        	}
            else if(semester == 2) {
             	courseList.add(new Courses( "Kazakh/Russian Language", 5));
             	courseList.add(new Courses( "Physics I", 5));
             	courseList.add(new Courses( "Physical education II", 4));
             	courseList.add(new Courses( "Merging Personal and Global Evolution", 8));
             	courseList.add(new Courses( "Calculus I", 5));
            }
            else if(semester == 3) {
             	courseList.add(new Courses( "Petroleum Chemistry", 5));
             	courseList.add(new Courses( "Calculus II ", 6));
             	courseList.add(new Courses( "Teoretical and Applied Mechanics", 5));
             	courseList.add(new Courses( "Physics II ", 5));
             	courseList.add(new Courses( "Information and Communication Technologies ", 4));
             	courseList.add(new Courses( "Descriptive geometry and engineering graphics", 4));
            }
            else if (semester == 4) {
             	courseList.add(new Courses( "Strength of materials", 5));
             	courseList.add(new Courses( "Differential equations", 5));
             	courseList.add(new Courses( "Physical Geology", 5));
             	courseList.add(new Courses( "Philosophy", 5));
             	courseList.add(new Courses( "Drilling oil ang gas wells ", 5));
             	courseList.add(new Courses( "Introductory Internship", 4));
                }
            else if(semester == 5) {
         	    courseList.add(new Courses( "Production Technology(with practice) ", 5));
         	    courseList.add(new Courses( "Numerical methods. Matlab", 5));
         	    courseList.add(new Courses( "Fluid Mechanics", 5));
         	    courseList.add(new Courses( "Reservoir Engineering", 5));
         	    courseList.add(new Courses( "Petroleum Geology", 5));
         	    courseList.add(new Courses( "Specialization discipline ", 5));
            }
            else if(semester == 6) {
         	    courseList.add(new Courses( "Pipeline Engineering(with practice)", 5));
         	    courseList.add(new Courses( "Well logging", 5));
         	    courseList.add(new Courses( "Thermodynamics and heat engineering ", 5));
         	    courseList.add(new Courses( "Specialization discipline", 5));
         	    courseList.add(new Courses( "Elective", 5));
         	    courseList.add(new Courses( "Specialization discipline", 5));
            }
            else if(semester == 7) {
         	    courseList.add(new Courses( "Industrial safety", 5));
         	    courseList.add(new Courses( "Fundamentals of financial analysis", 5));
         	    courseList.add(new Courses( "Gathering and Preparation Well Production", 5));
         	    courseList.add(new Courses( "Workover", 5));
         	    courseList.add(new Courses( "Specialization discipline", 5));
         	    courseList.add(new Courses( "Elective", 5));	   
            }
            else if (semester == 8) {
         	    courseList.add(new Courses( "Industrial  Internship", 8));
         	    courseList.add(new Courses( "Graduation Project Internship", 5));
         	    courseList.add(new Courses( "Preparation and Defense of the graduation work", 12));
            }
        }
        if(courseList.isEmpty()) {
	        if(Login.language == Language.ENGLISH ) {
	        	System.out.println("No available disciplines to register! ");
	        }
	        else if(Login.language == Language.KAZAKH ) {
	        	System.out.println("Registras`iyag`a mumkin bolatyn sabaq joq!");	
	        }
	        else {
	        	System.out.println("Нет доступных дисциплин для регистрации !");
	        }
	    }
	    else {
	        for (Courses element : courseList) {
	        	System.out.println(element);
	        }
	    }
        
//courseList.clear();
        	
    }

	@Override
	public String toString() {
		return super.toString() + "\n Study Year = " + studyYear + "\n Faculty="
				+ faculty + "\n enrollmentDate=" + enrollmentDate + "\n Major=" + major + "\n Organizations = " + organizations;
	}

	@Override
	public void viewAttestation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewLessonSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOfficeHourSchedule() {
		// TODO Auto-generated method stub
		
	}
	
}
