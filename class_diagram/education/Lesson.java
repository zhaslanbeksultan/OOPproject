package education;

import enums.WeekDays;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import enums.DisciplineType;
import enums.LessonType;

public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    private int lessonId;
    private LessonType lessonType;
    private String lessonName;
    private Teacher instructor;
    private WeekDays lessonTime;
    private String room;
    private Course course;
    private Map<Student, Integer> marks;
    {
    	marks=new HashMap<>();
    }
    public Lesson(int lessonId, String lessonName, Teacher instructor, DisciplineType lessonType, WeekDays lessonTime,
                  String room, Course course) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.instructor = instructor;
        this.lessonTime = lessonTime;
        this.room = room;
        this.course = course;
    }
    public Lesson(LessonType lessonType, Course course, int index) {
    	this.lessonType=lessonType;
    	this.course=course;
    	for(Student student: course.getStudents()) {
    		marks.put(student, 0);
    	}
    	this.lessonId=index/2 +1;
    	this.instructor=course.getTeacher();
    }
    
    public int getLessonId() {
        return lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public WeekDays getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(WeekDays lessonTime) {
        this.lessonTime = lessonTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Course getCourse() {
        return course;
    }

    public Map<Student, Integer> getMarks() {
        return marks;
    }
    public void viewMarks() {
    	System.out.println("Week "+this.lessonId+" "+this.lessonType);
    	for (Map.Entry<Student, Integer> entry : marks.entrySet()) {
            Student student = entry.getKey();
            Integer mark = entry.getValue();
            System.out.println(student.getFirstName()+" "+student.getId()+" "+mark);
        }
    }
    public void putMarks(Student student, Integer mark) {
    	this.marks.put(student, mark);
    }

    

    public Teacher getInstructor() {
        return instructor;
    }

    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }
}
