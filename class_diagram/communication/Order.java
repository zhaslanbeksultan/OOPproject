package communication;

import java.io.Serializable;
import java.util.Date;

import enums.OrderStatus;

/**
 * The Order class represents a communication order with a unique ID, sender, order date, status, executor,
 * order information, and other relevant details. It implements the Serializable interface.
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    // Static counter for generating unique order IDs
    private static int cnt = 1;

    // Instance variables
    private int orderId;
    private String sender;
    private Date orderDate;
    private OrderStatus orderStatus;
    private String executor;
    private String orderInfo;

    /**
     * Constructs an Order object with specified sender and order information.
     *
     * @param sender     The sender of the order.
     * @param orderInfo  The information related to the order.
     */
    public Order(String sender, String orderInfo) {
        this.orderId = cnt++;
        this.sender = sender;
        this.orderDate = new Date();
        this.orderStatus = OrderStatus.NEW;
        this.orderInfo = orderInfo;
    }

    // Getter and setter methods for various properties...

    /**
     * Returns the unique ID of the order.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the unique ID of the order.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Returns the sender of the order.
     *
     * @return The sender.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the sender of the order.
     *
     * @param sender The sender to set.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Returns the date when the order was placed.
     *
     * @return The order date.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date when the order was placed.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Returns the status of the order.
     *
     * @return The order status.
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the status of the order.
     *
     * @param orderStatus The order status to set.
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Returns the executor assigned to the order.
     *
     * @return The executor.
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * Sets the executor assigned to the order.
     *
     * @param executor The executor to set.
     */
    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * Returns the information related to the order.
     *
     * @return The order information.
     */
    public String getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets the information related to the order.
     *
     * @param orderInfo The order information to set.
     */
    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    /**
     * Returns a string representation of the Order object.
     *
     * @return A string containing the order's ID, sender, and order date.
     */
    @Override
    public String toString() {
        return "Order Id = " + orderId + ", Sender = " + sender + ", Order Date = " + orderDate;
    }

    /**
     * Returns a detailed string representation of the order, including order information.
     *
     * @return A string containing the order's ID, sender, order date, and order information.
     */
    public String orderInformation() {
        return toString() + " " + getOrderInfo();
    }
}
