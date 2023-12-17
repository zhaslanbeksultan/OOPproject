package users;

import java.util.Date;

import enums.Gender;

public abstract class EmployeeDecorator extends User implements Employee{

	public EmployeeDecorator(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship);
	}

}
