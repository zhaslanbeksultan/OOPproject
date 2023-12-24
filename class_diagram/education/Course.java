package education;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import common.Data;
import enums.DisciplineType;
import userCapabilities.Administrationable;
import users.Teacher;

public class Course implements Administrationable {

    private String courseId;
    private String courseName;
    private int numberOfCredits;
    private String specialtyId;
    private Teacher teacher;
    private Specialty specialty;
    private ArrayList<Lesson> lessons;
	private Vector<Course> registeredDisciplines; 

    public Course(String courseId, String courseName, int numberOfCredits,
            String specialtyId, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;

        this.specialtyId = specialtyId;
        this.teacher = teacher;
        this.lessons = new ArrayList<>(32); 
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


    public String getSpecialtyId() {
        return specialtyId;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher=teacher;
        
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public boolean addDiscipline(Course discipline) {
        int totalECTS = 0;
        int disciplineECTS = discipline.getNumberOfCredits();

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

    public boolean dropDiscipline(Course discipline) {
//        if (disciplineType != DisciplineType.MAJOR) {
//            System.out.println("Discipline " + discipline + " dropped successfully.");
//            return true;
//        } else {
//            System.out.println("Dropping major discipline " + discipline + " is not allowed.");
//            return false;
//        }
    	return true;
    }

	@Override
	public void addDropDiscipline() {
		// TODO Auto-generated method stub
		
	}

	
}
