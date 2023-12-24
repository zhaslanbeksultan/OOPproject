package education;

import enums.WeekDays;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.util.Map;

import enums.DisciplineType;

public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    private int lessonId;
    private String lessonName;
    private Teacher instructor;
    private WeekDays lessonTime;
    private String room;
    private Course course;
    private Map<Student, Mark> marks;

    public Lesson(int lessonId, String lessonName, Teacher instructor, DisciplineType lessonType, WeekDays lessonTime,
                  String room, Course course) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.instructor = instructor;
        this.lessonTime = lessonTime;
        this.room = room;
        this.course = course;
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

    public Map<Student, Mark> getMarks() {
        return marks;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public void registerStudent(Student student, int mark) {
        if (mark >= 0 && mark <= 100) {
            Mark studentMark = new Mark();
            WeekDays lessonTime = getLessonTime();
            studentMark.addLessonMark(this, mark, lessonTime);
            student.addMark(this, studentMark);
        } else {
            throw new IllegalArgumentException("Invalid mark: " + mark);
        }
    }

    public Teacher getInstructor() {
        return instructor;
    }

    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }
}
