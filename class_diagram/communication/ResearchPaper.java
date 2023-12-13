package communication;

import java.util.Date;
import java.util.Vector;

public class ResearchPaper {

    private int paperId;
    private String researchPaperTitle;
    private String researchPaperWording;
    private String researchPaperTopic;
    private Vector<String> researchPaperAuthors;
    private Date researchPaperWrittenDate;

    public int getPaperId() {
        return this.paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getResearchPaperTitle() {
        return this.researchPaperTitle;
    }

    public void setResearchPaperTitle(String researchPaperTitle) {
        this.researchPaperTitle = researchPaperTitle;
    }

    public String getResearchPaperWording() {
        return this.researchPaperWording;
    }

    public void setResearchPaperWording(String researchPaperWording) {
        this.researchPaperWording = researchPaperWording;
    }

    public String getResearchPaperTopic() {
        return this.researchPaperTopic;
    }

    public void setResearchPaperTopic(String researchPaperTopic) {
        this.researchPaperTopic = researchPaperTopic;
    }

    public Vector<String> getResearchPaperAuthors() {
        return this.researchPaperAuthors;
    }

    public void setResearchPaperAuthors(Vector<String> researchPaperAuthors) {
        this.researchPaperAuthors = researchPaperAuthors;
    }

    public Date getResearchPaperWrittenDate() {
        return this.researchPaperWrittenDate;
    }

    public void setResearchPaperWrittenDate(Date researchPaperWrittenDate) {
        this.researchPaperWrittenDate = researchPaperWrittenDate;
    }

    public int getArticleLength() {
        return 0;
    }
}
