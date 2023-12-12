package users;

import java.util.Date;

import common.commonBuffer;
import enums.Gender;


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
    private String PasportNumber;
    private Gender gender;
    private String nationality;
    private String citizenship;
    private Request request;
    private News news;
    private Message message;
	public User(String firstName, String lastName, Date birthDay, String id, String username, String password, String email,
			Date registrationDate, String phoneNumber, String pasportNumber, Gender gender, String nationality,
			String citizenship, Request request, News news, Message message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.phoneNumber = phoneNumber;
		PasportNumber = pasportNumber;
		this.gender = gender;
		this.nationality = nationality;
		this.citizenship = citizenship;
		this.request = request;
		this.news = news;
		this.message = message;
	}
    private String getFirstName() {
        return this.firstName;
    }

    private String setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    private String getLastName() {
        return this.lastName;
    }

    private String setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Date getBirthDay() {
        return this.birthDay;
    }

    private Date setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    private String getId() {
        return this.id;
    }

    private String setId(String id) {
        this.id = id;
    }

    private String getUsername() {
        return this.username;
    }

    private String setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return this.password;
    }

    private void setPassword() {
    	System.out.print("Enter new password: ");
    	String password = commonBuffer.readInput();;//will change
        if(this.password != password)
        	this.password = password;
        else System.out.println("The password must not match the previous one");
    }

    private String getEmail() {
        return this.email;
    }

    private String setEmail(String email) {
        this.email = email;
    }

    private Date getRegistrationDate() {
        return this.registrationDate;
    }

    private Date setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    private String getPhoneNumber() {
        return this.phoneNumber;
    }

    private String setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String getPasportNumber() {
        return this.PasportNumber;
    }

    private String setPasportNumber(String PasportNumber) {
        this.PasportNumber = PasportNumber;
    }

    private Gender getGender() {
        return this.gender;
    }

    private Gender setGender(Gender gender) {
        this.gender = gender;
    }

    private String getNationality() {
        return this.nationality;
    }

    private String setNationality(String nationality) {
        this.nationality = nationality;
    }

    private String getCitizenship() {
        return this.citizenship;
    }

    private String setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public News getNews() {
        return this.news;
    }

    public News setNews(News news) {
        this.news = news;
    }

    public Request getRequest() {
        return this.request;
    }

    public Request setRequest(Request request) {
        this.request = request;
    }

    public Message getMessage() {
        return this.message;
    }

    public Message setMessage(Message message) {
        this.message = message;
    }

    public void editPersonalData() {
//    	String inputFileName = "file.txt";
//
//		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
//			String line;
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line + "\n");
//			}
//		}
//                catch (IOException e) {
//			e.printStackTrace();
//		}
    	String line;
    	//Отдельный для Админа и Юзера
    	if(this instanceof User) {
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Father Name\n5.Set Birth Day\n6.Set Phone Number\n7.Set Pasport Number\n8.Set Gender\n9.Set Nationality\n10.Set Citizenship\n11.Set Id\n12.Set Username\n13.Set Email");
    		if(line=="1")editPassword();
    	}
    	if(this instanceof Admin) {
    		System.out.println("Choose:\n1.Set New Password\n2.Set Name\n3.Set Last Name\n4.Set Father Name\n5.Set Birth Day\n6.Set Phone Number\n7.Set Pasport Number\n8.Set Gender\n9.Set Nationality\n10.Set Citizenship");
    		
    	}
    }

    public boolean editPassword() {
        return false;
    }

    public String accesingFeedback() {
        return "";
    }

    public String viewNews() {
        return "";
    }

    public String getNotifications() {
        return "";
    }
    

    public String getUserId() {
        return "";
    }

    public String getUserInformation() {
        return "";
    }

    public String showMenu() {
        return "";
    }

    public void sendMessage() {
    }


    
}
