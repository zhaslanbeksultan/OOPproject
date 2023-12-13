package app;
import common.*;

public class Login {
	public String inputl;
	public String inputp;
	public String testl;
	public String testp;
	public int type;
	public commonBuffer cb= new commonBuffer();
	public Menu m;
	{
		testl="arsen_zhex";
		testp="abcde";
	}
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
            inputl=cb.readInput();
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
            }
    	}
    }
    public void password() {
    	System.out.println("Enter your password: ");
        inputp=cb.readInput();
        if (!Data.getInstance().getLogs().get(inputl).equals(inputp)) {
        	System.out.println("Incorrect input");
        	password();
        }
    }

    
    
}
//
