package education;

import enums.DisciplineType;

public class FreeCourse extends Course {
    public FreeCourse(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        super(courseId, courseName, numberOfCredits, disciplineType, specialtyId);
    }

	@Override
	public void addDropDiscipline() {
		// TODO Auto-generated method stub
		
	}

}
