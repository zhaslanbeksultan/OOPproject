package communication;

import java.util.Date;

import enums.*;

public class Order {
	private static int cnt = 1;
	private int orderId;
	private String sender;
	private Date orderDate;
	private OrderStatus orderStatus;//ACCEPTED, NEW, DONE;
	private String executor;//TechSupportSpecialist
	private String orderInfo;
	
	public Order(String sender, OrderStatus orderStatus, String executor, String orderInfo) {
    	this.orderId = cnt++;
		this.sender = sender;
		this.orderDate = new Date();
		this.orderStatus = OrderStatus.NEW;
		this.orderInfo = orderInfo;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	public String orderInformation() {
		return toString() + this.getOrderInfo();
	}

	@Override
	public String toString() {
		return "Order Id = " + orderId + ", Sender = " + sender + ", Order Date = " + orderDate;
	}
	
}
