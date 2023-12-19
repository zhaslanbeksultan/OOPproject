package app;
import java.io.IOException;
import java.util.Date;
import common.*;
import users.*;
import enums.*;
public class Main {
	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.setPassword("pass");
		admin.setUsername("steve_jobs");
		Data.getInstance().addAdmin(admin);
		Data.getInstance().addUser("steve_jobs", admin);
		System.out.println(Data.getInstance().getUsers());
		Login login = new Login();
		login.menu();
	}
}
