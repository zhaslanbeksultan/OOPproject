import java.util.Date;

import enums.Gender;

package users;


/**
* @generated
*/
public class User {
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

    private String setPassword(String password) {
        this.password = password;
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

    public String editPersonalData() {
        return "";
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
