package controller;

import business.Catagories;
import business.Users;
import service.CatalogService;
import service.lmp.ICatalogService;
import utils.InputMethods;

import java.util.List;

public class CatalogController {
    public static final ICatalogService catalogService = new CatalogService();
    public static List<Catagories> getCatalogList() {
        List<Catagories> catagoriesList = catalogService.findAll();
        return catagoriesList;
    }

    public void save(Catagories catagories) {
        catalogService.save(catagories);
    }

    public static Catagories findById(long id) {
        return catalogService.findById(id);
    }

    public long getNewId() {
        return catalogService.getNewId();
    }

    public static void searchByCatagories(String name) {
        List<Catagories> catagoriesList = catalogService.findAll();
        for (Catagories catagories : catagoriesList) {
            if (catagories.getCatalogName().equals(name)) {
            }
        }
    }

}
