package class-diagram;


/**
* @generated
*/
public class Teacher extends TechSupportSpecialistUserEmployee implements CanBorrowBook, Managable {
    
    /**
    * @generated
    */
    private String EducationDegree;
    
    /**
    * @generated
    */
    private Vector ResearchInterests;
    
    
    /**
    * @generated
    */
    private GraduateStudent graduateStudent;
    
    /**
    * @generated
    */
    private GraduateStudent graduateStudent;
    
    /**
    * @generated
    */
    private Course course;
    
    /**
    * @generated
    */
    private Set<Course> course;
    
    

    /**
    * @generated
    */
    private String getEducationDegree() {
        return this.EducationDegree;
    }
    
    /**
    * @generated
    */
    private String setEducationDegree(String EducationDegree) {
        this.EducationDegree = EducationDegree;
    }
    
    
    /**
    * @generated
    */
    private Vector getResearchInterests() {
        return this.ResearchInterests;
    }
    
    /**
    * @generated
    */
    private Vector setResearchInterests(Vector ResearchInterests) {
        this.ResearchInterests = ResearchInterests;
    }
    
    
    
    /**
    * @generated
    */
    public GraduateStudent getGraduateStudent() {
        return this.graduateStudent;
    }
    
    /**
    * @generated
    */
    public GraduateStudent setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }
    
    
    /**
    * @generated
    */
    public GraduateStudent getGraduateStudent() {
        return this.graduateStudent;
    }
    
    /**
    * @generated
    */
    public GraduateStudent setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }
    
    
    /**
    * @generated
    */
    public Course getCourse() {
        return this.course;
    }
    
    /**
    * @generated
    */
    public Course setCourse(Course course) {
        this.course = course;
    }
    
    
    /**
    * @generated
    */
    public Set<Course> getCourse() {
        if (this.course == null) {
            this.course = new HashSet<Course>();
        }
        return this.course;
    }
    
    /**
    * @generated
    */
    public Set<Course> setCourse(Course course) {
        this.course = course;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public String sendComplaintToDean() {
        //TODO
        return "";
    }
    
    /**
    * @generated
    */
    public int enteringGrades() {
        //TODO
        return 0;
    }
    
    /**
    * @generated
    */
    public boolean officeHoursTeaching() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public Vector createCourseMaterail() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public double putMark() {
        //TODO
        return 0.0;
    }
    
    /**
    * @generated
    */
    public double putAttestation () {
        //TODO
        return 0.0;
    }
    
    /**
    * @generated
    */
    public double putFinalScore() {
        //TODO
        return 0.0;
    }
    
    
}
