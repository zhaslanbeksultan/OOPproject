package users;

import java.util.Date;

import enums.Gender;

public class EmployeeResearcher extends Employee{

    private int hindex;
    private String biography;

    public EmployeeResearcher(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			int hindex) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
		this.hindex = hindex;
	}

	public int getHindex() {
        return this.hindex;
    }
 
    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

	@Override
	void addRequest() {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
}
