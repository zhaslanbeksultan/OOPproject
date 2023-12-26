package communication;

import java.io.Serializable;
import java.util.Vector;

import userCapabilities.*;


public class ResearchProject implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cnt = 1;
	private int projectId;
    private String journalName;
    private String topic;
    private Vector<String> participants;
    private Vector<ResearchPaper> publishedPapers;
    private String supervisor;
    private Vector<Subscriber> subscribers;
    
    public ResearchProject(String journalName, String topic, String supervisor) {
		this.journalName = journalName;
		this.topic = topic;
		this.supervisor = supervisor;
		this.participants = new Vector<>();
		this.publishedPapers = new Vector<>();
		this.subscribers = new Vector<>();
		this.setProjectId(cnt++);
	}

	public void notifySubscribers(String paperTitle) {
    	this.subscribers.stream().forEach(s -> s.notifySubscriber(this.journalName, paperTitle, paperTitle));
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Vector<String> getParticipants() {
        return this.participants;
    }

    public void setParticipants(String participant) {
        this.participants.add(participant);
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }

    public void setPublishedPapers(ResearchPaper publishedPaper) {
        this.publishedPapers.add(publishedPaper);
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

    public String getSupervisorName() {
        return this.supervisor;
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

	@Override
	public String toString() {
		return "Project Id = " + projectId + ", Journal Name = " + journalName + ", Topic = " + topic + ", Participants = " + participants
				+ ", Supervisor = " + supervisor;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
