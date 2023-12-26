package userCapabilities;

import education.Lesson;
import education.Mark;
import enums.WeekDays;
import users.Teacher;

import java.util.HashMap;
import java.util.Vector;

/**
 * The Educationable interface declares methods related to educational activities that a user can perform.
 * Implementing classes are expected to provide concrete implementations for these methods.
 */
public interface Educationable {

    /**
     * View the attestation details.
     */
    void viewAttestation();

    /**
     * View the lesson schedule.
     */
    void viewLessonSchedule();

    /**
     * View the office hour schedule.
     */
    void viewOfficeHourSchedule();

    /**
     * View the exams schedule.
     */
    void viewExamsSchedule();

    /**
     * View the journal containing academic information.
     */
    void viewJournal();

    /**
     * Mark attendance for a lesson.
     */
    void attendanceMark();

    /**
     * View the schedule for a specific discipline.
     */
    void viewDisciplineSchedule();
}
