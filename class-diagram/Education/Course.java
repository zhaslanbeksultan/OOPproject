package class-diagram;


/**
* @generated
*/
public class Course {
    
    /**
    * @generated
    */
    private String courseId;
    
    /**
    * @generated
    */
    private String courseName;
    
    /**
    * @generated
    */
    private int numberOfCredits;
    
    /**
    * @generated
    */
    private DisciplineType disciplineType;
    
    /**
    * @generated
    */
    private String specialtyId;
    
    /**
    * @generated
    */
    private Teacher lessonTaughtProfessor;
    
    
    /**
    * @generated
    */
    private Teacher teacher;
    
    /**
    * @generated
    */
    private Specialty specialty;
    
    /**
    * @generated
    */
    private Lesson lesson;
    
    /**
    * @generated
    */
    private Set<Teacher> teacher;
    
    

    /**
    * @generated
    */
    private String getCourseId() {
        return this.courseId;
    }
    
    /**
    * @generated
    */
    private String setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    
    /**
    * @generated
    */
    private String getCourseName() {
        return this.courseName;
    }
    
    /**
    * @generated
    */
    private String setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    
    /**
    * @generated
    */
    private int getNumberOfCredits() {
        return this.numberOfCredits;
    }
    
    /**
    * @generated
    */
    private int setNumberOfCredits(Integer numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    
    
    /**
    * @generated
    */
    private DisciplineType getDisciplineType() {
        return this.disciplineType;
    }
    
    /**
    * @generated
    */
    private DisciplineType setDisciplineType(DisciplineType disciplineType) {
        this.disciplineType = disciplineType;
    }
    
    
    /**
    * @generated
    */
    private String getSpecialtyId() {
        return this.specialtyId;
    }
    
    /**
    * @generated
    */
    private String setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
    
    
    /**
    * @generated
    */
    private Teacher getLessonTaughtProfessor() {
        return this.lessonTaughtProfessor;
    }
    
    /**
    * @generated
    */
    private Teacher setLessonTaughtProfessor(Teacher lessonTaughtProfessor) {
        this.lessonTaughtProfessor = lessonTaughtProfessor;
    }
    
    
    
    /**
    * @generated
    */
    public Set<Teacher> getTeacher() {
        if (this.teacher == null) {
            this.teacher = new HashSet<Teacher>();
        }
        return this.teacher;
    }
    
    /**
    * @generated
    */
    public Set<Teacher> setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
    public Teacher setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
    /**
    * @generated
    */
    public Lesson getLesson() {
        return this.lesson;
    }
    
    /**
    * @generated
    */
    public Lesson setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    
    /**
    * @generated
    */
    public Specialty getSpecialty() {
        return this.specialty;
    }
    
    /**
    * @generated
    */
    public Specialty setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    
    
    
}
