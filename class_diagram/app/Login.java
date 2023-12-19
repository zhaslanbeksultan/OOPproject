package app;
import common.*;
import enums.Language;
import users.*;

public class Login {
	public  Language language = Language.ENGLISH;//пока что
	private String username;
	private String password;
	public Login(){
    	
    }
	public void menu() {
		login();
    	password();
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
    
    public void password() {
    	User user = Data.getInstance().getUsers().get(username);
    	while(true) {
    		System.out.println("Enter your password: ");
    		password=commonBuffer.readInput();
    		if (!password.equals(user.getPassword())) {
    			System.out.println("Incorrect input");
    		}
    		else {
    			break;
    		}
    	}
    	user.showMenu();
    }

    
    
}
//
