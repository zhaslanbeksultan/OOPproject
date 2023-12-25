package users;

import java.util.Date;

import common.*;
import communication.*;
import enums.*;


public class TechSupportSpecialist extends Employee {

	private static final long serialVersionUID = 1L;
	private String complaintType;

	public TechSupportSpecialist(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
	}
	public TechSupportSpecialist() {
		
	}
	public String getComplaintType() {
        return this.complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public boolean FixComplaintType() {
        return false;
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
	public void viewOrders(int orderId) {//add exceptions
		System.out.println(Data.getInstance().getOrders().get(orderId).orderInformation());
		System.out.println("'0' - Reject Order.\n'1' - Accept Order\n'2' - Order Done");
		String choice = commonBuffer.readInput();
		switch(choice) {
		case("0"):
			return;
		case("1"):
			Data.getInstance().getOrders().get(orderId).setOrderStatus(OrderStatus.ACCEPTED);
			Data.getInstance().getOrders().get(orderId).setExecutor(this.getUsername());
			break;
		case("2"):
			if(Data.getInstance().getOrders().get(orderId).getOrderStatus().equals(OrderStatus.ACCEPTED))
				Data.getInstance().getOrders().get(orderId).setOrderStatus(OrderStatus.DONE);
			else
				System.out.println("The order has not been accepted yet!");
			break;
		}
		
		
	}
	public void viewOrders() {
		while(true) {
			System.out.println("----ORDERS VIEW WINDOW");
			for(Order order: Data.getInstance().getOrders()) {
				if(order.getOrderStatus().equals(OrderStatus.NEW)) {
					System.out.println(order);
				}
			}
			System.out.println("'0' - to exit.\n'1' - View More About Order");
			String choice = commonBuffer.readInput();
			switch(choice) {
			case("0"):
				return;
			case("1"):
				System.out.println("Enter Order ID");
				int orderId = Integer.parseInt(commonBuffer.readInput());
				viewOrders(orderId-1);
				break;
			}
		}
	}

	@Override
	public void showMenu() {
		while(true) {
			System.out.println("----MAIN WINDOW----");
			System.out.println("1. Personal Datas\n2. Requests\n3. News\n4. Social Transcript\n5. Orders\n0.Log Out");
			String choice = commonBuffer.readInput();
			switch(choice) {
				case "0":
					return;
				case "1":
					editPersonalData();
					break;
				case "2":
					this.viewRequests();
					break;
				case "3":
					this.viewNews();
					break;
				case "4":
					this.viewSocialTranscript();
					break;
				case "5":
					this.viewOrders();
					break;
				case "6":
					this.viewNews();
					break;
				case "7":
					this.sendMessage();
					break;
			}
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
    
    
}
