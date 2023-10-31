package business;

import utils.InputMethods;

public class OrderDetail {
    private Long productId;
    private Long orderId;
    private String productName;
    private Float unitPrice;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Long productId, Long orderId, String productName, Float unitPrice, int quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData() {
        System.out.println("Add Quantity:");
        this.quantity = InputMethods.getInteger();
    }

    public void displayData() {
        System.out.println("\nu001B[36m ⭐⭐⭐⭐⭐CheckOut⭐⭐⭐⭐⭐\n" +
                "\nProductID:" + productId +
                "\nOrderID:" + orderId +
                "\nProduct's name:" + productName +
                "\nPrice:" + unitPrice +
                "\nQuantity:" + quantity +
                "\nTotal: " + (unitPrice*quantity));

    }
}
