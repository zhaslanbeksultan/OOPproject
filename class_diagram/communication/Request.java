package communication;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import enums.*;
import users.User;

public class Request {
	private String requester;
	private HelpForm helpForm;
	private HelpType helpType;
	private Language language;
	private Faculty faculty;
	private String additionallyInfo;
	private RequestStatus requestStatus;
	private RequestType requestType;
	private Date requestDate;
	
	public Request(String requester, HelpForm helpForm, HelpType helpType, Language language, Faculty faculty,
			String additionallyInfo, RequestStatus requestStatus, RequestType requestType) {
		this.requester = requester;
		this.helpForm = helpForm;
		this.helpType = helpType;
		this.language = language;
		this.faculty = faculty;
		this.additionallyInfo = additionallyInfo;
		this.requestDate = new Date();
	}
	public HelpForm getHelpForm() {
		return helpForm;
	}
	public void setHelpForm(HelpForm helpForm) {
		this.helpForm = helpForm;
	}
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getAdditionallyInfo() {
		return additionallyInfo;
	}
	public void setAdditionallyInfo(String additionallyInfo) {
		this.additionallyInfo = additionallyInfo;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	
	public HelpType getHelpType() {
		return helpType;
	}
	public void setHelpType(HelpType helpType) {
		this.helpType = helpType;
	}
	public RequestStatus getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Override
	public String toString() {
		return "Help Form = " + helpForm + ", Help Type = " + helpType + ", Language = "
				+ language + ", Status = " + requestStatus + ", Date = " + requestDate;
	}
	
}
