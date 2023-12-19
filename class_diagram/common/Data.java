package common;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import users.*;
import communication.*;
import userCapabilities.*;
import education.*;

public class Data implements Serializable {

	private Vector<Student> students = new Vector<>();
	private Vector<GraduateStudent> graduateStudents = new Vector<>();
    private Vector<Teacher> teachers = new Vector<>();
    private Vector<Employee> employee = new Vector<>();
    private Vector<Admin> admins = new Vector<>();
    private Vector<Researcher> researchers = new Vector<>();
    
    private Vector<Course> courses = new Vector<>();
    private Vector<Lesson> lessons = new Vector<>();
    private Vector<Specialty> specialities = new Vector<>();
    private Vector<Message> messages = new Vector<>();
    private Vector<News> news = new Vector<>();
    private static Data DATA;

    
    private Vector<Book> books = new Vector<>();
    private Vector<Request> requests = new Vector<>();
    private Vector<Order> orders = new Vector<>();
    private HashMap<String, String> logs;

    
    
    static {
		if(new File("data.txt").exists()) {
			try {
				DATA = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else DATA = new Data();
	}
    
    private Data() {
    }
    
    public static Data read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data.txt");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (Data) oin.readObject();
	}
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DATA);
		oos.close();
	}
    
    
    public static Data getInstance() {
    	return DATA;
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

	public void setNews(News post) {
		news.add(post);
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

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	public Vector<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public Vector<Order> getOrders() {
		return orders;
	}

	public void setOrders(Order order) {
		this.orders.add(order);
	}

	public Vector<Request> getRequests() {
		return requests;
	}

	public void addRequest(Request request) {
		this.requests.add(request);
	}
	public HashMap getLogs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}