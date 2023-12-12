package app;
import common.*;
import users.*;
public class Menu {
	public Menu(int n) {
		System.out.println("Welcome");
		if(n==0) {
			admin();
		}
	}
	public void admin() {
		Admin a= new Admin();
		System.out.println("1. Add student\n"
							+ "2. Log out");
		String input=commonBuffer.readInput();
		switch(input) {
		case("1"):
			a.createStudent();
		case("2"):
			Login l= new Login();
			l.menu();
			break;
		}
		
	}
}
