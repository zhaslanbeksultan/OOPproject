package users;

import java.util.Date;

import common.Data;
import common.commonBuffer;
import enums.Gender;
import communication.*;

public class Librarian extends Employee {

	public Librarian(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}
	
	public void notifyReaders() {
		String messageWording = "Please return the book before the end of this semester. Book you must return is: ";

		for(Book book: Data.getInstance().getBooks()) {
			if(book.isBorrowed()) {
				Message message = new Message("About the Return of the Books", this.getUsername(), book.getReader().getUsername(), messageWording + book.getBookName());
				Data.getInstance().addMessage(message);
			}
		}
		System.out.println("All Readers Who Borrowed Books Were Notified.");
	}
	
	
	@Override
	public void showMenu() {
		System.out.println("----MAIN WINDOW----");
		System.out.println("Choose:\n1.Add New Books To Library\n2.Remove Books From Library\n3.Notify All Readers");
    	String choose = commonBuffer.readInput();
  		if(choose=="1") {addBook();}
		else if(choose=="2") {removeBook();}
		else if(choose=="3") {notifyReaders();}
		else {System.out.println("The wrong character is entered!");}
		
	}

	public void addBook() {
		System.out.println("----MAIN WINDOW----");
		System.out.println("Enter Book Name: ");
		System.out.println("Enter Book Author: ");
	}
	public void removeBook() {}
}
