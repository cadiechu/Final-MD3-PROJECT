package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {
    private long userId;
    private String userName;
    private String email;
    private String phone;
    private String fullName;
    private String password;
    private boolean role;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDate updateAt;
    private List<CartItem> cart = new ArrayList<>();

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public Users() {
    }

    public Users(long userId, String userName, String email, String phone, String fullName, String password, boolean role, boolean status, LocalDateTime createdAt, LocalDate updateAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public void displayData() {
        System.out.println("\u001B[36m ⭐⭐⭐⭐⭐Users⭐⭐⭐⭐⭐\n" +
                "UserID :" + userId + " | Username: " + userName + " | Role: " + (role ? "Admin" : "Members") +
                "\nFullname: " + fullName +
                "\nEmail: " + email +
                "\nStatus : " + (status ? "Active" : "Banned") +
                "\nCreated :" + getCreatedAt() +
                "\nUpdated :" + getUpdateAt()+
                "\nCart: " +
                "\n___________________________");
    }
}
