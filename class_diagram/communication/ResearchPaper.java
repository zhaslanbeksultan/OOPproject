package communication;

import java.util.Date;
import java.util.Vector;

import common.DateStringFormat;
import enums.*;

public class ResearchPaper {
	private int cnt = 1;
    private int paperId;
    private String researchProject;
    private String paperTitle;
    private String paperWording;
    private String paperAuthor;
    private Date publishedDate;
    private Vector<String> references;//links to the papers Researcher used
    private Vector<String> citations;//links to papers that cited this paper
    
    public ResearchPaper(String researchProject, String paperTitle, String paperWording,
			String paperAuthor) {
		this.paperId = cnt++;
		this.researchProject = researchProject;
		this.paperTitle = paperTitle;
		this.paperWording = paperWording;
		this.paperAuthor = paperAuthor;
		this.publishedDate = new Date();
	}

	public void printPaper() {
    	System.out.println(toString() + "Paper Authors = " + paperAuthor
    			+ "Paper wording = " + paperWording + "References of Papers Cited In This Paper = " + references
    			+ "Papers Cited This Paper: " + citations);
    }
	public String getCitation(PaperFormat format) {
		if(format.equals(PaperFormat.PLAIN_TEXT)) {
			return "Title: " + paperTitle + "\nAuthor: " + paperAuthor + "\nJournal: " + researchProject
					+ "\nPublished Date: " + publishedDate;
		}
		else {
			return "@research paper{" + paperAuthor + DateStringFormat.year(publishedDate)
			+ "\nauthor = {" + paperAuthor + "},\ntitle = {" + paperTitle + "},\njournal = {" + researchProject
			+ "},\nyear = {" + DateStringFormat.year(publishedDate) +"}\n}";
		}
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

	public void setReferences(String references) {
		this.references.add(references);
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

    public String getPaperAuthor() {
        return this.paperAuthor;
    }

    public void setPaperAuthor(String paperAuthors) {
        this.paperAuthor = paperAuthors;
    }

    public Date getpublishedDate() {
        return this.publishedDate;
    }

    public void setpublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getArticleLength() {
    	return this.paperWording.length();
    }

	@Override
	public String toString() {
		return "Paper Id = " + paperId + "\n Title = " + paperTitle + "\n Published Date = " + publishedDate;
	}

	public String getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(String researchProject) {
		this.researchProject = researchProject;
	}
    
    
}
