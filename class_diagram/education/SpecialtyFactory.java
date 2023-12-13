package education;

import enums.Faculty;

public class SpecialtyFactory {

    public static Specialty createSpecialty(String specialtyId, String specialtyName, Faculty faculty) {
        validateInputParameters(specialtyId, specialtyName, faculty);

        Specialty specialty = new Specialty(specialtyId, specialtyName, faculty);

       
        if (specialty.getMajorCourses().isEmpty() && specialty.getMinorCourses().isEmpty() && specialty.getFreeCourses().isEmpty()) {
            throw new IllegalArgumentException("At least one type of course (major, minor, or free) must be added to the specialty.");
        }

        return specialty;
    }

    private static void validateInputParameters(String specialtyId, String specialtyName, Faculty faculty) {
        if (specialtyId == null || specialtyId.isEmpty()) {
            throw new IllegalArgumentException("Please enter the ID of specialty. This field cannot be empty, otherwise your specialty does not exist! ");
        }

        if (specialtyName == null || specialtyName.isEmpty()) {
            throw new IllegalArgumentException("Please enter the name of specialty. This field cannot be empty, otherwise your specialty does not exist! ");
        }

        if (faculty == null) {
            throw new IllegalArgumentException("Please enter the faculty of specialty. This field cannot be empty, otherwise your specialty does not exist!");
        }
    }
}
