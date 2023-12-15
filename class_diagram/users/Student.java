package users;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import education.Lesson;
import education.Mark;
import enums.*;
import userCapabilities.*;
public class Student extends User implements CanBorrowBook, Educationable, Administrationable {
    private double gpa;
    private int studyYear;
    private Faculty faculty;
    private Date enrollmentDate;
    private Vector coursesTaught;
    private String major;    
    private Organizations organizations;

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
	private void setGpa(double gpa) {
        this.gpa = gpa;
    }
    private int getStudyYear() {
        return this.studyYear;
    }
    private void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }
<<<<<<< HEAD
    
    
    /**
    * @generated
    */
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
=======
    private void setFaculty(Faculty faculty) {
>>>>>>> b64bc34648dab6a6511b649bb603b9d8687c9212
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
    public String getFaculty() {
        //TODO
        return "";
    }
    public String getReport() {
        //TODO
        return "";
    }
    public HashMap getTranscipt() {
        //TODO
        return null;
    }
<<<<<<< HEAD

	public int getCourse() {
		// TODO Auto-generated method stub
		return 0;
=======
	@Override
	public boolean disciplineRegistration(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addDiscipline(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean dropDiscipline(String discipline) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public HashMap<Lesson, Integer> viewAttestation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Vector<String> viewDownloadedFiles() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<Lesson, WeekDays> viewLessonSchedule() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<Teacher, WeekDays> viewOfficeHourSchedule() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, Vector<Mark>> viewMarks() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean returnBook() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Date getBorrowedDate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Date getMustReturnDate() {
		// TODO Auto-generated method stub
		return null;
>>>>>>> b64bc34648dab6a6511b649bb603b9d8687c9212
	}
    
    
}
