import Date;
import users.Employee;

package communication;



public class Message {
    
    private String messageId;

    private MessageType messageType;

    private String theme;
    
    private String sender;

    private String recipient;

    private Date messageSentDate;
    

    private String messageWording;
    

    private Employee employee;
    

    private Employee employee;
    
  
    private User user;
    
    private String getMessageId() {
        return this.messageId;
    }

    private String setMessageId(String messageId) {
        this.messageId = messageId;
    }
    
    

    private MessageType getMessageType() {
        return this.messageType;
    }
    
    private MessageType setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    
 
    private String getTheme() {
        return this.theme;
    }
    

    private String setTheme(String theme) {
        this.theme = theme;
    }
    

    private String getSender() {
        return this.sender;
    }

    private String setSender(String sender) {
        this.sender = sender;
    }
    

    private String getRecipient() {
        return this.recipient;
    }

    private String setRecipient(String recipient) {
        this.recipient = recipient;
    }
    

    private Date getMessageSentDate() {
        return this.messageSentDate;
    }
    

    private Date setMessageSentDate(Date messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    private String getMessageWording() {
        return this.messageWording;
    }
    

    private String setMessageWording(String messageWording) {
        this.messageWording = messageWording;
    }
    

    public Employee getEmployee() {
        return this.employee;
    }
    

    public Employee setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Employee setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    

    public User getUser() {
        return this.user;
    }
  
    public User setUser(User user) {
        this.user = user;
    }
    

    public String viewMessageId() {
        
        return "";
    }
    

    public String answerToMessage() {
    
        return "";
    }

    public String getMessageWording() {
    
        return "";
    }
    
    
}
