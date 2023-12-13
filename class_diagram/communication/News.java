package communication;

import java.util.Vector;
import users.User;

public class News {

    private String newsType;
    private String newsTitle;
    private String newsWording;
    private Vector<String> newsComments; 
    private User user;

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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean viewNews() {
        return false;
    }

    public String respondToNews() {
        return "";
    }
}
