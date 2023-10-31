package business;

import controller.UsersController;
import utils.InputMethods;

import java.io.Serializable;

public class Catagories implements Serializable {
    private long catalogId;
    private String catalogName;
    private String description;
    private boolean status;

    public Catagories() {
    }

    public Catagories(long catalogId, String catalogName, String description, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.status = status;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
