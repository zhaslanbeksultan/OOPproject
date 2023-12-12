package communication;
import java.util.Date;
import enums.MessageType;
import users.Employee;


public class Message {
	private static int messageId;
    private String theme;
    private String sender;
    private String recipient;
    private Date messageSentDate;
    private String messageWording;
    private int answeredMessage;
    
    static{
    	messageId = 0;
    }
    
    {
    	messageSentDate = new Date();
    }
    
    public Message(String theme, String sender, String recipient, String messageWording) {
    	Message.messageId+=1;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
	}

    public Message(String theme, String sender, String recipient, String messageWording, int answeredMessage) {
    	Message.messageId+=1;
    	this.answeredMessage = answeredMessage;
		this.theme = theme;
		this.sender = sender;
		this.recipient = recipient;
		this.messageWording = messageWording;
	}

	public int getAnsweredMessage() {
		return answeredMessage;
	}

	public void setAnsweredMessage(int answeredMessage) {
		this.answeredMessage = answeredMessage;
	}

	public static int getMessageId() {
		return messageId;
	}

	public static void setMessageId(int messageId) {
		Message.messageId = messageId;
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
    

    public String getRecipient() {
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

    public String getMessageWording() {
        return this.messageWording;
    }
    

    private void setMessageWording(String messageWording) {
        this.messageWording = messageWording;
    }
    

    public String answerToMessage() {
    
        return "";
    }

	@Override
	public String toString() {
		return "Message Id: " + messageId + ", Theme = " + theme + ", Sender=" + sender + ", Sent Date: " + messageSentDate;
	}
    
    
}
