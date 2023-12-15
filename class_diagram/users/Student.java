import Date;
import Vector;

package users;


/**
* @generated
*/
public class Student extends User implements CanBorrowBook, Educationable, Administrationable {
    
    /**
    * @generated
    */
    private double gpa;
    
    /**
    * @generated
    */
    private int studyYear;
    
    /**
    * @generated
    */
    private Faculty faculty;
    
    /**
    * @generated
    */
    private Date enrollmentDate;
    
    /**
    * @generated
    */
    private Vector coursesTaught;
    
    /**
    * @generated
    */
    private String major;
    
    /**
    * @generated
    */
    private String school;
    
    
    /**
    * @generated
    */
    private Organizations organizations;
    
    /**
    * @generated
    */
    private Organizations organizations;
    
    

    /**
    * @generated
    */
    private double getGpa() {
        return this.gpa;
    }
    
    /**
    * @generated
    */
    private double setGpa(Real gpa) {
        this.gpa = gpa;
    }
    
    
    /**
    * @generated
    */
    private int getStudyYear() {
        return this.studyYear;
    }
    
    /**
    * @generated
    */
    private int setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }
    
    
    /**
    * @generated
    */
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    /**
    * @generated
    */
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    
    /**
    * @generated
    */
    private Date getEnrollmentDate() {
        return this.enrollmentDate;
    }
    
    /**
    * @generated
    */
    private Date setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    
    /**
    * @generated
    */
    private Vector getCoursesTaught() {
        return this.coursesTaught;
    }
    
    /**
    * @generated
    */
    private Vector setCoursesTaught(Vector coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
    
    
    /**
    * @generated
    */
    private String getMajor() {
        return this.major;
    }
    
    /**
    * @generated
    */
    private String setMajor(String major) {
        this.major = major;
    }
    
    
    /**
    * @generated
    */
    private String getSchool() {
        return this.school;
    }
    
    /**
    * @generated
    */
    private String setSchool(String school) {
        this.school = school;
    }
    
    
    
    /**
    * @generated
    */
    public Organizations getOrganizations() {
        return this.organizations;
    }
    
    /**
    * @generated
    */
    public Organizations setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }
    
    
    /**
    * @generated
    */
    public Organizations getOrganizations() {
        return this.organizations;
    }
    
    /**
    * @generated
    */
    public Organizations setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Vector getCoursesEnrolled() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public double getGpa() {
        //TODO
        return 0.0;
    }
    
    /**
    * @generated
    */
    public String getFaculty() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public String getReport() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public HashMap getTranscipt() {
        //TODO
        return null;
    }

	public int getCourse() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
