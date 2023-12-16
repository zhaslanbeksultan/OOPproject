/*import Vector;
import education.Course;

package users;


public class Teacher extends TechSupportSpecialistUserEmployee implements CanBorrowBook, Managable {
    
    private String EducationDegree;
    
   
    private Vector ResearchInterests;
    
    
  
    private GraduateStudent graduateStudent;

    private GraduateStudent graduateStudent;
    
    private Course course;
    
   
    private Set<Course> course;
    
    

    public Teacher(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String string, String string2) {
		// TODO Auto-generated constructor stub

    private String getEducationDegree() {
        return this.EducationDegree;
    }
    
  
    private String setEducationDegree(String EducationDegree) {
        this.EducationDegree = EducationDegree;
    }
    
    
  
    private Vector getResearchInterests() {
        return this.ResearchInterests;
    }
 
    private Vector setResearchInterests(Vector ResearchInterests) {
        this.ResearchInterests = ResearchInterests;
    }
    
    
  
    public GraduateStudent getGraduateStudent() {
        return this.graduateStudent;
    }
    
   
    public GraduateStudent setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }
    
    
  
    public GraduateStudent getGraduateStudent() {
        return this.graduateStudent;
    }
    
  
    public GraduateStudent setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }
    
    
    
    public Course getCourse() {
        return this.course;
    }
    
    
    public Course setCourse(Course course) {
        this.course = course;
    }
    
  
    public Set<Course> getCourse() {
        if (this.course == null) {
            this.course = new HashSet<Course>();
        }
        return this.course;
    }
  
    public Set<Course> setCourse(Course course) {
        this.course = course;
    }
    
    
    

    //                          Operations                                  
  
    public String sendComplaintToDean() {
        //TODO
        return "";
    }
    
  
    public int enteringGrades() {
        //TODO
        return 0;
    }
    
   
    public boolean officeHoursTeaching() {
        //TODO
        return false;
    }
    
       
    
}

*/

package users;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import education.*;
import enums.*;
import userCapabilities.*;

public class Teacher implements Managable,CanBorrowBook {

    private Set<Course> courses;
    private GraduateStudent graduateStudent;
    private Course course;

    public Teacher(String name, String subject) {
        super();
        this.courses = new HashSet<>();
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public GraduateStudent getGraduateStudent() {
        return graduateStudent;
    }

    public void setGraduateStudent(GraduateStudent graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

	@Override
	public void viewAcademicStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeOfficeHoursSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtainingProgressStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gettingPassingStatistics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewRegisteredSchedule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, HashMap<WeekDays, Teacher>> getLessonSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrowBook() {
		
		
	}

	@Override
	public boolean returnBook() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date getBorrowedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getMustReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}
}

