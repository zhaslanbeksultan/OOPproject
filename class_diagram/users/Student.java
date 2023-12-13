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
    private String school;
    private Organizations organizations;
    public Student() {
    	
    };
    private void setGpa(double gpa) {
        this.gpa = gpa;
    }
    private int getStudyYear() {
        return this.studyYear;
    }
    private void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
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
    private String getSchool() {
        return this.school;
    }
    private void setSchool(String school) {
        this.school = school;
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
	}
    
    
}
