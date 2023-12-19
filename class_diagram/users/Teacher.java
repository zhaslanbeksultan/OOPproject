package users;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import communication.Message;
import communication.Request;
import education.*;
import enums.*;
import userCapabilities.*;

public class Teacher extends Employee implements Managable,CanBorrowBook,Educationable {

    private Set<Course> courses;
    private GraduateStudent graduateStudent;
    private Course course;
    
	public Teacher(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			Set<Course> courses, GraduateStudent graduateStudent, Course course) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
		this.courses = courses;
		this.graduateStudent = graduateStudent;
		this.course = course;
	}

	public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

	@Override
	public void viewAcademicStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeOfficeHoursSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtainingProgressStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gettingPassingStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewRegisteredSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, HashMap<WeekDays, Teacher>> getLessonSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrowBook(String bookName) {
		if(Book.isBookAvailable(bookName)) {
			for(Book book: Data.getInstance().getBooks()) {
				if(book.getBookName().equals(bookName)) {
					book.setBorrowed(true);
					book.setReader(this);
				}
			}
		}
	}


	@Override
	public void returnBook(String bookName) {
		for(Book book: Data.getInstance().getBooks()) {
			if(book.getReader().getUsername().equals(this.getUsername()) && book.getBookName().equals(bookName)) {
				book.setBorrowed(false);
				book.setReader(null);
			}
		}
	}

	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSalary(double salary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getHireDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHireDate(Date hireDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInsuranceNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInsuranceNumber(String insuranceNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sentComplaintMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String performInsuranceNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Journal\n2. Requests\n3. Personal Datas\n4. News\n5. Attendance Mark"
					+ "\n6. View Attestation\n7. Discipline Schedule\n8. Lesson Schedule\n9. Exams Schedule"
					+ "\n10. Social Transcript\n11. View Office Hours Schedule\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					break;
				case "1":
					this.viewJournal();
				case "2":
					this.viewRequests();
				case "3":
					System.out.println(this);
				case "4":
					this.viewNews();
				case "5":
					this.attendanceMark();
				case "6":
					this.viewAttestation();
				case "7":
					this.viewDisciplineSchedule();
				case "8":
					this.viewLessonSchedule();
				case "9":
					this.viewExamsSchedule();
				case "10":
					this.viewSocialTranscript();
				case "11":
					this.viewOfficeHourSchedule();
			}
		}
	}

	@Override
	public void addRequest() {
		while(true) {
			System.out.println("----ADD REQUEST WINDOW----");
			System.out.println("Select the Form: 'Paper', 'Electronic'");
			String form = commonBuffer.readInput(); 
			System.out.println("Select the Type:\nREQUEST_FOR_ACADEMIC_MOBILITY\nWORKAROUND_SHEET"
					+ "\nHELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"
					+ "\nHELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES\nHELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"
					+ "\nINFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT");
			String type = commonBuffer.readInput();
			System.out.println("Select the Language: 'EN', 'RU', 'KZ'");
			String language = commonBuffer.readInput();
			Request request = new Request(this.getUsername(), form, type, language);
			System.out.println("'0' - Cancel");
			System.out.println("'1' - If You Want Add Additionally Information");
			System.out.println("'2' - Save");
			String choice = commonBuffer.readInput();
			if(choice.equals("0")) break;
			if(choice.equals("1")) {
				String info = commonBuffer.readInput();
				request.setAdditionallyInfo(info);
				choice = commonBuffer.readInput();}
			if(choice.equals("2"))
				Data.getInstance().addRequest(request);
				break;
		}
	}


	@Override
	public void viewExamsSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewJournal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attendanceMark() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewDisciplineSchedule() {
		// TODO Auto-generated method stub
		
	}
}

