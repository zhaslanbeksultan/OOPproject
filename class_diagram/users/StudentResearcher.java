package users;

import java.util.Date;
import java.util.Vector;
import communication.*;
import education.*;
import enums.*;
import userCapabilities.*;

public class StudentResearcher extends Student implements Researcher {

    private int hindex;
    private ResarchDecorator resarchDecorator;

    public StudentResearcher(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double gpa, int studyYear, Faculty faculty,
			Date enrollmentDate, Category category, Vector<Course> coursesEnrolled, String major,
			Vector<Organization> organizations, ResarchDecorator resarchDecorator) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, gpa, studyYear, faculty, enrollmentDate, category,
				coursesEnrolled, major, organizations);
		this.resarchDecorator = resarchDecorator;
	}

	public int getHindex() {
        return this.hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public ResarchDecorator getResarchDecorator() {
        return this.resarchDecorator;
    }

    public void setResarchDecorator(ResarchDecorator resarchDecorator) {
        this.resarchDecorator = resarchDecorator;
    }

	@Override
	public void writeNewResearch(ResearchProject research) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double findGIndex(String researcherId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void conductResearch(String researchTopic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPapers() {
		// TODO Auto-generated method stub
		
	}
	public void researchCabinet() {}
    
	@Override
    public void showMenu() {
    	super.showMenu();
    }
    
}
