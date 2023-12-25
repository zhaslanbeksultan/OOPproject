package education;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import common.Data;
import enums.Faculty;
import enums.DisciplineType;

public class Specialty implements Comparable<Specialty>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String specialtyId;
    private String specialtyName;
    private Vector<Course> majorCourses;
    private Vector<Course> minorCourses;
    private Vector<Course> freeCourses;
    private Course course;
    private Faculty faculty;

    public Specialty(String specialtyId, String specialtyName, Faculty faculty) {
        this.specialtyId = specialtyId;
        this.specialtyName = specialtyName;
        this.faculty = faculty;
        this.majorCourses = new Vector<>();
        this.minorCourses = new Vector<>();
        this.freeCourses = new Vector<>();
    }
    public Specialty() {
    	
    }
    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Vector<Course> getMajorCourses() {
        return majorCourses;
    }

    public void setMajorCourses(Vector<Course> majorCourses) {
        this.majorCourses = majorCourses;
    }

    public Vector<Course> getMinorCourses() {
        return minorCourses;
    }

    public void setMinorCourses(Vector<Course> minorCourses) {
        this.minorCourses = minorCourses;
    }

    public Vector<Course> getFreeCourses() {
        return freeCourses;
    }

    public void setFreeCourses(Vector<Course> freeCourses) {
        this.freeCourses = freeCourses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addCourse(Course course, DisciplineType disciplineType) {
        switch (disciplineType) {
            case MAJOR:
                majorCourses.add(course);
                break;
            case MINOR:
                minorCourses.add(course);
                break;
            case FREE:
                freeCourses.add(course);
                break;
            default:
                throw new IllegalArgumentException("Unsupported discipline type");
        }
        
     Data.getInstance().addCourse(course);
    }
    @Override
    public int compareTo(Specialty other) {
        return this.specialtyId.compareTo(other.specialtyId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(specialtyId, specialty.specialtyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyId);
    }
    
}
