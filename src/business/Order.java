package business;

import utils.InputMethods;

import java.util.Date;

public class Order {
    private Long orderId;
    private Long userId;
    private String name;
    private String phoneNumber;
    private String address;
    private double total;

    private enum orderStatus {
        WAITING,
        CONFIRM,
        DELIVERY,
        SUCCESS,
        CANCEL
    }

    ;
//    private List<OrderDetail> orderDetail ;

    public Order() {
    }

    public Order(Long orderId, Long userId, String name, String phoneNumber, String address, double total) {
        this.orderId = orderId;
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void inputData() {
        System.out.println("Add Phone: ");
        this.phoneNumber = InputMethods.getString();
        System.out.println("Add Address: ");
        this.address = InputMethods.getString();
    }
    public void displayData() {
        System.out.println("\u001B[36m ⭐⭐⭐⭐⭐Order⭐⭐⭐⭐⭐\n" +
                "Order ID: " + orderId +
                "\nUser ID: " + userId + " | Customer: " + name +
                "\nPhone: " + phoneNumber +
                "\nAddress: " + address +
                "\nTotal: " + total +
                "\nOrder Status: " + (orderStatus.DELIVERY));
    }
}
