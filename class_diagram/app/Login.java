package app;
import common.*;
import enums.Language;
import users.User;

public class Login {
	public  Language language = Language.ENGLISH;//пока что
	private String username;
	private String inputp;
	private String testl;
	private String testp;
	private User type;
	private Menu m;
	public Login(){
    	
    }
	public void menu() {
		login();
    	password();
    	System.out.println("Correct");
	}
    public void login() {
    	while(true) {
    		System.out.println("Enter your email: ");
            username=commonBuffer.readInput();
            if(!Data.getInstance().getUsers().containsKey(username)) {
            	 System.out.println("Incorrect input");
            }
            else {

            	break;
            }
    	}
    }
    User user = Data.getInstance().getUsers().get(username);
    public void password() {
    	System.out.println("Enter your password: ");
        inputp=commonBuffer.readInput();
        if (inputp!=user.getPassword()) {
        	System.out.println("Incorrect input");
        	password();
        }
    }

    
    
}
//
