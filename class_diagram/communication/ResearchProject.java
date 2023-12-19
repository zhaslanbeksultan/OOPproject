package communication;

import java.util.Date;
import java.util.Vector;

import userCapabilities.Researcher;

public class ResearchProject {
    
    private String topic;
    private Vector<String> participants;
    private Vector<String> publishedPapers;
    private Date publishedDate;
    private String supervisor;
    private Vector<ResearchPaper> researchPapers;
    private String reviewCritique;
    private Researcher researcher;

    private String getTopic() {
        return this.topic;
    }

    private void setTopic(String topic) {
        this.topic = topic;
    }

    private Vector<String> getParticipants() {
        return this.participants;
    }

    private void setParticipants(Vector<String> participants) {
        this.participants = participants;
    }

    private Vector<String> getPublishedPapers() {
        return this.publishedPapers;
    }

    private void setPublishedPapers(Vector<String> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    private Date getPublishedDate() {
        return this.publishedDate;
    }

    private void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    private String getSupervisor() {
        return this.supervisor;
    }

    private void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    private Vector<ResearchPaper> getResearchPapers() {
        return this.researchPapers;
    }

    private void setResearchPapers(Vector<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    private String getReviewCritique() {
        return this.reviewCritique;
    }

    private void setReviewCritique(String reviewCritique) {
        this.reviewCritique = reviewCritique;
    }

    public Researcher getResearcher() {
        return this.researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public String getResearchProjectTopic() {
        return this.topic;
    }

    public Vector<String> getWritersOfResearch() {
        return this.participants;
    }

    public String getSupervisorName() {
        return this.supervisor;
    }

    public ResearchPaper toReferenceToPapers() {
        return null;
    }

    public String getReview() {
        return this.reviewCritique;
    }

    public boolean checkSupervisorEligibility() {
    	
        return false;
    }
}
