package communication;
import java.util.Date;
import enums.MessageType;
import users.Employee;


public class Message {
    private MessageType messageType;
    private String theme;
    private String sender;
    private String recipient;
    private Date messageSentDate;
    private String messageWording;
    
    {
    	messageSentDate = new Date();
    }
    
    public Message(String messageType, String theme, String sender, String recipient, String messageWording) {
		this.messageType = messageType;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
	}

    private MessageType getMessageType() {
        return this.messageType;
    }
    
    private void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
    
 
    private String getTheme() {
        return this.theme;
    }
    

    private void setTheme(String theme) {
        this.theme = theme;
    }
    

    private String getSender() {
        return this.sender;
    }

    private void setSender(String sender) {
        this.sender = sender;
    }
    

    private String getRecipient() {
        return this.recipient;
    }

    private void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    

    private Date getMessageSentDate() {
        return this.messageSentDate;
    }
    

    private void setMessageSentDate(Date messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    private String getMessageWording() {
        return this.messageWording;
    }
    

    private void setMessageWording(String messageWording) {
        this.messageWording = messageWording;
    }

    public String viewMessageId() {
        
        return "";
    }
    

    public String answerToMessage() {
    
        return "";
    }

	@Override
	public String toString() {
		return "Theme = " + theme + ", sender=" + sender;
	}
    
    
}
