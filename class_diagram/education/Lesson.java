import users.Teacher;

package education;


/**
* @generated
*/
public class Lesson {
    
    /**
    * @generated
    */
    private int lessonId;
    
    /**
    * @generated
    */
    private Teacher instructor;
    
    /**
    * @generated
    */
    private LessonType lessonType;
    
    /**
    * @generated
    */
    private Data lessonTime;
    
    /**
    * @generated
    */
    private WeekDays weekDay;
    
    /**
    * @generated
    */
    private String room;
    
    
    /**
    * @generated
    */
    private Course course;
    
    /**
    * @generated
    */
    private Mark mark;
    
    

    /**
    * @generated
    */
    private int getLessonId() {
        return this.lessonId;
    }
    
    /**
    * @generated
    */
    private int setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }
    
    
    /**
    * @generated
    */
    private Teacher getInstructor() {
        return this.instructor;
    }
    
    /**
    * @generated
    */
    private Teacher setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }
    
    
    /**
    * @generated
    */
    private LessonType getLessonType() {
        return this.lessonType;
    }
    
    /**
    * @generated
    */
    private LessonType setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
    
    
    /**
    * @generated
    */
    public Data getLessonTime() {
        return this.lessonTime;
    }
    
    /**
    * @generated
    */
    public Data setLessonTime(Data lessonTime) {
        this.lessonTime = lessonTime;
    }
    
    
    /**
    * @generated
    */
    public WeekDays getWeekDay() {
        return this.weekDay;
    }
    
    /**
    * @generated
    */
    public WeekDays setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
    
    
    /**
    * @generated
    */
    public String getRoom() {
        return this.room;
    }
    
    /**
    * @generated
    */
    public String setRoom(String room) {
        this.room = room;
    }
    
    
    
    /**
    * @generated
    */
    public Mark getMark() {
        return this.mark;
    }
    
    /**
    * @generated
    */
    public Mark setMark(Mark mark) {
        this.mark = mark;
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
    
    
    
}
