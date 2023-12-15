package education;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import enums.WeekDays;
import userCapabilities.Educationable;
import education.Course;
import education.Mark;
import users.Teacher;
import enums.DisciplineType;

public class Lesson implements Educationable {

    private int lessonId;
    private Teacher instructor;
    private DisciplineType lessonType;
    private WeekDays lessonTime;
    private String room;
    private Course course;
    private Mark mark;

    public Lesson(int lessonId, Teacher instructor, DisciplineType lessonType, WeekDays lessonTime,
            String room, Course course) {
        this.lessonId = lessonId;
        this.instructor = instructor;
        this.lessonType = lessonType;
        this.lessonTime = lessonTime;
        this.room = room;
        this.course = course;
    }

    public int getLessonId() {
        return lessonId;
    }

    public Teacher getInstructor() {
        return instructor;
    }

    public DisciplineType getLessonType() {
        return lessonType;
    }

    public WeekDays getLessonTime() {
        return lessonTime;
    }

    public String getRoom() {
        return room;
    }

    public Course getCourse() {
        return course;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public HashMap<Lesson, Integer> viewAttestation() {
        return new HashMap<>();
    }

    @Override
    public Vector<String> viewDownloadedFiles() {
        return new Vector<>();
    }

    @Override
    public HashMap<Lesson, WeekDays> viewLessonSchedule() {
        return new HashMap<>();
    }

    @Override
    public HashMap<Teacher, WeekDays> viewOfficeHourSchedule() {
        return new HashMap<>();
    }

    @Override
    public HashMap<String, Vector<Mark>> viewMarks() {
        return new HashMap<>();
    }

    @Override
    public String getReport() {
        return "";
    }

	public static int getDisciplineCredits1(Courses discipline) {
		return 0;
	}

	public static boolean checkMajorDisciplineCompatibility(String discipline) {
		return false;
	}


	public static int getDisciplineCredits(Courses discipline) {
		// TODO Auto-generated method stub
		return 0;
	}
}

