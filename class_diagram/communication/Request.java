import Vector;
import users.Employee;
import users.Student;

package communication;

public class Request {

    private Vector requests;
    
    private User user;

    public Vector getRequests() {
        return this.requests;
    }
    
    public Vector setRequests(Vector requests) {
        this.requests = requests;
    }
    

    public User getUser() {
        return this.user;
    }
    
  
    public User setUser(User user) {
        this.user = user;
    }
    
    

    public HashMap<Student,String> getRequest() {
       
        return null;
    }
    
    public HashMap<Employee,String> getRequest() {
        
        return null;
    }
    
  
    public boolean processRequest() {
        
        return false;
    }
    
    
}
