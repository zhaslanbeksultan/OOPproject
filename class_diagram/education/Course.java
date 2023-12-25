package education;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import common.Data;
import enums.DisciplineType;
import users.Student;
import users.Teacher;

public class Course implements  Serializable {

    
	private static final long serialVersionUID = 1L;
	private String courseId;
    private String courseName;
    private int numberOfCredits;
    private DisciplineType specialtyId;
    private Teacher teacher;
    private Specialty specialty;
    private ArrayList<Lesson> lessons;
	private Vector<Student> students; 

    public Course(String courseId, String courseName, int numberOfCredits,
            DisciplineType disciplineType, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;

        this.specialtyId = disciplineType;
        this.teacher = teacher;
        this.lessons = new ArrayList<>(32); 
    }
    public Course() {
    	
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId=courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName=courseName;
    }
    public int getNumberOfCredits() {
        return numberOfCredits;
    }
    public void setNumberOfCredits(int noc) {
         this.numberOfCredits=noc;
    }

    public DisciplineType getSpecialtyId() {
        return specialtyId;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher=teacher;
        teacher.addCourse(this);
        
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    public void addStudent(Student student) {
    	students.add(student);
    }
    public void deleteStudent(Student student) {
    	students.remove(student);
    }
    public Vector<Student> getStudents(){
    	return students;
    }
//    public boolean addDiscipline(Course discipline) {
//        int totalECTS = 0;
//        int disciplineECTS = discipline.getNumberOfCredits();
//
//        if (totalECTS + disciplineECTS > 30) {
//            System.out.println("Adding discipline " + discipline + " to your schedule has failed. Exceeds maximum credits.");
//            return false;
//        }
//
//        switch (disciplineType) {
//            case MAJOR:
//                totalECTS += disciplineECTS;
//                registeredDisciplines.add(discipline);
//                System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
//                return true;
//            case MINOR:
//                if (hasMinorDisciplineInSchedule(discipline)) {
//                    System.out.println(
//                            "Adding discipline " + discipline + " to your schedule has failed. You can have only one minor discipline in your schedule.");
//                    return false;
//                } else {
//                    totalECTS += disciplineECTS;
//                    registeredDisciplines.add(discipline);
//                    System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
//                    return true;
//                }
//            case FREE:
//                totalECTS += disciplineECTS;
//                registeredDisciplines.add(discipline);
//                System.out.println("Discipline " + discipline + " added successfully. Congratulations!");
//                return true;
//            default:
//                System.out.println(
//                        "Adding discipline " + discipline + " to your schedule has failed. Unsupported discipline type, please check the instructions again!");
//                return false;
//        }
//    }

//    public boolean dropDiscipline(Course discipline) {
//        if (disciplineType != DisciplineType.MAJOR) {
//            System.out.println("Discipline " + discipline + " dropped successfully.");
//           return true;
//       } else {
//            System.out.println("Dropping major discipline " + discipline + " is not allowed.");
//            return false;
//       }
//    	return true;
//    }


	
}
