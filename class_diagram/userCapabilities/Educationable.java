package userCapabilities;

import java.util.HashMap;
import java.util.Vector;

import education.Lesson;
import education.Mark;
import enums.WeekDays;
import users.Teacher;

public interface Educationable {

    void viewAttestation();

    void viewLessonSchedule();

    void viewOfficeHourSchedule();
    
    void viewExamsSchedule();
    
    void viewJournal();
    
    void attendanceMark();
    
    void viewDisciplineSchedule();

}
