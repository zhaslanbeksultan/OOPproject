package communication;

import java.util.Date;
import java.util.Vector;
import users.User;

public class News {
	private static int cnt = 1;
	private int newsId;
	private String recipients;
    private String newsType;
    private String newsTitle;
    private String newsWording;
    private Date postSentDate;
    private Vector<String> newsComments;

    public News(String recipients, String newsType, String newsTitle, String newsWording) {
    	this.recipients = recipients;
		this.newsType = newsType;
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

	public String getNewsType() {
        return this.newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
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

    public Vector<String> getNewsComments() {
        return this.newsComments;
    }

    public void setNewsComments(Vector<String> newsComments) {
        this.newsComments = newsComments;
    }

    public boolean viewNews() {
        return false;
    }

    public String respondToNews() {
        return "";
    }

	@Override
	public String toString() {
		return "Post Id=" + newsId + ", newsType=" + newsType + ", newsTitle="
				+ newsTitle + ", postSentDate=" + postSentDate;
	}
    
    
}
