package app;
import common.commonBuffer;

public class Login {
	public String inputl;
	public String inputp;
	public String testl;
	public String testp;
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
    	m = new Menu();
	}
    public void login() {
    	while(true) {
    		System.out.println("Enter your email: ");
            inputl=cb.readInput();
            if (!inputl.equals(testl)) {
                System.out.println("Incorrect input");
            }
            else {
            	break;
            }
    	}
    }
    public void password() {
    	System.out.println("Enter your password: ");
        inputp=cb.readInput();
        if (!inputp.equals(testp)) {
        	System.out.println("Incorrect input");
        	password();
        }
    }

    
    
}
