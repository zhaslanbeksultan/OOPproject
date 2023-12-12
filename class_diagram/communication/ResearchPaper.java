package communication;

import Date;
import Vector;
public class ResearchPaper {

    private int paperId;
  
    private String reasearchPaperTitle;
 
    private String reasearchPaperWording;
 
    private String researchPaperTopic;
 
    private Vector researchPaperAuthors;

    private Date reserchPaperWrittenDate;
    
    private int getPaperId() {
        return this.paperId;
    }
    
    private int setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getReasearchPaperTitle() {
        return this.reasearchPaperTitle;
    }

    public String setReasearchPaperTitle(String reasearchPaperTitle) {
        this.reasearchPaperTitle = reasearchPaperTitle;
    }
    
    private String getReasearchPaperWording() {
        return this.reasearchPaperWording;
    }

    private String setReasearchPaperWording(String reasearchPaperWording) {
        this.reasearchPaperWording = reasearchPaperWording;
    }
    
    private String getResearchPaperTopic() {
        return this.researchPaperTopic;
    }

    private String setResearchPaperTopic(String researchPaperTopic) {
        this.researchPaperTopic = researchPaperTopic;
    }

    private Vector getResearchPaperAuthors() {
        return this.researchPaperAuthors;
    }

    private Vector setResearchPaperAuthors(Vector researchPaperAuthors) {
        this.researchPaperAuthors = researchPaperAuthors;
    }

    private Date getReserchPaperWrittenDate() {
        return this.reserchPaperWrittenDate;
    }

    private Date setReserchPaperWrittenDate(Date reserchPaperWrittenDate) {
        this.reserchPaperWrittenDate = reserchPaperWrittenDate;
    }

    public int getPaperId() {
        return 0;
    }

    public String getResearchPaperTopic() {
    
        return "";
    }
 
    public Vector getResearchPaperAuthors() {
    
        return null;
    }

    public Date getResearchPaperWrittenDate() {
        return new Date();
    }
 
    public int getArticleLength() {
    
        return 0;
    }
    
    
}
