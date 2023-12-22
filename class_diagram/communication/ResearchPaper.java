package communication;

import java.util.Date;
import java.util.Vector;

import enums.*;

public class ResearchPaper {
	private int cnt = 1;
    private int paperId;
    private String paperTitle;
    private String paperWording;
    private Vector<String> paperAuthors;
    private Date publishedDate;
    private Vector<String> references;//links to the papers Researcher used
    private Vector<String> citations;//links to papers that cited this paper
    
    public ResearchPaper(int paperId, String paperTitle, String paperWording,
			Vector<String> paperAuthors, Vector<String> references, Vector<String> citations) {
		this.paperId = cnt++;
		this.paperTitle = paperTitle;
		this.paperWording = paperWording;
		this.paperAuthors = paperAuthors;
		this.references = references;
		this.citations = citations;
		this.publishedDate = new Date();
	}

	void printPaper() {
    	System.out.println(toString());
    }
	public String toCite(PaperFormat format) {
		return "";
	}

    public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Vector<String> getReferences() {
		return references;
	}

	public void setReferences(Vector<String> references) {
		this.references = references;
	}

	public Vector<String> getCitations() {
		return citations;
	}

	public void setCitations(Vector<String> citations) {
		this.citations = citations;
	}

	public int getPaperId() {
        return this.paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return this.paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperWording() {
        return this.paperWording;
    }

    public void setPaperWording(String paperWording) {
        this.paperWording = paperWording;
    }

    public Vector<String> getPaperAuthors() {
        return this.paperAuthors;
    }

    public void setPaperAuthors(Vector<String> paperAuthors) {
        this.paperAuthors = paperAuthors;
    }

    public Date getpublishedDate() {
        return this.publishedDate;
    }

    public void setpublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getArticleLength() {
        return 0;
    }

	@Override
	public String toString() {
		return "Paper Id = " + paperId + "\n Title = " + paperTitle
				+ "\n Wording = " + paperWording + "\n Authors = " + paperAuthors
				+ "\n Published Date = " + publishedDate + "\n References = " + references
				+ "\n Citations = " + citations;
	}
    
    
}
