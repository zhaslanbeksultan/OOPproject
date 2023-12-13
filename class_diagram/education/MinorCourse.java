package education;

import enums.DisciplineType;

public class MinorCourse extends Course {
    public MinorCourse(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        super(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
    }
}