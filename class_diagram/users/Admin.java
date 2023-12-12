package users;
import common.Data;
public class Admin {
    Data d= Data.getInstance();
    public void createStudent() {
    	Student beks= new Student();
    	d.addStudent(beks);
    }
    
                               
    
    
}
