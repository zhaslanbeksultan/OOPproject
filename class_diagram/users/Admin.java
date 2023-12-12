package users;
import common.*;
public class Admin {
    Data d= Data.getInstance();
    public void createStudent() {
    	Student beks= new Student();
    	System.out.println("Enter login");
    	String logname=commonBuffer.readInput();
    	beks.setUsername(logname);
    	System.out.println("Enter password");
    	String password=commonBuffer.readInput();
    	beks.setPassword(password);
    	d.setLogs(logname, password);
    	d.addStudent(beks);
    	System.out.println("Successfully added!");
    }
    
                               
    
    
}
