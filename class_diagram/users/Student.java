package users;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

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
    private Vector<Course> coursesEnrolled;
    private String major;    
    private Vector<Organization> organizations;
    private HashMap<Lesson, Mark> marks;

    public Student(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double gpa, int studyYear, Faculty faculty, Date enrollmentDate,
			Vector<Course> coursesEnrolled, String major, Vector<Organization> organizations) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.gpa = gpa;
		this.studyYear = studyYear;
		this.faculty = faculty;
		this.enrollmentDate = enrollmentDate;
		this.coursesEnrolled = coursesEnrolled;
		this.major = major;
		this.organizations = organizations;
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


	
	public HashMap<Lesson, Integer> viewAttestation() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public HashMap<Lesson, WeekDays> viewLessonSchedule() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public HashMap<Teacher, WeekDays> viewOfficeHourSchedule() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public HashMap<String, Vector<Mark>> viewMarks() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean addDropDiscipline() {
			// TODO Auto-generated method stub
			return false;
	}
	public void academicMobility() {}
	public void viewJournal() {}
	public void viewRequests() {}
	public void attendanceMark() {}
	public void viewDisciplineSchedule() {}
	public void registrationForFx() {}
	public void viewSocialTranscript() {}
	@Override
	public void viewExamsSchedule() {}
		
	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Academic Mobility\n2. ADD/DROP Disciplines\n3. Journal\n4. Requests\n5. Personal Datas\n6. News"
					+ "\n7. Attendance Mark\n8. View Attestation\n9. Discipline Schedule\n10. Lesson Schedule\n11. Exams Schedule"
					+ "\n12. Registration For FX\n13. Registration For Disciplines\n14. Social Transcript\n15. Transcript"
					+ "\n16. View Office Hours Schedule\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					break;
				case "1":
					this.academicMobility();
				case "2":
					this.addDropDiscipline();
				case "3":
					this.viewJournal();
				case "4":
					this.viewRequests();
				case "5":
					System.out.println(this);;
				case "6":
					this.viewNews();
				case "7":
					this.attendanceMark();;
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
}
