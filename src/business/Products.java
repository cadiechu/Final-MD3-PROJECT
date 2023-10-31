package business;

import controller.CatalogController;
import service.CatalogService;
import utils.InputMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Products implements Serializable {
    private long productId;
    private String productName;
    private long categoryId;
    private String description;
    private float unitPrice;
    private int stock;
    private LocalDate created_at;
    private LocalDate update_at;
    private Catagories catalogId;
    private boolean status;

    public Products() {
    }

    public Products(long productId, String productName, long categoryId, String description, float unitPrice, int stock, LocalDate created_at, LocalDate update_at, Catagories catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.created_at = created_at;
        this.update_at = update_at;
        this.catalogId = catalogId;
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long id) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }

    public Catagories getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long id) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
