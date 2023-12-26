package app;
import java.io.IOException;
import common.*;
import users.Admin;
public class Main {   
	public static void main(String[] args) throws IOException {


//		Admin admin = new Admin();
//		admin.setUsername("steve_jobs");
//		admin.setPassword("pass");
//		Data.getInstance().addAdmin(admin);
//		Data.getInstance().addUser("steve_jobs", admin);

		Login login = new Login();
		while(true) {
			login.menu();
			System.out.println("Enter '0' to close app. '1' - to Login");
			String input = commonBuffer.readInput();
			if(input.equals("0")) break;
		}
		Data.write();
	}
}
