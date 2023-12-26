package users;

import java.util.Date;

import common.*;
import communication.*;
import enums.Gender;
import userCapabilities.*;

public class EmployeeResearcher extends Employee implements Subscriber,Researcher{

	private static final long serialVersionUID = 1L;
	private String biography;

    public EmployeeResearcher(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			int hindex) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}

	public EmployeeResearcher() {
	}

	@Override
	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Research Cabinet\n2. View Requests\n3. Send Message\n4. Show Messages\n5. Personal Datas"
					+ "\n6. News\n7. Social Transcript\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					return;
				case "1":
					this.researchCabinet();
					break;
				case "2":
					this.viewRequests();
					break;
				case "3":
					this.sendMessage();
					break;
				case "4":
					this.showMessages();
					break;
				case "5":
					this.editPersonalData();
					break;
				case "6":
					this.viewNews();
					break;
				case "7":
					this.viewSocialTranscript();
					break;
			}
		}
	}

    @Override
    public void researchCabinet() {
    	while(true) {
    		System.out.println("----RESEARCH CABINET----");
    		System.out.println("'0' - to exit.\n'1' - Show All Research Papers\n'2' - Show All Research Journals"
    				+ "\n'3' - Show Papers Of Subscribed Journals\n'5' - Top Cited Researcher\n'6' - Show My Research Papers"
    				+ "\n'7' - Add Research Paper\n'8' - Create Research Project\n'9' - Send Message\n'10' - Show Incoming Messages");
    		String choice = commonBuffer.readInput();
    		switch(choice) {
    		case "0":
    			return;
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
    			System.out.println(this.findHIndex()); 
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
    		case "9":
    			this.sendMessage();
    			break;
    		case "10":
    			this.showMessages();
    			break;
    		}
    	}
    }
    
    @Override
    public void createResearchProject() {

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
    				String reference = commonBuffer.readInput();
    				if(reference.equals("0")) break;
    				paper.setReferences(reference);
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
	public String toString() {
		return super.toString() + "\n Biography=" + biography ;
	}




}
