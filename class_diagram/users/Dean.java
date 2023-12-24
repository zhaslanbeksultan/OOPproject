package users;

import java.util.Date;
import java.util.Set;
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
			boolean isAdvisor, Set<Course> courses) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, isAdvisor, courses);
	}

	public Dean() {}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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
					+ "\n10. Social Transcript\n11. View Office Hours Schedule\n13. View Incoming Requests\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					break;
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
			}
		}
	}
}
