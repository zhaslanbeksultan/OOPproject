package users;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import common.Data;
import education.*;
import enums.*;
import userCapabilities.*;

public class Teacher extends Employee implements Managable,CanBorrowBook {

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
	public void borrowBook(String bookName) {
		if(Book.isBookAvailable(bookName)) {
			for(Book book: Data.getInstance().getBooks()) {
				if(book.getBookName().equals(bookName)) {
					book.setBorrowed(true);
					book.setReader(this);
				}
			}
		}
	}


	@Override
	public void returnBook(String bookName) {
		for(Book book: Data.getInstance().getBooks()) {
			if(book.getReader().getUsername().equals(this.getUsername()) && book.getBookName().equals(bookName)) {
				book.setBorrowed(false);
				book.setReader(null);
			}
		}
	}
}

