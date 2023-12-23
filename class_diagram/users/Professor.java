package users;

import java.util.Date;
import java.util.Set;

import education.Course;
import enums.Gender;

public class Professor extends Teacher {

	public Professor(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			boolean isAdvisor, Set<Course> courses) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber, isAdvisor, courses);
	}
    
}
