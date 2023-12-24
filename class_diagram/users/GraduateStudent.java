package users;

import java.util.Date;
import java.util.Vector;

import education.Course;
import enums.Category;
import enums.DegreeType;
import enums.Faculty;
import enums.Gender;
import userCapabilities.Researcher;

public class GraduateStudent extends Student {
    
    private Date graduatingDate;
    private String diplomaTytle;
    private DegreeType degreeType;
    private Researcher supervisor;
    
    public GraduateStudent(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double gpa, int studyYear, Faculty faculty,
			Date enrollmentDate, Category category, Vector<Course> coursesEnrolled, String major,
			Vector<Organization> organizations) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, gpa, studyYear, faculty, enrollmentDate, category,
				coursesEnrolled, major, organizations);
	}
    
    public GraduateStudent(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double gpa, int studyYear, Faculty faculty,
			Date enrollmentDate, Category category, Vector<Course> coursesEnrolled, String major,
			Vector<Organization> organizations, Date graduatingDate,
			String diplomaTytle, DegreeType degreeType, Researcher supervisor) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, gpa, studyYear, faculty, enrollmentDate, category,
				coursesEnrolled, major, organizations);
		this.graduatingDate = graduatingDate;
		this.diplomaTytle = diplomaTytle;
		this.degreeType = degreeType;
		this.supervisor = supervisor;
	}
	public GraduateStudent() {
		// TODO Auto-generated constructor stub
	}

	private Date getGraduatingDate() {
        return this.graduatingDate;
    }
    private void setGraduatingDate(Date graduatingDate) {
        this.graduatingDate = graduatingDate;
    }

    private String getDiplomaTytle() {
        return this.diplomaTytle;
    }

    private void setDiplomaTytle(String diplomaTytle) {
        this.diplomaTytle = diplomaTytle;
    }
    
    private DegreeType getDegreeType() {
        return this.degreeType;
    }

    private void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public Researcher getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
    }



}
