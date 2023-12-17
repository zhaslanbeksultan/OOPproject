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
    private Vector coursesTaught;
    private String major;    
    private Organizations organizations;
    private HashMap<Lesson, Mark> marks;

    public Student(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double gpa, int studyYear, Faculty faculty, Date enrollmentDate,
			Vector coursesTaught, String major, Organizations organizations) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship);
		this.gpa = gpa;
		this.studyYear = studyYear;
		this.faculty = faculty;
		this.enrollmentDate = enrollmentDate;
		this.coursesTaught = coursesTaught;
		this.major = major;
		this.organizations = organizations;
	}
    public Student() {
    	
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
    private Vector getCoursesTaught() {
        return this.coursesTaught;
    }
    private void setCoursesTaught(Vector coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    private String getMajor() {
        return this.major;
    }    
    private void setMajor(String major) {
        this.major = major;
    }

    public Organizations getOrganizations() {
        return this.organizations;
    }
    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }
    public Vector getCoursesEnrolled() {
        //TODO
        return null;
    }
    public double getGpa() {
        //TODO
        return 0.0;
    }
    public String getReport() {
        //TODO
        return "";
    }
    public HashMap getTranscipt() {
        //TODO
        return null;
    }

	public int getCourse() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean disciplineRegistration(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean addDiscipline(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}


	
	public boolean dropDiscipline(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}


	
	public boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed) {
		// TODO Auto-generated method stub
		return false;
	}


	
	public HashMap<Lesson, Integer> viewAttestation() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public Vector<String> viewDownloadedFiles() {
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
		
		public boolean dropDiscipline(Courses discipline) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public boolean addDiscipline(Courses discipline) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void showMenu() {
			// TODO Auto-generated method stub
			
		}
    
}
