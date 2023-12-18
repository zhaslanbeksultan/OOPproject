package education;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import enums.DisciplineType;
import userCapabilities.Administrationable;
import enums.Faculty;
import users.Teacher;
import enums.Language;

public abstract class Course implements Administrationable {

	private HashSet<Courses> registeredDisciplines = new HashSet<>();

    private String courseId;
    private String courseName;
    private int numberOfCredits;
    protected static DisciplineType disciplineType;
    private String specialtyId;
    private Set<Teacher> teachers;
    private Teacher lessonTaughtProfessor;
    private Lesson lesson;
    private Specialty specialty;

    //constructor 
    public Course(String courseId, String courseName, int numberOfCredits, DisciplineType disciplineType, String specialtyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
        Course.disciplineType = disciplineType;
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
        return Course.disciplineType; 
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



  /*@Override
   public boolean disciplineRegistration(Courses discipline) {
        if ( courseList.contains(discipline)) {
            System.out.println("Congratulations! You have successfully registered for discipline " + discipline + "!");
            registeredDisciplines.add(discipline); 
            return true;
        } else {
            System.out.println("Registration for discipline " + discipline + " is not allowed or not in the courses list!");
            return false;
        }
    }*/

    
    
    public boolean addDiscipline(Courses discipline) {
    	int totalECTS = 0;
        int disciplineECTS = Courses.getDisciplineCredits(discipline);

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
                        System.out.println("Adding discipline " + discipline + " to your schedule has failed. You can have only one minor discipline in your schedule.");
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
                    System.out.println("Adding discipline " + discipline + " to your schedule has failed. Unsupported discipline type, please check the instructions again!");
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

    private static boolean checkMajorDisciplineCompatibility(Courses discipline) {
        return disciplineType == DisciplineType.MAJOR && Course.checkMajorDisciplineCompatibility(discipline);
    }

    private boolean hasMinorDisciplineInSchedule(Courses discipline) {
        return disciplineType == DisciplineType.MINOR; 
    }
}
