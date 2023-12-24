package communication;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import enums.*;
import users.User;

public class Request {
	private static int cnt = 1;
	private int requestId;
	private String requester;
	private HelpForm helpForm;
	private HelpType helpType;
	private Language language;
	private Faculty faculty;//deans faculty who
	private String additionallyInfo;
	private RequestStatus requestStatus;
	private Date requestDate;
	
	public Request(String requester, String helpForm, String helpType, String language, Faculty faculty) {
		this.requester = requester;
		if(helpForm.equals("Paper"))
			this.helpForm = HelpForm.PAPER;
		if(helpForm.equals("Electronic"))
			this.helpForm = HelpForm.ELECTRONIC;
		if(helpType.equals("REQUEST_FOR_ACADEMIC_MOBILITY"))
			this.helpType = HelpType.REQUEST_FOR_ACADEMIC_MOBILITY;
		if(helpType.equals("COORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA"))
			this.helpType = HelpType.COORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA;
		if(helpType.equals("WORKAROUND_SHEET"))
			this.helpType = HelpType.WORKAROUND_SHEET;
		if(helpType.equals("CERTIFICATE_OF_EDUCATION_IN_ENGLISH"))
			this.helpType = HelpType.CERTIFICATE_OF_EDUCATION_IN_ENGLISH;
		if(helpType.equals("RESTORING_ONAY_CARD"))
			this.helpType = HelpType.RESTORING_ONAY_CARD;
		if(helpType.equals("REQUEST_FOR_CREATING_ORGAIZATION"))
			this.helpType = HelpType.REQUEST_FOR_CREATING_ORGAIZATION;
		if(helpType.equals("HELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"))
			this.helpType = HelpType.HELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS;
		if(helpType.equals("HELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES"))
			this.helpType = HelpType.HELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES;
		if(helpType.equals("HELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"))
			this.helpType = HelpType.HELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER;
		if(helpType.equals("HELP_FOR_FINANCING_KAZENERGY"))
			this.helpType = HelpType.HELP_FOR_FINANCING_KAZENERGY;
		if(helpType.equals("INFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT"))
			this.helpType = HelpType.INFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT;
		if(helpType.equals("TRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY;
		if(helpType.equals("TRANSCRIPT_FOR_THE_YEAR"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_YEAR;
		if(helpType.equals("TRANSCRIPT_FOR_THE_SEMESTER"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_SEMESTER;
		if(language.equals("EN"))
			this.language = Language.ENGLISH;
		if(language.equals("RU"))
			this.language = Language.RUSSIAN;
		if(language.equals("KZ"))
			this.language = Language.KAZAKH;
		this.faculty = faculty;
		this.requestDate = new Date();
		this.requestId = cnt++;
		this.requestStatus = RequestStatus.NOT_ACCEPTED;
	}
	public Request(String requester, String helpForm, String helpType, String language) {
		this.requester = requester;
		if(helpForm.equals("Paper"))
			this.helpForm = HelpForm.PAPER;
		if(helpForm.equals("Electronic"))
			this.helpForm = HelpForm.ELECTRONIC;
		if(helpType.equals("REQUEST_FOR_ACADEMIC_MOBILITY"))
			this.helpType = HelpType.REQUEST_FOR_ACADEMIC_MOBILITY;
		if(helpType.equals("COORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA"))
			this.helpType = HelpType.COORDINATION_OF_THE_TOPIC_OF_THE_DIPLOMA;
		if(helpType.equals("WORKAROUND_SHEET"))
			this.helpType = HelpType.WORKAROUND_SHEET;
		if(helpType.equals("CERTIFICATE_OF_EDUCATION_IN_ENGLISH"))
			this.helpType = HelpType.CERTIFICATE_OF_EDUCATION_IN_ENGLISH;
		if(helpType.equals("RESTORING_ONAY_CARD"))
			this.helpType = HelpType.RESTORING_ONAY_CARD;
		if(helpType.equals("HELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"))
			this.helpType = HelpType.HELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS;
		if(helpType.equals("REQUEST_FOR_CREATING_ORGAIZATION"))
			this.helpType = HelpType.REQUEST_FOR_CREATING_ORGAIZATION;
		if(helpType.equals("HELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES"))
			this.helpType = HelpType.HELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES;
		if(helpType.equals("HELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"))
			this.helpType = HelpType.HELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER;
		if(helpType.equals("HELP_FOR_FINANCING_KAZENERGY"))
			this.helpType = HelpType.HELP_FOR_FINANCING_KAZENERGY;
		if(helpType.equals("INFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT"))
			this.helpType = HelpType.INFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT;
		if(helpType.equals("TRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_ENTIRE_PERIOD_OF_STUDY;
		if(helpType.equals("TRANSCRIPT_FOR_THE_YEAR"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_YEAR;
		if(helpType.equals("TRANSCRIPT_FOR_THE_SEMESTER"))
			this.helpType = HelpType.TRANSCRIPT_FOR_THE_SEMESTER;
		if(language.equals("EN"))
			this.language = Language.ENGLISH;
		if(language.equals("RU"))
			this.language = Language.RUSSIAN;
		if(language.equals("KZ"))
			this.language = Language.KAZAKH;
		this.requestDate = new Date();
		this.requestId = cnt++;
		this.requestStatus = RequestStatus.NOT_ACCEPTED;
	}
	public HelpForm getHelpForm() {
		return helpForm;
	}
	public void setHelpForm(HelpForm helpForm) {
		this.helpForm = helpForm;
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
		return "Request Id = " + requestId + "Help Form = " + helpForm + ", Help Type = " + helpType + ", Language = "
				+ language + ", Status = " + requestStatus + ", Date = " + requestDate;
	}
	
}
