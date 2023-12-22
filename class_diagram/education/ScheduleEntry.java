package education;

import enums.WeekDays;

public class ScheduleEntry {
    private Lesson lesson;
    private WeekDays dayOfWeek;
    private String classroom;
    private String time;

    public ScheduleEntry(Lesson lesson, WeekDays dayOfWeek, String classroom, String time) {
        this.lesson = lesson;
        this.dayOfWeek = dayOfWeek;
        this.classroom = classroom;
        this.time = time;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public WeekDays getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(WeekDays dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
