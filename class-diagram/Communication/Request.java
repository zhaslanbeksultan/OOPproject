import users.Employee;
import users.Student;

package class-diagram;


/**
* @generated
*/
public class Request {
    
    /**
    * @generated
    */
    private Vector requests;
    
    
    /**
    * @generated
    */
    private User user;
    
    

    /**
    * @generated
    */
    public Vector getRequests() {
        return this.requests;
    }
    
    /**
    * @generated
    */
    public Vector setRequests(Vector requests) {
        this.requests = requests;
    }
    
    
    
    /**
    * @generated
    */
    public User getUser() {
        return this.user;
    }
    
    /**
    * @generated
    */
    public User setUser(User user) {
        this.user = user;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public HashMap<Student,String> getRequest() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public HashMap<Employee,String> getRequest() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean processRequest() {
        //TODO
        return false;
    }
    
    
}
