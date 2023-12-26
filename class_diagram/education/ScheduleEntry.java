package education;

import enums.WeekDays;
import users.Teacher;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ScheduleEntry implements Serializable{
	private static final long serialVersionUID = 1L;
	private Lesson lesson;
    private WeekDays dayOfWeek;
    private String classroom;
    private String time;
    private Teacher teacher;

    public ScheduleEntry(Lesson lesson, WeekDays dayOfWeek, String classroom, String time, Teacher teacher) {
        this.lesson = lesson;
        this.dayOfWeek = dayOfWeek;
        this.classroom = classroom;
        this.time = time;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

public class Schedule {
    private Map<WeekDays, Map<String, ScheduleEntry>> weeklySchedule;

    public Schedule() {
        this.weeklySchedule = new HashMap<>();
        for (WeekDays day : WeekDays.values()) {
            weeklySchedule.put(day, new HashMap<>());
        }
    }

    public void addScheduleEntry(Lesson lesson, WeekDays dayOfWeek, String classroom, String time, Teacher teacher) {
        ScheduleEntry scheduleEntry = new ScheduleEntry(lesson, dayOfWeek, classroom, time, teacher);
        weeklySchedule.get(dayOfWeek).put(time, scheduleEntry);
    }

    public void displayScheduleTable() {
        System.out.println("---- WEEKLY SCHEDULE ----");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n", "Day", "Time", "Lesson", "Teacher", "Classroom");

        for (WeekDays day : WeekDays.values()) {
            Map<String, ScheduleEntry> daySchedule = weeklySchedule.get(day);

            for (Map.Entry<String, ScheduleEntry> entry : daySchedule.entrySet()) {
                ScheduleEntry scheduleEntry = entry.getValue();
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                        day.toString(), scheduleEntry.getTime(), scheduleEntry.getLesson().getLessonName(),
                        scheduleEntry.getTeacher().getFirstName(),  scheduleEntry.getClassroom());
            }
        }
    }
}
