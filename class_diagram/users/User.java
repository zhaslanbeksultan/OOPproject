package users;

import java.util.Date;
import common.*;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import enums.Gender;
import communication.News;
import communication.Request;
import communication.Message;

public abstract class User {
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
    private Request request;
    private News news;
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
	}
	public User() {
		
	}
    private String getFirstName() {
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

    private String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if(this.password != password)
        	this.password = password;
        else System.out.println("The password must not match the previous one");
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

    public News getNews() {
        return this.news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void editPersonalData() {
    	String choose = commonBuffer.readInput();
    	//Отдельный для Админа и Юзера
    	if(this instanceof Admin) {
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship\n10.Set Id\n11.Set Username\n12.Set Email");
    		if(choose=="1") {System.out.print("Enter new password: "); setPassword(commonBuffer.readInput());}
    		else if(choose=="2") {System.out.println("Write a New Name: "); setFirstName(commonBuffer.readInput());}
    		else if(choose=="3") {System.out.println("Write a New Last Name: "); setLastName(commonBuffer.readInput());}
    		else if(choose=="4") {System.out.println("Write a Birth Day: "); setBirthDay(commonBuffer.readInput());}
    		else if(choose=="5") {System.out.println("Write a Phone Number: "); setPhoneNumber(commonBuffer.readInput());}
    		else if(choose=="6") {System.out.println("Write a Pasport Number: "); setPasportNumber(commonBuffer.readInput());}
    		else if(choose=="7") {System.out.println("Write a Gender: "); setGender(commonBuffer.readInput());}
    		else if(choose=="8") {System.out.println("Write a Nationality: "); setNationality(commonBuffer.readInput());}
    		else if(choose=="9") {System.out.println("Write a Citizenship: "); setCitizenship(commonBuffer.readInput());}
    		else if(choose=="10") {System.out.println("Write an Id: "); setId(commonBuffer.readInput());}
    		else if(choose=="11") {System.out.println("Write a username: "); setUsername(commonBuffer.readInput());}
    		else if(choose=="12") {System.out.println("Write a email: "); setEmail(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
    	}
    	if(this instanceof User) {
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Birth Day\n5.Set Phone Number\n6.Set Pasport Number\n7.Set Gender\n8.Set Nationality\n9.Set Citizenship");
    		if(choose=="1") {System.out.print("Enter new password: "); setPassword(commonBuffer.readInput());}
    		else if(choose=="2") {System.out.println("Write a New Name: "); setFirstName(commonBuffer.readInput());}
    		else if(choose=="3") {System.out.println("Write a New Last Name: "); setLastName(commonBuffer.readInput());}
    		else if(choose=="4") {System.out.println("Write a Birth Day: "); setBirthDay(commonBuffer.readInput());}
    		else if(choose=="5") {System.out.println("Write a Phone Number: "); setPhoneNumber(commonBuffer.readInput());}
    		else if(choose=="6") {System.out.println("Write a Pasport Number: "); setPasportNumber(commonBuffer.readInput());}
    		else if(choose=="7") {System.out.println("Write a Gender: "); setGender(commonBuffer.readInput());}
    		else if(choose=="8") {System.out.println("Write a Nationality: "); setNationality(commonBuffer.readInput());}
    		else if(choose=="9") {System.out.println("Write a Citizenship: "); setCitizenship(commonBuffer.readInput());}
    		else {System.out.println("The wrong character is entered!");}
    	}
    }

    public String accesingFeedback() {
        return "";
    }

    public void viewNews() {
        //TODO
    }

    public String getNotifications() {
        return "";
    }

    public String getUserInformation() {
        return toString();
    }

    public void showMenu() {
        
    }
    
    public void showMessages() {//надо сделать цикл + exit
    	System.out.println("'Answere' or 'Read', then Enter MessageId");
    	for(Message message: Data.getInstance().getMessages()) {
    		if(username.equals(message.getRecipient()))
    			System.out.println(message);

    	}
    	String choose = commonBuffer.readInput();
    	if(choose.equals("Answere")) {
    		System.out.println("Enter Message ID: ");
    		int look = Integer.parseInt(commonBuffer.readInput());
    		sendMessage(look);
    	}
    	else if(choose.equals("Read")) {
    		System.out.println("Enter Message ID: ");
    		int look = Integer.parseInt(commonBuffer.readInput());
    		System.out.println(Data.getInstance().getMessages().get(look));
    		System.out.println("Text: " + Data.getInstance().getMessages().get(look).getMessageWording());
    	}
    	else System.out.println("Enter only 'Answere' or 'Read'!");
    }
    
    public void sendMessage() {
    	System.out.print("Recipient username: ");
    	String recipient = commonBuffer.readInput();
    	System.out.print("Theme: "); 
    	String theme = commonBuffer.readInput();
    	System.out.print("Message Wording: ");
    	String messageWording = commonBuffer.readInput(); 
    	
    	Message message = new Message(theme, this.username, recipient, messageWording);
    	Data.getInstance().getMessages().add(message);
    }
    
    public void sendMessage(int answer) {
    	System.out.print("Recipient username: ");
    	String recipient = commonBuffer.readInput();
    	System.out.print("Theme: "); 
    	String theme = commonBuffer.readInput();
    	System.out.print("Message Wording: ");
    	String messageWording = commonBuffer.readInput(); 
    	
    	Message message = new Message(theme, this.username, recipient, messageWording, answer);
    	Data.getInstance().getMessages().add(message);
    }
	@Override
	public String toString() {
		return " FirstName = " + firstName + "\n LastName = " + lastName + "\n Birth Day = " + birthDay + "\n Id = " + id
				+ username + "\n Email = " + email + "\n RegistrationDate = "
				+ registrationDate + "/n Phone Number = " + phoneNumber + ", PasportNumber = " + pasportNumber + "\n Gender = "
				+ gender + "\n Nationality = " + nationality + "\n Citizenship = " + citizenship;
	}

    
    
}
