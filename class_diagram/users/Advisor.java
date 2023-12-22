package users;

import java.util.Date;
import java.util.Set;
import java.util.Vector;
import education.Course;
import enums.Gender;
import userCapabilities.Subscriber;


public class Advisor extends Teacher implements Subscriber{
	
	private String areaOfConsulting;

    private Vector studentsToConsult;
    
    public Advisor(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			Set<Course> courses, GraduateStudent graduateStudent, Course course, String areaOfConsulting,
			Vector studentsToConsult) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, courses,
				graduateStudent, course);
		this.areaOfConsulting = areaOfConsulting;
		this.studentsToConsult = studentsToConsult;
	}

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
