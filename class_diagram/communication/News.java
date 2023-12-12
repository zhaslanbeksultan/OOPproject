package communication;

import Vector;

public class News {

    private NewsType newsType;
    
    private String newsTitle;
    

    private String newsWording;
   
    private Vector newsComments;
    

    private User user;

    private NewsType getNewsType() {
        return this.newsType;
    }
    
   
    private NewsType setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }
    
    

    private String getNewsTitle() {
        return this.newsTitle;
    }
    

    private String setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    
 
    private String getNewsWording() {
        return this.newsWording;
    }
 
    private String setNewsWording(String newsWording) {
        this.newsWording = newsWording;
    }
    
  
    private Vector getNewsComments() {
        return this.newsComments;
    }
    

    private Vector setNewsComments(Vector newsComments) {
        this.newsComments = newsComments;
    }
    
    

    public User getUser() {
        return this.user;
    }
  
    public User setUser(User user) {
        this.user = user;
    }
    
    
    

    public boolean viewNews() {
    
        return false;
    }
    
  
    public String getNewsTitle() {
        
        return "";
    }
    
  
    public String respondToNews() {
        
        return "";
    }
    
 
    public String getNewsWording() {
        
        return "";
    }
    
    
}
