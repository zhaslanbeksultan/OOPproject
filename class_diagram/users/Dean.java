package users;

import java.util.Date;
import java.util.Set;
import java.util.Vector;
import education.*;
import enums.*;
import communication.*;

public class Dean extends Teacher{
	private Vector<Request> incomingRequests;

	public Dean(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			boolean isAdvisor, Set<Course> courses, Vector<Request> incomingRequests) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, isAdvisor, courses);
		this.incomingRequests = incomingRequests;
	}


	public Dean() {
		
	}

}
