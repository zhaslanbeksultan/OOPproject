package communication;

import java.util.Date;
import java.util.HashMap;
import enums.*;

public class Message {
    private static int cnt = 1;
    private int messageId;
    private MessageType messageType;
    private String theme;
    private String sender;
    private String recipient;
    private Date messageSentDate;
    private String messageWording;
    private int answeredMessage = -1;
    private MessageStatus status;
    private HashMap<String, String> messageReplies = new HashMap<>();

    public Message(MessageType messageType, String theme, String sender, String recipient, String messageWording) {
        this.messageId = cnt++;
        this.messageType = messageType;
        this.theme = theme;
        this.sender = sender;
        this.recipient = recipient;
        this.messageWording = messageWording;
        this.status = MessageStatus.UNREAD;
        this.messageSentDate = new Date();
    }

    public Message(MessageType messageType, String theme, String sender, String recipient, String messageWording, int answeredMessage) {
        this.messageId = cnt++;
        this.messageType = messageType;
        this.answeredMessage = answeredMessage;
        this.theme = theme;
        this.sender = sender;
        this.recipient = recipient;
        this.messageWording = messageWording;
        this.status = MessageStatus.UNREAD;
        this.messageSentDate = new Date();
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
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

    public HashMap<String, String> getMessageReplies() {
        return this.messageReplies;
    }

    public Message sendReply(String replyWording) {
        Message reply = new Message(this.messageType, "Re: " + this.theme, this.recipient, this.sender, replyWording, this.messageId);
        reply.setStatus(MessageStatus.SENT);
        this.messageReplies.put(reply.getRecipient(), replyWording);
        return reply;
    }

    @Override
    public String toString() {
        return "Message Id: " + messageId + ", Type: " + messageType + ", Theme = " + theme +
                ", Sender = " + sender + ", Status: " + status + ", Sent Date: " + messageSentDate;
    }
}

