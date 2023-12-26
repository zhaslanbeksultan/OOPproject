package users;

import java.util.Date;

import common.Data;
import common.commonBuffer;
import enums.Gender;
import userCapabilities.Subscriber;
import communication.*;

public class Librarian extends Employee implements Subscriber{

	private static final long serialVersionUID = 1L;

	public Librarian(String firstName, String lastName, Date birthDay, String id, String username, String password,
			String email, Date registrationDate, String phoneNumber, String pasportNumber, Gender gender,
			String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber, pasportNumber,
				gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}
	
	public Librarian() {
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
		System.out.println("Choose:\n1.Add New Books To Library\n2.Remove Books From Library\n3.Notify All Readers"
				+ "\n4.Add Order\n5.Research Cabinet\n6.Edit Personal Data\n7.Send Messages\n8.View Incoming Messages"
				+ "\n9.Social Transcript\n0.LogOut");
    	String choose = commonBuffer.readInput();
    	if(choose=="0") {return;}
    	else if(choose=="1") {addBook();}
		else if(choose=="2") {removeBook();}
		else if(choose=="3") {notifyReaders();}
		else if(choose=="4") {addOrder();}
		else if(choose=="5") {researchCabinet();}
		else if(choose=="6") {editPersonalData();}
		else if(choose=="7") {sendMessage();}
		else if(choose=="8") {showMessages();}
		else if(choose=="9") {viewSocialTranscript();}
		else {System.out.println("The wrong character is entered!");}
		
	}
	

	public void addBook() {
		while(true) {
			System.out.println("----WINDOW FOR ADDING BOOKS----");
			System.out.println("Enter '0' to exit or '1' to continiue working.");
			System.out.println("Enter Book Name: ");
			String bookName = commonBuffer.readInput(); 
			System.out.println("Enter Book Author: ");
			String author = commonBuffer.readInput(); 
			Book book = new Book(bookName, author);
			Data.getInstance().addBook(book);
			System.out.println("Book Successfully Added!");
			String choice = commonBuffer.readInput(); 
			if(choice.equals("0"))
				break;
		}
	}
	public void removeBook() {
		while(true) {
			System.out.println("----WINDOW FOR REMOVING BOOKS----");
			System.out.println("Enter '0' to exit or '1' to continiue working.");
			System.out.println("Enter Book Name: ");
			String bookName = commonBuffer.readInput();
			for(Book book: Data.getInstance().getBooks()) {
				if(book.getBookName().equals(bookName))
					Data.getInstance().getBooks().remove(book.getBookId()-1);
			}
			System.out.println("Books Successfully Removed From The Library!");
			String choice = commonBuffer.readInput(); 
			if(choice.equals("0"))
				break;
		}
	}

	@Override
	public void addRequest() {
		while(true) {
			System.out.println("----ADD REQUEST WINDOW----");
			System.out.println("Select the Form: 'Paper', 'Electronic'");
			String form = commonBuffer.readInput(); 
			System.out.println("Select the Type:\nHELP_FOR_THE_DEPARTMENT_OF_DEFENSE_AFFAIRS"
					+ "\nHELP_FOR_THE_MANUAL_FOR_LARGE_FAMILIES\nHELP_FOR_THE_MANUAL_FOR_ON_THE_LOSS_OF_THE_BREADWINNER"
					+ "\nINFORMATION_ABOUT_THE_PLACE_OF_REQUIREMENT");
			String type = commonBuffer.readInput();
			System.out.println("Select the Language: 'EN', 'RU', 'KZ'");
			String language = commonBuffer.readInput();
			Request request = new Request(this.getUsername(), form, type, language);
			System.out.println("'0' - Cancel");
			System.out.println("'1' - If You Want Add Additionally Information");
			System.out.println("'2' - Save");
			String choice = commonBuffer.readInput();
			if(choice.equals("0")) break;
			if(choice.equals("1")) {
				String info = commonBuffer.readInput();
				request.setAdditionallyInfo(info);
				choice = commonBuffer.readInput();}
			if(choice.equals("2"))
				Data.getInstance().addRequest(request);
				break;
		}
	}

	@Override
	public void notifySubscriber(String journalName, String projectTopic, String paperTitle) {	
    	Message message = new Message("A New Article Has Been Published About" + projectTopic, journalName, this.getUsername()
    			, "The New Article Is Already In The Research Cabinet. The new article is already in the study room. You can read it");
    	Data.getInstance().getMessages().add(message);
	}
}
