package communication;

import java.util.Date;
import java.util.Vector;
import userCapabilities.*;


public class ResearchProject {
    private String journalName;
    private String topic;
    private Vector<Researcher> participants;
    private Vector<ResearchPaper> publishedPapers;
    private String supervisor;
    private Vector<Subscriber> subscribers;
    
    public void notifySubscribers(String paperTitle) {
    	this.subscribers.stream().forEach(s -> s.notifySubscriber(this.journalName, paperTitle, paperTitle));
//    	for(Subscriber s: this.subscribers) {
//    		s.notifySubscriber(this.journalName, paperTitle, paperTitle);
//    	}
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Vector<Researcher> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }

    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getResearchProjectTopic() {
        return this.topic;
    }

    public Vector<Researcher> getWritersOfResearch() {
        return this.participants;
    }

    public String getSupervisorName() {
        return this.supervisor;
    }

    public ResearchPaper toReferenceToPapers() {
        return null;
    }

    public boolean checkSupervisorEligibility() {
    	
        return false;
    }

	public Vector<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Subscriber subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void removeSubscribers(Subscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
}
