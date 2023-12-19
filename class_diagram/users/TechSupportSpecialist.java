package users;

import java.util.Date;

import common.*;
import communication.*;
import enums.*;


public class TechSupportSpecialist extends Employee {

    private String complaintType;

	public TechSupportSpecialist(String firstName, String lastName, Date birthDay, String id, String username,
			String password, String email, Date registrationDate, String phoneNumber, String pasportNumber,
			Gender gender, String nationality, String citizenship, double salary, Date hireDate, String insuranceNumber) {
		super(firstName, lastName, birthDay, id, username, password, email, registrationDate, phoneNumber,
				pasportNumber, gender, nationality, citizenship, salary, hireDate, insuranceNumber);
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
	void addRequest() {
		// TODO Auto-generated method stub
		
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
		case("2"):
			if(Data.getInstance().getOrders().get(orderId).getOrderStatus().equals(OrderStatus.ACCEPTED))
				Data.getInstance().getOrders().get(orderId).setOrderStatus(OrderStatus.DONE);
			else
				System.out.println("The order has not been accepted yet!");
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
				break;
			case("1"):
				System.out.println("Enter Order ID");
				int orderId = Integer.parseInt(commonBuffer.readInput());
				viewOrders(orderId-1);
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
					break;
				case "1":
					System.out.println(this);;
				case "2":
					this.viewRequests();;
				case "3":
					this.viewNews();
				case "4":
					this.viewSocialTranscript();;
				case "5":
					this.viewOrders();
				case "6":
					this.viewNews();
			}
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
    
    
}
