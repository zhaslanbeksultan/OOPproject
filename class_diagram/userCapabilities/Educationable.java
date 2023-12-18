package userCapabilities;

import java.util.HashMap;
import java.util.Vector;

import education.Lesson;
import education.Mark;
import enums.WeekDays;
import users.Teacher;

public interface Educationable {

    HashMap<Lesson, Integer> viewAttestation();

    HashMap<Lesson, WeekDays> viewLessonSchedule();

    HashMap<Teacher, WeekDays> viewOfficeHourSchedule();

    HashMap<String, Vector<Mark>> viewMarks();
    
    void viewExamsSchedule();

    String getReport();
}
