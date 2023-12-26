package communication;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;
import users.User;
import java.util.HashMap;

public class News implements Comparable<News>, Serializable{

	private static final long serialVersionUID = 1L;
	private static int cnt = 1;
	private int newsId;
	private String recipients;
    private String newsTitle;
    private String newsWording;
    private Date postSentDate;
    private HashMap<String,String> newsComments;

    public News(String recipients, String newsTitle, String newsWording) {
    	this.recipients = recipients;
		this.newsTitle = newsTitle;
		this.newsWording = newsWording;
    	this.newsId = cnt++;
		postSentDate = new Date();
	}
   
	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

    public String getNewsTitle() {
        return this.newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsWording() {
        return this.newsWording;
    }

    public void setNewsWording(String newsWording) {
        this.newsWording = newsWording;
    }

    public HashMap<String,String> getNewsComments() {
        return this.newsComments;
    }

    public void setNewsComments(String username, String comment) {
        this.newsComments.put(username, comment);
    }

	@Override
	public String toString() {
		return "Post Id=" + newsId + ", newsTitle="
				+ newsTitle + ", postSentDate=" + postSentDate;
	}
	@Override
    public int compareTo(News other) {
        if (this.newsTitle.equals("Research") && !other.newsTitle.equals("Research")) {
            return -1;
        } else if (!this.newsTitle.equals("Research") && other.newsTitle.equals("Research")) {
            return 1; 
        } else {
        	return this.postSentDate.compareTo(other.postSentDate);
        }
    }
    
    
}
