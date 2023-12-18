package app;
import common.*;
import enums.Language;

public class Login {
	public static Language language = Language.ENGLISH;//пока что
	private String inputl;
	private String inputp;
	private String testl;
	private String testp;
	private int type;
	private Menu m;
	public Login(){
    	
    }
	public void menu() {
		login();
    	password();
    	System.out.println("Correct");
    	m = new Menu(type);
	}
    public void login() {
    	while(true) {
    		System.out.println("Enter your email: ");
            inputl=commonBuffer.readInput();
            if(!Data.getInstance().getLogs().containsKey(inputl)) {
            	 System.out.println("Incorrect input");
            }
            else {
            	if(inputl.charAt(0)=='a') {
            		type=0;
            	}
            	else if(inputl.charAt(0)=='s') {
            		type=1;
            	}
            	break;
            }
    	}
    }
    public void password() {
    	System.out.println("Enter your password: ");
        inputp=commonBuffer.readInput();
        if (!Data.getInstance().getLogs().get(inputl).equals(inputp)) {
        	System.out.println("Incorrect input");
        	password();
        }
    }

    
    
}
//
