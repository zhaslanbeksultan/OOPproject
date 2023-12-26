package users;

import java.util.Date;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import education.*;
import enums.*;
import communication.*;

public class Dean extends Teacher{

	private static final long serialVersionUID = 1L;
	private Vector<Request> incomingRequests;
	private Faculty faculty;

	public Dean(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			boolean isAdvisor, Vector<Course> courses, Faculty faculty) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, isAdvisor, courses);
		this.faculty = faculty;
		this.incomingRequests = new Vector<>();
	}

	public Dean() {}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
    	if(faculty.equals("BS")) {
        	this.faculty = Faculty.BS;}
    	if(faculty.equals("ISE")) {
        	this.faculty = Faculty.ISE;}
    	if(faculty.equals("KMA")) {
        	this.faculty = Faculty.KMA;}
    	if(faculty.equals("SAM")) {
        	this.faculty = Faculty.SAM;}
    	if(faculty.equals("SCE")) {
        	this.faculty = Faculty.SCE;}
    	if(faculty.equals("SEOGI")) {
        	this.faculty = Faculty.SEOGI;}
    	if(faculty.equals("SG")) {
        	this.faculty = Faculty.SG;}
    	if(faculty.equals("SITE")) {
        	this.faculty = Faculty.SITE;}
    	if(faculty.equals("SMSGT")) {
        	this.faculty = Faculty.SMSGT;}
    	if(faculty.equals("SNSS")) {
        	this.faculty = Faculty.SNSS;}
	}

	public Vector<Request> getIncomingRequests() {
		return incomingRequests;
	}

	public void setIncomingRequests(Request incomingRequests) {
		this.incomingRequests.add(incomingRequests);
	}
	public void viewIncomingRequests() {
		incomingRequests.forEach(System.out::println);
		System.out.println("0 - to exit. 'requestId' - to process.");
		String choice = commonBuffer.readInput();
		if(choice.equals("0")) return;
		else processRequest(Integer.parseInt(choice)-1);
	}

	private void processRequest(int id) {
		System.out.println("'0' - APPROVED, '1' - NOT_APPROVED");
		String choose = commonBuffer.readInput();
		if(choose.equals("0"))
			Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.APPROVED);
		if(choose.equals("1"))
			Data.getInstance().getRequests().get(id).setRequestStatus(RequestStatus.NOT_APPROVED);
		
	}
	
	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Journal\n2. Requests\n3. Personal Datas\n4. News\n5. Attendance Mark"
					+ "\n6. View Attestation\n7. Discipline Schedule\n8. Lesson Schedule\n9. Exams Schedule"
					+ "\n10. Social Transcript\n11. View Office Hours Schedule\n12. Research Cabinet"
					+ "\n13. View Incoming Requests\n14. Send Messages\n15. View Incoming Messages\n0. Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					return;
				case "1":
					this.viewJournal();
					break;
				case "2":
					this.viewRequests();
					break;
				case "3":
					this.editPersonalData();
					break;
				case "4":
					this.viewNews();
					break;
				case "5":
					this.attendanceMark();
					break;
				case "6":
					this.viewAttestation();
					break;
				case "7":
					this.viewDisciplineSchedule();
					break;
				case "8":
					this.viewLessonSchedule();
					break;
				case "9":
					this.viewExamsSchedule();
					break;
				case "10":
					this.viewSocialTranscript();
					break;
				case "11":
					this.viewOfficeHourSchedule();
					break;
				case "12":
					this.researchCabinet();
					break;
				case "13":
					this.viewIncomingRequests();
					break;
				case "14":
					this.sendMessage();
					break;
	    		case "15":
	    			this.showMessages();
	    			break;
			}
		}
	}
	@Override
    public void editPersonalData() {
    	while(true) {
    		System.out.println(this);
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number\n7.Set Gender"
    				+ "\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username\n12.Set Email\n13.Set Faculty");
    		String choose = commonBuffer.readInput();
    		if(choose.equals("0")) {break;}
    		else if(choose.equals("1")) {System.out.print("Enter new password: "); setPassword(commonBuffer.readInput());}
    		else if(choose.equals("2")) {System.out.println("Write a New Name: "); setFirstName(commonBuffer.readInput());}
    		else if(choose.equals("3")) {System.out.println("Write a New Last Name: "); setLastName(commonBuffer.readInput());}
    		else if(choose.equals("4")) {System.out.println("Write a Birth Day: "); setBirthDay(commonBuffer.readInput());}
    		else if(choose.equals("5")) {System.out.println("Write a Phone Number: "); setPhoneNumber(commonBuffer.readInput());}
    		else if(choose.equals("6")) {System.out.println("Write a Pasport Number: "); setPasportNumber(commonBuffer.readInput());}
    		else if(choose.equals("7")) {System.out.println("Write a Gender: "); setGender(commonBuffer.readInput());}
    		else if(choose.equals("8")) {System.out.println("Write a Nationality: "); setNationality(commonBuffer.readInput());}
    		else if(choose.equals("9")) {System.out.println("Write a Citizenship: "); setCitizenship(commonBuffer.readInput());}
    		else if(choose.equals("10")) {System.out.println("Write an Id: "); setId(commonBuffer.readInput());}
    		else if(choose.equals("11")) {System.out.println("Write a Username: "); setUsername(commonBuffer.readInput());}
    		else if(choose.equals("12")) {System.out.println("Write a Email: "); setEmail(commonBuffer.readInput());}
    		else if(choose.equals("13")) {System.out.println("Write a Faculty: "); setFaculty(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
	    }
    }

	@Override
	public String toString() {
		return super.toString() + "\nFaculty = " + faculty;
	}
	
}
