package app;
import java.io.IOException;
import java.util.Date;
import common.*;
import users.*;
import enums.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Admin admin = new Admin();
		admin.setUsername("steve_jobs");
		admin.setPassword("pass");
		Data.getInstance().addAdmin(admin);
		Data.getInstance().addUser("steve_jobs", admin);
		Login login = new Login();
		login.menu();
		Data.write();
	}
}
