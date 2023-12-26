package education;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import common.Data;
import common.commonBuffer;
import enums.DisciplineType;
import enums.LessonType;
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
    private Vector<Lesson> lessons;
	private Vector<Student> students; 
	{
		students= new Vector<Student>();
		lessons = new Vector<Lesson>();
		
	}
    public Course(String courseId, String courseName, int numberOfCredits,
            DisciplineType disciplineType, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;

        this.specialtyId = disciplineType;
        this.teacher = teacher;
        this.lessons = new Vector<>(); 
    }
    public Course() {
    	
    }
    public void viewStudentAttestation(Student student) {
    	int att1=0;
		int att2=0;
		int fin=0;
		for(int i=0; i<33;i++) {
			if(i<16) {
				att1+=lessons.get(i).getMarks().get(student);
			}  if(i>=16&&i<32) {
				att2+=lessons.get(i).getMarks().get(student);
			} if (i==32) {
				fin+=lessons.get(i).getMarks().get(student);
			}
		}
		System.out.println(this.getCourseName()+" First Attestation:"+att1+" Second Attestation:"+att2 +" Final:"+fin);
    }
    public void viewAttestation() {
    	for(Student student: students) {
    		int att1=0;
    		int att2=0;
    		int fin=0;
    		for(int i=0; i<33;i++) {
    			if(i<16) {
    				att1+=lessons.get(i).getMarks().get(student);
    			}  if(i>=16&&i<32) {
    				att2+=lessons.get(i).getMarks().get(student);
    			} if (i==32) {
    				fin+=lessons.get(i).getMarks().get(student);
    			}
    		}
    		System.out.println(student.getFirstName()+" First Attestation:"+att1+" Second Attestation:"+att2 +" Final:"+fin);
    	}
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
    }
    public Vector<Lesson> getLessons(){
    	return lessons;
    }
    public void startCourse() {
    	for(int i=0; i<33;i++) {
			LessonType lt;
			if(i%2==0) {
				lt=LessonType.LECTURE;
			}
			else {
				lt=LessonType.PRACTICE;
			}
			if(i==32) {
				lt=LessonType.FINAL;
			}
			Lesson lesson = new Lesson(lt, this, i);
			lessons.add(lesson);
		}
    	System.out.println("You just started "+ this.getCourseName()+" Course!");
    	System.out.println("Press any key to continue:");
    	String fake=commonBuffer.readInput();
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

    public void setTeacher(String teacherID) {
        for(Teacher teacher: Data.getInstance().getTeachers()) {
        	if(teacher.getId().equals(teacherID)) {
        		this.teacher=teacher;
        	}
        }
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
    public void editCourse() {
    	while(true) {
    		System.out.println("Editing "+this.getCourseName()+"\n"+"1.Set Teacher\n2.Add Student\n3.Delete Student\n4.Check enrolled students\n5. Start Course\n0.Exit");
        	String input = commonBuffer.readInput();
        	switch(input){
        		case "1":
        			System.out.println("Enter teacher's ID:");
        			input=commonBuffer.readInput();
        			this.setTeacher(input);
        			break;
        		case "2":
        			System.out.println("Enter student's ID:");
        			input=commonBuffer.readInput();
        			for(Student student: Data.getInstance().getStudents()) {
        				if(student.getId().equals(input)) {
        					
        					student.enterCourse(this);
        				}
        			}
        			break;
        		case "3":
        			System.out.println("Enter student's ID:");
        			input=commonBuffer.readInput();
        			for(Student student: Data.getInstance().getStudents()) {
        				if(student.getId().equals(input)) {
        					this.deleteStudent(student);
        					student.dropCourse(this);
        				}
        			}
        			break;
        		case "4":
        			for(Student student: students) {
        				System.out.println(student.getFirstName()+" "+student.getId()+" "+student.getGpa());
        			}
        			System.out.println("Press any key to continue:");
        			input=commonBuffer.readInput();
        			break;
        		case "5":
        			this.startCourse();
        			break;
        		case "0":
        			return;
        	}
    	}
    }


	
}
