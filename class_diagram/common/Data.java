package common;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import users.*;
import communication.*;
import userCapabilities.*;
import education.*;

public class Data {

    private Vector<Student> students;
    private Vector<Teacher> teachers;
    private Vector<News> news;
    private Vector<Researcher> researchers;
    private Vector<Course> courses;
    private Vector<Lesson> lessons;
    private Vector<Specialty> specialities;
    private Vector<Message> messages;
    private Map<String, String> logs;
    
    private static final Data DATA = new Data();
    
    private Data() {
        students = new Vector<>();
        teachers = new Vector<>();
        news = new Vector<>();
        researchers = new Vector<>();
        courses = new Vector<>();
        lessons = new Vector<>();
        specialities = new Vector<>();
        messages = new Vector<>();
        logs= new HashMap();
    }

    public static Data getInstance() {
    	return DATA;
    }
    public void setLogs(String login, String password) {
    	logs.put(login, password);
    }
    public Map getLogs() {
    	return logs;
    }
    public Vector<Message> getMessages() {
		return messages;
	}

	public void addMessage(Message message) {
		messages.add(message);	
	}

	public Vector<Student> getStudents() {
		return students;
	}

	public void setStudents(Vector<Student> students) {
		this.students = students;
	}

	public Vector<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Vector<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Vector<News> getNews() {
		return news;
	}

	public void setNews(Vector<News> news) {
		this.news = news;
	}

	public Vector<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(Vector<Researcher> researchers) {
		this.researchers = researchers;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public Vector<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Vector<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Vector<Specialty> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Vector<Specialty> specialities) {
		this.specialities = specialities;
	}
	public void addStudent(Student s) {
		students.add(s);
	}
	
}