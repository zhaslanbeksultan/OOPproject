package communication;
import java.util.Date;
import enums.*;
import users.Employee;


public class Message implements Comparable<Message> {
	private static int cnt = 1;
	private int messageId;
    private String theme;
    private String sender;
    private String recipient;
    private Date messageSentDate;
    private String messageWording;
    private int answeredMessage = -1;
    private MessageStatus status;
    private UrgencyLevel urgencyLevel;
    
    public Message(String theme, String sender, String recipient, String messageWording, String urgencyLevel) {
    	this.messageId = cnt++;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
		this.status = MessageStatus.UNREAD;
		if(urgencyLevel.equals("LOW")) {
			this.urgencyLevel = UrgencyLevel.LOW;
		}
		
		if(urgencyLevel.equals("MEDIUM")) {
			this.urgencyLevel = UrgencyLevel.MEDIUM;
		}
		if(urgencyLevel.equals("HIGH")) {
			this.urgencyLevel = UrgencyLevel.HIGH;
		}
		messageSentDate = new Date();
	}
    
    public Message(String theme, String sender, String recipient, String messageWording) {
    	this.messageId = cnt++;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
		this.status = MessageStatus.UNREAD;
		messageSentDate = new Date();
	}

    public Message(String theme, String sender, String recipient, String messageWording, int answeredMessage) {
    	this.messageId = cnt++;
    	this.answeredMessage = answeredMessage;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
		this.status = MessageStatus.UNREAD;
		messageSentDate = new Date();
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public int getAnsweredMessage() {
		return answeredMessage;
	}

	public void setAnsweredMessage(int answeredMessage) {
		this.answeredMessage = answeredMessage;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getTheme() {
        return this.theme;
    }
    
	public void setTheme(String theme) {
        this.theme = theme;
    }
    

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    

    public Date getMessageSentDate() {
        return this.messageSentDate;
    }
    

    public void setMessageSentDate(Date messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    public String getMessageWording() {
        return this.messageWording;
    }
    

    public void setMessageWording(String messageWording) {
        this.messageWording = messageWording;
    }
 

	@Override
	public String toString() {
		return "Message Id: " + messageId + ", Theme = " + theme + ", Sender = " + sender + ", Status: " + status
				+ ", Sent Date: " + messageSentDate;
	}

	public UrgencyLevel getUrgencyLevel() {
		return urgencyLevel;
	}

	public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	@Override
    public int compareTo(Message other) {
        if (this.urgencyLevel.equals(UrgencyLevel.LOW) && other.urgencyLevel.equals(UrgencyLevel.MEDIUM)) {
            return -1;}
        else if (this.urgencyLevel.equals(UrgencyLevel.LOW) && other.urgencyLevel.equals(UrgencyLevel.HIGH)) {
            return -1;}
        else if (this.urgencyLevel.equals(UrgencyLevel.MEDIUM) && other.urgencyLevel.equals(UrgencyLevel.HIGH)) {
            return -1;
        }
        else if (this.urgencyLevel.equals(UrgencyLevel.MEDIUM) && other.urgencyLevel.equals(UrgencyLevel.LOW)) {
            return 1;
        }
        else if (this.urgencyLevel.equals(UrgencyLevel.HIGH) && other.urgencyLevel.equals(UrgencyLevel.LOW)) {
            return 1; 
        }
        else if (this.urgencyLevel.equals(UrgencyLevel.HIGH) && other.urgencyLevel.equals(UrgencyLevel.MEDIUM)) {
            return 1; 
        }
        else {
        	return this.messageSentDate.compareTo(other.messageSentDate);
        }
    }
    
}