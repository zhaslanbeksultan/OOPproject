package users;

import java.util.Date;

import communication.Message;
import enums.Gender;

public class TechSupportSpecialist extends Employee {

    private String complaintType;

    public TechSupportSpecialist(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, Request request, News news, Message message,
			double salary, users.Date hireDate, String insuranceNumber, Message message2, String complaintType) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, request, news, message, salary, hireDate,
				insuranceNumber, message2);
		this.complaintType = complaintType;
	}

	public String getComplaintType() {
        return this.complaintType;
    }

    public String setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public boolean FixComplaintType() {
        return false;
    }
    
    
}
