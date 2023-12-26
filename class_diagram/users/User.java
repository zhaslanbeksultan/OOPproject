package users;
import common.*;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import enums.*;
import userCapabilities.*;
import communication.*;


public abstract class User implements Serializable, CanViewResearches{

	private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private Date birthDay;
    private String id;
    private String username;
    private String password;
    private String email;
    private Date registrationDate;
    private String phoneNumber;
    private String pasportNumber;
    private Gender gender;
    private String nationality;
    private String citizenship;
    private Vector<String> socialTranscript;
    public User() {}
	public User(String firstName, String lastName, Date birthDay, String id, String username, String password, String email,
			Date registrationDate, String phoneNumber, String pasportNumber, Gender gender, String nationality,
			String citizenship) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.phoneNumber = phoneNumber;
		this.pasportNumber = pasportNumber;
		this.gender = gender;
		this.nationality = nationality;
		this.citizenship = citizenship;
		this.socialTranscript = new Vector<>();
	}

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    private String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthDay = dateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        User user = this;
        if (user instanceof Student) {
            this.id="s."+id;
        } else if (user instanceof GraduateStudent) {
        	this.id="gs."+id;
        } else if (user instanceof Teacher) {
        	this.id="t."+id;
        } else if (user instanceof Manager) {
        	this.id="m."+id;
        } else if (user instanceof Admin) {
        	this.id="a."+id;
        } else if (user instanceof Dean) {
        	this.id="d."+id;
        } else if (user instanceof Professor) {
        	this.id="l."+id;
        } else if (user instanceof Librarian) {
        	this.id="l."+id;
        } else if (user instanceof TechSupportSpecialist) {
        	this.id="tss."+id;
        } else if (user instanceof Researcher) {
        	this.id="r."+id;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.setId(username);
    }
    public Vector<String> getSocialTranscript() {
		return socialTranscript;
	}
	public void setSocialTranscript(String event) {
		this.socialTranscript.add(event);
	}
	public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
    	this.password = password;
    	Data.getInstance().getUsers().entrySet().stream()
        .filter(entry -> username.equals(entry.getKey()))
        .forEach(entry -> entry.getValue().setPassword(password));
    }

    private String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    private String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String getPasportNumber() {
        return this.pasportNumber;
    }

    public void setPasportNumber(String PasportNumber) {
        this.pasportNumber = PasportNumber;
    }

    private Gender getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
    	if(gender.equals("male") || gender.equals("MALE") || gender.equals("Male") || gender.equals("M") || gender.equals("m")) this.gender = Gender.MALE;
    	else if(gender.equals("female") || gender.equals("FEMALE") || gender.equals("Female") || gender.equals("F") || gender.equals("f")) this.gender = Gender.FEMALE;
    	else this.gender = Gender.UNDEFINED;
    }

    private String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    private String getCitizenship() {
        return this.citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

	public void viewRequests() {
		while(true) {
			System.out.println("----REQUESTS WINDOW----");
			System.out.println("Enter '0' to exit.");
			System.out.println("1. Add Request\n2. Update");
			for(Request request: Data.getInstance().getRequests()) {
				if(this.username.equals(request.getRequester())) {
					System.out.println(request);
				}
			}
			String choice = commonBuffer.readInput();
			switch(choice) {
				case("0"):
					return;
				case("1"):
					this.addRequest();;
					break;
				case("2"):
					break;
			}
		}
	}
	public void topCitedResearcher(){
		Map<String, Integer> citationsByAuthor = new HashMap<>();

		for (ResearchPaper paper : Data.getInstance().getResearchPapers()) {
		    String author = paper.getPaperAuthor();
		    int citations = paper.getCitationsNumber();

		    citationsByAuthor.put(author, citationsByAuthor.getOrDefault(author, 0) + citations);
		}

		String topCitedResearcher = null;
		int maxCitations = 0;

		for (Map.Entry<String, Integer> entry : citationsByAuthor.entrySet()) {
		    if (entry.getValue() > maxCitations) {
		        topCitedResearcher = entry.getKey();
		        maxCitations = entry.getValue();
		    }
		}
		if (topCitedResearcher != null) {
		    System.out.println("Top Cited Researcher: " + topCitedResearcher);
		} else {
		    System.out.println("No research papers found.");
		}
	}
	
	public int findHIndex() {
		System.out.println("----H-INDEX----");
		System.out.println("Write Researcher's Username: ");
		String input = commonBuffer.readInput();
		int[] citationsSizes = Data.getInstance().getResearchPapers().stream()
		        .filter(p -> p.getPaperAuthor().equals(input))
		        .mapToInt(ResearchPaper::getCitationsNumber)
		        .toArray();
		int n = citationsSizes.length;
		int j = 1;
        for (int i = 0; i < n; i++) {
            if (!(citationsSizes[i] >= j)) {
                return j-1;
            }
        }
        return 0;
	}
	
	public void viewAllBooks() {
		String choice = "";
		while(!choice.equals("0")) {
			System.out.println("----WINDOW ALL BOOKS----");
			System.out.println("'0' - to exit.");
			Data.getInstance().getBooks().forEach(System.out::println);
			choice = commonBuffer.readInput();
		}
	}
	
	public abstract void addRequest();

    public void editPersonalData() {
    	while(true) {
    		System.out.println(this);
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username\n12.Set Email");
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
    		else if(choose.equals("11")) {System.out.println("Write a username: "); setUsername(commonBuffer.readInput());}
    		else if(choose.equals("12")) {System.out.println("Write a email: "); setEmail(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
	    }
    }

    public void viewSocialTranscript() {
    	System.out.println("----WINDOW SOCIAL TRANSCRIPT----");
    	System.out.println("'0' - to exit.\n'1' - to add.");   
    	for(String item: this.getSocialTranscript()) {
    		System.out.println(item);
    	}
    	String choice = commonBuffer.readInput();
    	switch(choice) {
    	case("0"):
    		break;
    	case("1"):
    		System.out.println("Write:\n   1.Details of Event\n   2.Contribution\n   3.Level\n   4.Type of Direction"
    				+ "\n   5.Role\n   6.Event Start Date\n   7.The End Date Of The Event");
    		String info = commonBuffer.readInput();
    		this.setSocialTranscript(info);
    		break;
    	}
    }

    public void viewNews() {
    	System.out.println("Enter '0' to exit.");
    	int look = -1;
    	String choose = "";
    	while(!choose.equals("0")) {
    		System.out.println("----WINDOW FOLLOW THE NEWS----");
	    	System.out.println("'Comment' or 'Read', then Enter Post Id");
	    	if(this instanceof Student) {
	    		Data.getInstance().getNews().stream()
	    	    .filter(post -> post.getRecipients().equals("Students") || post.getRecipients().equals("All"))
	    	    .sorted(new NewsSortComparator())
	    	    .forEach(System.out::println);
	    	}
	    	if(this instanceof Employee) {
	    		Data.getInstance().getNews().stream()
	    	    .filter(post -> post.getRecipients().equals("Employees") || post.getRecipients().equals("All"))
	    	    .sorted(new NewsSortComparator())
	    	    .forEach(System.out::println);
	    	}
	    	choose = commonBuffer.readInput();
	    	if(choose.equals("0")) break;
	    	else if(choose.equals("Comment")) {
		    		System.out.println("Enter Post ID: ");
		    		look = Integer.parseInt(commonBuffer.readInput());
		    		System.out.println("Write a Comment");
		    		String comment = commonBuffer.readInput();
		    		Data.getInstance().getNews().get(look-1).setNewsComments(this.getUsername(), comment);
	    	}
	    	else if(choose.equals("Read")) {
	        	System.out.println("Enter '0' to exit.");
	    		System.out.println("Enter Post ID: ");
	    		look = Integer.parseInt(commonBuffer.readInput());
	        	System.out.println("----WINDOW READ PUBLICATION----");
		    	System.out.println(Data.getInstance().getNews().get(look-1));
		    	System.out.println("Text: " + Data.getInstance().getNews().get(look-1).getNewsWording());
		    	System.out.println("Comments: ");
		    	for(HashMap.Entry<String,String> comment: Data.getInstance().getNews().get(look-1).getNewsComments().entrySet()) {
		    		System.out.println(comment.getKey() + ": " + comment.getValue());
		    	}
		    	while(look!=0) {
		    		System.out.println("Enter '0' to exit.");
		    		look = Integer.parseInt(commonBuffer.readInput());
		    	}
	    	}
	    	else System.out.println("Enter only 'Comment', 'Read' or '0'!");
	    	}
    }

    public String getUserInformation() {
        return toString();
    }
    public abstract void showMenu();
    public void save() throws IOException {
		Data.write();
	}
    public void showMessages() {

    	System.out.println("Enter '0' to exit.");
    	int look = -1;
    	String choose = "";
    	while(!choose.equals("0")) {
    		System.out.println("----WINDOW SHOW MESSAGES----");
	    	System.out.println("'Answer' or 'Read', then Enter Message Id");
	    	Data.getInstance().getMessages().stream()
	        	.filter(message -> username.equals(message.getRecipient()))
	        	.sorted(new UrgencyLevelComparator())
	        	.forEach(System.out::println);

	    	choose = commonBuffer.readInput();
	    	if(choose.equals("0")) break;
	    	else if(choose.equals("Answer")) {
		    		System.out.println("Enter Message ID: ");
		    		look = Integer.parseInt(commonBuffer.readInput());
		    		sendMessage(look-1);
	    	}
	    	else if(choose.equals("Read")) {
	        	System.out.println("Enter '0' to exit.");
	    		System.out.println("Enter Message ID: ");
	    		look = Integer.parseInt(commonBuffer.readInput());
	        	System.out.println("----WINDOW READ MESSAGE----");
	        	if(Data.getInstance().getMessages().get(look-1).getAnsweredMessage()!= -1)
	        		System.out.println("Answered Message Id: " + Data.getInstance().getMessages().get(look-1).getAnsweredMessage() + 1);
		    	System.out.println(Data.getInstance().getMessages().get(look-1));
		    	System.out.println("Text: " + Data.getInstance().getMessages().get(look-1).getMessageWording());
		    	Data.getInstance().getMessages().get(look-1).setStatus(MessageStatus.READ);
		    	while(look!=0) {
		    		System.out.println("Enter '0' to exit.");
		    		look = Integer.parseInt(commonBuffer.readInput());
		    	}
	    	}
	    	else System.out.println("Enter only 'Answer', 'Read' or '0'!");
	    	}
    }
    
    public void sendMessage() {
    	System.out.println("----WINDOW SEND MESSAGE----");
    	System.out.print("Recipient username: ");
    	String recipient = commonBuffer.readInput();
    	System.out.print("Theme: "); 
    	String theme = commonBuffer.readInput();
    	System.out.print("Message Wording: ");
    	String messageWording = commonBuffer.readInput();
    	if(this instanceof Teacher) {
        	System.out.print("Urgency Level 'LOW', 'MEDIUM, 'HIGH': ");
        	String level = commonBuffer.readInput();
        	Message message = new Message(theme, this.username, recipient, messageWording, level);
        	Data.getInstance().getMessages().add(message);
    	}
    	else {
	    	Message message = new Message(theme, this.username, recipient, messageWording);
	    	Data.getInstance().getMessages().add(message);
    	}
    }
    
    public void sendMessage(int answer) {
    	System.out.println("----WINDOW ANSWERE TO MESSAGE----");
    	String recipient = Data.getInstance().getMessages().get(answer).getSender();
    	System.out.println("Recipient: " + recipient);
    	System.out.print("Theme: "); 
    	String theme = commonBuffer.readInput();
    	System.out.print("Message Wording: ");
    	String messageWording = commonBuffer.readInput(); 
    	
    	Message message = new Message(theme, this.username, recipient, messageWording, answer);
    	Data.getInstance().getMessages().add(message);
    }
    
    @Override
    public void researchCabinet() {
    	while(true) {
    		System.out.println("----RESEARCH CABINET----");
    		System.out.println("'0' - to exit.\n'1' - Show All Research Papers\n'2' - Show All Research Journals"
    				+ "\n'3' - Show Papers Of Subscribed Journals\n'4' - View Researcher's H-Index\n'5' - Top Cited Researcher");
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
    		}
    	}
    }
    
    public void showPapersOfSubscribedJournals() {
    	System.out.println("----WINDOW SUBSCRIBED JOURNALS----");
    	System.out.println("'0' - to exit.");
    	System.out.println("Choose sorting order: 'Length', 'Citations', 'Date'");
    	String choice = commonBuffer.readInput();
    	switch(choice) {
    	case("0"):
    		return;
    	case("Length"):
    		Data.getInstance().getResearchProjects().stream()
    		.filter(p -> p.getSubscribers().contains((Subscriber)this))
    		.forEach(p -> p.getPublishedPapers().stream()
    				.sorted(new PaperByArticleLengthComparator())
    				.forEach(System.out::println));
    		this.readPaper();
    		break;
    	case("Citations"):
    		Data.getInstance().getResearchProjects().stream()
    		.filter(p -> p.getSubscribers().contains((Subscriber)this))
    		.forEach(p -> p.getPublishedPapers().stream()
    				.sorted(new PaperByCitationComparator())
    				.forEach(System.out::println));
    		this.readPaper();
    		break;
    	case("Date"):
    		Data.getInstance().getResearchProjects().stream()
    		.filter(p -> p.getSubscribers().contains((Subscriber)this))
    		.forEach(p -> p.getPublishedPapers().stream()
    				.sorted(new PaperByDateComparator())
    				.forEach(System.out::println));
    		this.readPaper();
    		break;
    	}
    }
    
    public void showAllJournals() {
    	System.out.println("----ALL JOURNALS----");
    	System.out.println("'0' - to exit.'1' - to subscribe. '2' - to unsubscribe.");
    	Data.getInstance().getResearchProjects().stream().forEach(System.out::println);
    	String choice = commonBuffer.readInput();
    	if(choice.equals("0")) return;
    	else if(choice.equals("1")) {
    		System.out.println("Enter id: ");
    		int id = Integer.parseInt(commonBuffer.readInput());
    		Data.getInstance().getResearchProjects().get(id-1).setSubscribers((Subscriber)this);}
    	else {
    		System.out.println("Enter id: ");
    		int id = Integer.parseInt(commonBuffer.readInput());
    		Data.getInstance().getResearchProjects().get(id-1).removeSubscribers((Subscriber)this);}
    }
    
    public void readPaper() {
    	System.out.println("'0' - to exit. 'id' - to read paper.");
    	String choice = commonBuffer.readInput();
    	if(choice.equals("0")) return;
    	else {
    		int paperIndex = Integer.parseInt(choice);
    		Data.getInstance().getResearchPapers().stream()
    			.filter(p->p.getPaperId()==paperIndex).forEach(p->p.printPaper());}
    }
    
    public void showAllResearchPapers() {
    	System.out.println("----ALL RESEARCH PAPERS----");
    	System.out.println("'0' - to exit.'id' - to read paper.");
    	Data.getInstance().getResearchPapers().forEach(System.out::println);
    	this.readPaper();
    }
    
	@Override
	public String toString() {
		return " First Name = " + firstName + "\n Last Name = " + lastName + "\n Birth Day = " + birthDay + "\n Id = " + id
				+ username + "\n Email = " + email + "\n Registration Date = "
				+ registrationDate + "\n Phone Number = " + phoneNumber + "\n Pasport Number = " + pasportNumber + "\n Gender = "
				+ gender + "\n Nationality = " + nationality + "\n Citizenship = " + citizenship + "\n Password = " + password;
	}

}
