package users;

import java.util.Date;
import java.util.Set;
import java.util.Vector;
import education.Course;
import enums.Gender;


public class Advisor extends Teacher {

    public Advisor(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, Set<Course> courses, GraduateStudent graduateStudent,
			Course course) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, courses, graduateStudent, course);
	}

	private String areaOfConsulting;

    private Vector studentsToConsult;
    
    private String getAreaOfConsulting() {
        return this.areaOfConsulting;
    }

    private void setAreaOfConsulting(String areaOfConsulting) {
        this.areaOfConsulting = areaOfConsulting;
    }

    private Vector getStudentsToConsult() {
        return this.studentsToConsult;
    }

    private void setStudentsToConsult(Vector studentsToConsult) {
        this.studentsToConsult = studentsToConsult;
    }

    public String conductСonsultations() {
        //TODO
        return "";
    }

    public boolean isAnyProgressChecking() {
        //TODO
        return false;
    }

    public String updateStudentProgress() {
        //TODO
        return "";
    }

    public Date getAvailableAppointments() {
        //TODO
        return new Date();
    }
    
    
}
