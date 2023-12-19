package app;
import common.*;
import users.*;
public class Menu {
	public Menu(User user) {
		System.out.println("Welcome");
		if(n==0) {
			admin();
		}
		else if(n==1){
			student();
		}
	}
	public void admin() {
		Admin a= new Admin(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null);
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
	public void student() {
		System.out.println("1. Get retake lol\n"
				+ "2. Log out");
		String input=commonBuffer.readInput();
		switch(input) {
		case("1"):
			System.out.println("Successfuly got retake :(");
		case("2"):
			Login l= new Login();
			l.menu();
			break;
		}
	}
}
