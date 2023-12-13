package education;

import java.util.HashSet;
import java.util.Set;

import enums.DisciplineType;
import userCapabilities.Administrationable;
import users.Teacher;

public abstract class Course implements Administrationable {

    private String courseId;
    private String courseName;
    private int numberOfCredits;
    private DisciplineType disciplineType;
    private String specialtyId;
    private Set<Teacher> teachers;
    private Teacher lessonTaughtProfessor;
    private Lesson lesson;
    private Specialty specialty;

    public Course(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
        this.disciplineType = disciplineType;
        this.specialtyId = specialtyId;
        this.teachers = new HashSet<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public DisciplineType getDisciplineType() {
        return this.disciplineType; 
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public Teacher getLessonTaughtProfessor() {
        return lessonTaughtProfessor;
    }

    public void setLessonTaughtProfessor(Teacher lessonTaughtProfessor) {
        this.lessonTaughtProfessor = lessonTaughtProfessor;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean disciplineRegistration(String discipline, boolean isRegistrationAllowed) {
        if (isRegistrationAllowed) {
            System.out.println("Congratulations! You have successfully registered for discipline " + discipline + "!");
            return true;
        } else {
            System.out.println("Registration for discipline " + discipline + " is not allowed due to existing retakes for prerequisites of this discipline!");
            return false;
        }
    }

    @Override
    public boolean addDiscipline(String discipline) {
        if (numberOfCredits + Lesson.getDisciplineCredits(discipline) > 30) {
            System.out.println("Adding discipline " + discipline + " to your schedule has failed. Exceeds maximum credits.");
            return false;
        }

        switch (disciplineType) {
            case MAJOR:
                System.out.println("Adding major discipline " + discipline + " to your schedule is not allowed.");
                return false;
            case MINOR:
                if (hasMinorDisciplineInSchedule()) {
                    System.out.println("Adding discipline " + discipline + " to your schedule has failed. You can have only one minor discipline in your schedule.");
                    return false;
                }
                break;
            case FREE:
                // For FREE, just add the discipline
                break;
            default:
                System.out.println("Adding discipline " + discipline + " to your schedule has failed. Unsupported discipline type, please check the instructions again!");
                return false;
        }

        System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
        return true;
    }

    @Override
    public boolean dropDiscipline(String discipline) {
        if (disciplineType != DisciplineType.MAJOR) {
            System.out.println("Discipline " + discipline + " dropped successfully.");
            return true;
        } else {
            System.out.println("Dropping major discipline " + discipline + " is not allowed.");
            return false;
        }
    }

    private boolean checkMajorDisciplineCompatibility(String discipline) {
        return disciplineType == DisciplineType.MAJOR && Lesson.checkMajorDisciplineCompatibility(discipline);
    }

    private boolean hasMinorDisciplineInSchedule() {
        // Logic to check for the presence of a minor discipline in the schedule
        return disciplineType == DisciplineType.MINOR; // Example logic; implement according to your data structure
    }

    @Override
    public boolean disciplineRegistration(String discipline) {
        System.out.println("Discipline " + discipline + " registration logic goes here.");
        return true;
    }
}
