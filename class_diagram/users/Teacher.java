package users;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import common.Data;
import common.InvalidResearcherException;
import common.LowHIndexException;
import common.PaperByArticleLengthComparator;
import common.PaperByCitationComparator;
import common.PaperByDateComparator;
import common.commonBuffer;
import communication.Message;
import communication.News;
import communication.Request;
import communication.ResearchPaper;
import communication.ResearchProject;
import education.*;
import enums.*;
import userCapabilities.*;

public class Teacher extends Employee implements Managable,CanBorrowBook,Educationable,Subscriber,Researcher {

	private static final long serialVersionUID = 1L;
	private boolean isAdvisor;
    private Set<Course> courses;
    
	public Teacher(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			boolean isAdvisor, Set<Course> courses) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
		this.isAdvisor = isAdvisor;
		this.courses = courses;
	}
	public Teacher(){}

	public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
    public void researchCabinet() {
    	while(true) {
    		System.out.println("----RESEARCH CABINET----");
    		System.out.println("'0' - to exit.\n'1' - Show All Research Papers\n'2' - Show All Research Journals"
    				+ "\n'3' - Show Papers Of Subscribed Journals\n'5' - Top Cited Researcher\n'6' - Show My Research Papers"
    				+ "\n'7' - Add Research Paper\n'8' - Create Research Project");
    		String choice = commonBuffer.readInput();
    		switch(choice) {
    		case "0":
    			break;
    		case "1":
    			this.showAllResearchPapers();
    			break;
    		case "2":
    			this.showAllJournals();
    			break;
    		case "3":
    			this.showPapersOfSubscribedJournals();
    			break;
    		case "4":
    			this.findHIndex();
    			break;
    		case "5":
    			this.topCitedResearcher();
    			break;
    		case "6":
    			this.showMyPapers();
    			break;
    		case "7":
    			this.addResearchPaper();
    			break;
    		case "8":
    			this.createResearchProject();
    			break;
    		}
    	}
    }
    @Override
    public void createResearchProject() {
		try {
			if (this.findHIndex() < 3)
				throw new LowHIndexException("Supervisor's h-index is less than 3.");
		}catch(LowHIndexException e){
			System.out.println(e.getMessage());
			return;
		}
    	System.out.println("----WINDOW FOR CREATING RESEARCH PROJECT");
    	System.out.println("Write Journal Name: ");
    	String journalName = commonBuffer.readInput();
    	System.out.println("Write Project Topic: ");
    	String topic = commonBuffer.readInput();
    	ResearchProject project = new ResearchProject(journalName, topic, this.getUsername());
    	Data.getInstance().setResearchProjects(project);
    }
    @Override
    public void addResearchPaper() {
    	try {
	    	if(!(this instanceof Researcher)) {
	    		throw new InvalidResearcherException("Only Researchers Can Add Research Papers!");
	    	}
    	}catch(InvalidResearcherException e) {
            System.err.println(e.getMessage());
            return;
    	}
    	System.out.println("----WINDOW FOR RESEARCHING----");
    	while(true) {
        	System.out.println("'0' - to exit.'1' - Add Paper.");
    		String choice = commonBuffer.readInput();
    		switch(choice) {
    		case "0":
    			return;
    		case "1":
    			System.out.println("Research Project Name: ");
    			String researchProject = commonBuffer.readInput();
    			System.out.println("Paper Title: ");
    			String title = commonBuffer.readInput();
    			System.out.println("Paper Wording: ");
    			String wording = commonBuffer.readInput();
    			ResearchPaper paper = new ResearchPaper(researchProject, title, wording, this.getUsername());
    			System.out.println("Links To The Papers Used In Research: ");
    			while(true) {
    				System.out.println("'0' - end adding references.");
    				if(choice.equals("0")) break;
    				paper.setReferences(choice);
    			}
    			Data.getInstance().setResearchPapers(paper);
    			Data.getInstance().getResearchProjects().stream()
    				.filter(p->p.getJournalName().equals(paper.getResearchProject()))
    				.forEach(p->p.setPublishedPapers(paper));
    			Data.getInstance().getResearchProjects().stream()
				.filter(p->p.getJournalName().equals(paper.getResearchProject()))
				.forEach(p->p.setParticipants(this.getUsername()));
    			News post = new News("All", "Research", "A New Research Article From: " + this.getUsername() + "Research Title: " + title);
    			Data.getInstance().getNews().add(post);
    			break;
    		}
    	}
    }
    @Override
    public void showMyPapers() {
    	System.out.println("----MY RESEARCH PAPERS----");
    	System.out.println("Choose sorting order: 'Length', 'Citations', 'Date'");
    	String choice = commonBuffer.readInput();
    	switch(choice) {
    	case("Length"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByArticleLengthComparator())
    		.forEach(System.out::println);
    		this.readPaper();
    		break;
    	case("Citations"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByCitationComparator())
    		.forEach(System.out::println);
    		this.readPaper();
    		break;
    	case("Date"):
    		Data.getInstance().getResearchPapers().stream()
    		.filter(p -> p.getPaperAuthor().equals(this.getUsername()))
    		.sorted(new PaperByDateComparator())
    		.forEach(System.out::println);
    		this.readPaper();
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

	@Override
	public void viewAttestation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewLessonSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOfficeHourSchedule() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
	}
	
	public boolean isAdvisor() {
		return isAdvisor;
	}
	
	public void setAdvisor(boolean isAdvisor) {
		this.isAdvisor = isAdvisor;
	}
	@Override
	public String toString() {
		return super.toString() + "\n isAdvisor = " + isAdvisor;
	}
	
}

