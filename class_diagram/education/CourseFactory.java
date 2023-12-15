package education;

import enums.DisciplineType;

public class CourseFactory {

    public static Course createCourse(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        switch (disciplineType) {
            case MAJOR:
                return new MajorCourse(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
            case MINOR:
                return new MinorCourse(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
            case FREE:
                return new FreeCourse(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
            default:
                throw new IllegalArgumentException("Unsupported discipline type: " + disciplineType);
        }
    }
    
}
