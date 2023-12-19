package users;

import java.util.Date;
import java.util.Vector;

import education.Course;
import enums.DegreeType;
import enums.Faculty;
import enums.Gender;

/**
* @generated
*/
public class GraduateStudent extends StudentResearcher {
    
    public GraduateStudent(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double gpa, int studyYear, Faculty faculty,
			Date enrollmentDate, Vector<Course> coursesEnrolled, String major, Vector<Organization> organizations,
			int hindex, ResarchDecorator resarchDecorator) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, gpa, studyYear, faculty, enrollmentDate, coursesEnrolled, major,
				organizations, hindex, resarchDecorator);
		// TODO Auto-generated constructor stub
	}

	/**
    * @generated
    */
    private Date graduatingDate;
    
    /**
    * @generated
    */
    private String diplomaTytle;
    
    /**
    * @generated
    */
    private DegreeType degreeType;
    
    /**
    * @generated
    */
    private String supervisor;
    
    
    /**
    * @generated
    */
    private Teacher teacher;
    
    /**
    * @generated
    */
    
    

    /**
    * @generated
    */
    private Date getGraduatingDate() {
        return this.graduatingDate;
    }
    
    /**
    * @generated
    */
    private void setGraduatingDate(Date graduatingDate) {
        this.graduatingDate = graduatingDate;
    }
    
    
    /**
    * @generated
    */
    private String getDiplomaTytle() {
        return this.diplomaTytle;
    }
    
    /**
    * @generated
    */
    private void setDiplomaTytle(String diplomaTytle) {
        this.diplomaTytle = diplomaTytle;
    }
    
    
    /**
    * @generated
    */
    private DegreeType getDegreeType() {
        return this.degreeType;
    }
    
    /**
    * @generated
    */
    private void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }
    
    
    /**
    * @generated
    */
    public String getSupervisor() {
        return this.supervisor;
    }
    
    /**
    * @generated
    */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    
    
    
    /**
    * @generated
    */
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    /**
    * @generated
    */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
  
    
    
    

    //                          Operations                                  
    
    
}
