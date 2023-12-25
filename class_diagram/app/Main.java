package app;
import java.io.IOException;
import java.util.Date;
import common.*;
import education.Specialty;
import users.*;
import enums.*;
public class Main {   
	public static void main(String[] args) throws IOException {
//		Admin admin = new Admin();
//		admin.setUsername("steve_jobs");
//		admin.setPassword("pass");
//		Data.getInstance().addAdmin(admin);
//		Data.getInstance().addUser("steve_jobs", admin);
//		System.out.println(Data.getInstance().getCourses());
		Specialty spec = new Specialty();
		spec.setFaculty(Faculty.SITE);
		Data.getInstance().getCourses().elementAt(0).setSpecialty(spec);
		Login login = new Login();
<<<<<<< HEAD
		while(true) {
			login.menu();
			System.out.println("Enter '0' to close app. '1' - to Login");
			String input = commonBuffer.readInput();
			if(input.equals("0")) break;
		}
=======
		login.menu();
		Data.write();
>>>>>>> 81d7468f88274639a962d5fe671aa66ca63d6ba9
	}
}
