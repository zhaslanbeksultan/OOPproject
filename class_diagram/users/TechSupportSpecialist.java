package users;

import java.util.Date;

import communication.*;
import enums.Gender;

public class TechSupportSpecialist extends EmployeeBase {

    private String complaintType;

	public TechSupportSpecialist(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}

	public String getComplaintType() {
        return this.complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public boolean FixComplaintType() {
        return false;
    }
    
    
}
