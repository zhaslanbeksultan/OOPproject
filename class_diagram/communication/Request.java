package communication;

import java.util.HashMap;
import java.util.Vector;
import users.Employee;
import users.Student;
import users.User;

public class Request {

    private Vector<String> requests; 
    
    private User user;

    public Vector<String> getRequests() {
        return this.requests;
    }
    
    public void setRequests(Vector<String> requests) {
        this.requests = requests;
    }
    

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public HashMap<Student, String> getStudentRequests() {
        return null;
    }
    
    public HashMap<Employee, String> getEmployeeRequests() {
        return null;
    }
    
    public boolean processRequest() {
        return false;
    }
}
