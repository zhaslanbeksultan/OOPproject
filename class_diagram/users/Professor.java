package users;

import java.util.Date;
import java.util.Set;

import education.Course;
import enums.Gender;

public class Professor extends TeacherResearcher {
    public Professor(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, Set<Course> courses, GraduateStudent graduateStudent,
			Course course) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, courses, graduateStudent, course);
	}

	private int hindex;

    public int getHindex() {
        return this.hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }
    
}
