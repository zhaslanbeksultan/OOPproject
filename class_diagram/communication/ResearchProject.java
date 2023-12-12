import Date;
import Vector;

package communication;

public class ResearchProject {
    
    private String topic;

    private Vector participants;

    private Vector publishedPapers;

    private Date publishedDate;

    private  supervisor;

    private  ;
 
    private Vector researchPapers;

    private String reviewCritique;
 
    private Researcher researcher;

    private String getTopic() {
        return this.topic;
    }
 
    private String setTopic(String topic) {
        this.topic = topic;
    }
 
    private Vector getParticipants() {
        return this.participants;
    }
    
  
    private Vector setParticipants(Vector participants) {
        this.participants = participants;
    }
    
 
    private Vector getPublishedPapers() {
        return this.publishedPapers;
    }
  
    private Vector setPublishedPapers(Vector publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    private Date getPublishedDate() {
        return this.publishedDate;
    }
  
    private Date setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    private  getSupervisor() {
        return this.supervisor;
    }

    private  setSupervisor(invalid supervisor) {
        this.supervisor = supervisor;
    }
    

    public  get() {
        return this.;
    }
  
    public  set(invalid ) {
        this. = ;
    }
    

    public Vector getResearchPapers() {
        return this.researchPapers;
    }
    
 
    public Vector setResearchPapers(Vector researchPapers) {
        this.researchPapers = researchPapers;
    }
    

    private String getReviewCritique() {
        return this.reviewCritique;
    }

    private String setReviewCritique(String reviewCritique) {
        this.reviewCritique = reviewCritique;
    }
    

    public Researcher getResearcher() {
        return this.researcher;
    }
   
    public Researcher setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public String getResearchProjectTopic() {
       
        return "";
    }

    public Vector getWritersOfResearch() {
     
        return null;
    }

    public String getSupervisor() {
        
        return "";
    }
    
  
    public ResearchPaper toReferenceToPapers() {
  
        return null;
    }
    

    public String getReview() {
     
        return "";
    }

    public boolean checkSupervisorEligibility() {

        return false;
    }
    
    
}
