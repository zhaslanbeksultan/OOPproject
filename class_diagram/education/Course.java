package education;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.Data;
import enums.DisciplineType;
import userCapabilities.Administrationable;
import users.Teacher;

public abstract class Course implements Administrationable {

    private Set<Courses> registeredDisciplines = new HashSet<>();
    private String courseId;
    private String courseName;
    private int numberOfCredits;
    protected DisciplineType disciplineType;
    private String specialtyId;
    private Set<Teacher> teachers;
    private Lesson lesson;
    private Specialty specialty;
    private List<Lesson> lessons; 

    public Course(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType,
            String specialtyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
       this.disciplineType = disciplineType;
        this.specialtyId = specialtyId;
        this.teachers = new HashSet<>();
        this.lessons = new ArrayList<>(); 
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
        return Course.disciplineType;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public List<Teacher> getTeachersForCourse() {
        List<Teacher> teachersForCourse = new ArrayList<>();
        for (Lesson lesson : lessons) {
            Teacher instructor = lesson.getInstructor();
            if (instructor != null && Data.getInstance().getTeachers().contains(instructor) && !teachersForCourse.contains(instructor)) {
                teachersForCourse.add(instructor);
            }
        }
        return teachersForCourse;
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

    public boolean addDiscipline(Courses discipline) {
        int totalECTS = 0;
        int disciplineECTS = discipline.getDisciplineCredits();

        if (totalECTS + disciplineECTS > 30) {
            System.out.println("Adding discipline " + discipline + " to your schedule has failed. Exceeds maximum credits.");
            return false;
        }

        switch (disciplineType) {
            case MAJOR:
                totalECTS += disciplineECTS;
                registeredDisciplines.add(discipline);
                System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                return true;
            case MINOR:
                if (hasMinorDisciplineInSchedule(discipline)) {
                    System.out.println(
                            "Adding discipline " + discipline + " to your schedule has failed. You can have only one minor discipline in your schedule.");
                    return false;
                } else {
                    totalECTS += disciplineECTS;
                    registeredDisciplines.add(discipline);
                    System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                    return true;
                }
            case FREE:
                totalECTS += disciplineECTS;
                registeredDisciplines.add(discipline);
                System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
                return true;
            default:
                System.out.println(
                        "Adding discipline " + discipline + " to your schedule has failed. Unsupported discipline type, please check the instructions again!");
                return false;
        }
    }

    public boolean dropDiscipline(Courses discipline) {
        if (disciplineType != DisciplineType.MAJOR) {
            System.out.println("Discipline " + discipline + " dropped successfully.");
            return true;
        } else {
            System.out.println("Dropping major discipline " + discipline + " is not allowed.");
            return false;
        }
    }

    private boolean hasMinorDisciplineInSchedule(Courses discipline) {
        return disciplineType == DisciplineType.MINOR;
    }
}
