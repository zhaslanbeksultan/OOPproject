package education;

import enums.DisciplineType;

public class MajorCourse extends Course {
    public MajorCourse(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        super(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
    }
}
