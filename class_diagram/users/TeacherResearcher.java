package users;

import java.util.Date;
import java.util.Set;

import communication.ResearchProject;
import education.Course;
import enums.Gender;
import userCapabilities.Researcher;


public class TeacherResearcher extends Teacher implements Researcher {

	public TeacherResearcher(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber,
			Set<Course> courses, GraduateStudent graduateStudent, Course course, int hindex,
			ResarchDecorator resarchDecorator) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber, courses,
				graduateStudent, course);
		this.hindex = hindex;
		this.resarchDecorator = resarchDecorator;
	}

	private int hindex;

    private ResarchDecorator resarchDecorator;

    public int getHindex() {
        return this.hindex;
    }

    public void setHindex(int hindex) {
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
    
    
    
}
