import Vector;

package users;


/**
* @generated
*/
public class Manager extends Employee implements NewsPostable, Managable, Administrationable {
    
    /**
    * @generated
    */
    private ManagerPosition managerPosition;
    
    /**
    * @generated
    */
    private Vector coursesRegisterTo;
    
    /**
    * @generated
    */
    private  attribute;
    
    /**
    * @generated
    */
    private Vector requests;
    
    
    

    /**
    * @generated
    */
    private ManagerPosition getManagerPosition() {
        return this.managerPosition;
    }
    
    /**
    * @generated
    */
    private ManagerPosition setManagerPosition(ManagerPosition managerPosition) {
        this.managerPosition = managerPosition;
    }
    
    
    /**
    * @generated
    */
    private Vector getCoursesRegisterTo() {
        return this.coursesRegisterTo;
    }
    
    /**
    * @generated
    */
    private Vector setCoursesRegisterTo(Vector coursesRegisterTo) {
        this.coursesRegisterTo = coursesRegisterTo;
    }
    
    
    /**
    * @generated
    */
    public  getAttribute() {
        return this.attribute;
    }
    
    /**
    * @generated
    */
    public  setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
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
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Vector getManagerDuties() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean isCapableToPostNews() {
        //TODO
        return false;
    }
    
    
}
