package app;
import java.io.IOException;
import java.util.Date;
import common.*;
import education.Specialty;
import users.*;
import enums.*;
public class Main {   
	public static void main(String[] args) throws IOException {

		Admin admin = new Admin();
		admin.setUsername("steve_jobs");
		admin.setPassword("pass");
		Data.getInstance().addAdmin(admin);
		Data.getInstance().addUser("steve_jobs", admin);
//		Data.getInstance().getCourses().remove(1);
//		System.out.println(Data.getInstance().getCourses());
//		Specialty spec = new Specialty();
//		spec.setFaculty(Faculty.SITE);
//		Data.getInstance().getCourses().elementAt(0).setSpecialty(spec);
//		Data.getInstance().getStudents().elementAt(0).setAvailiableECTS(21);

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
