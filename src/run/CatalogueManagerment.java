package run;

import business.Catagories;
import business.Products;
import business.Users;
import config.IOFile;
import controller.CatalogController;
import controller.ProductController;
import controller.UsersController;
import service.CatalogService;
import service.lmp.ICatalogService;
import utils.InputMethods;

import java.util.List;

public class CatalogueManagerment {
    public static ICatalogService catalogService = new CatalogService();
    public static CatalogController catalogController = new CatalogController();

    public static void catalogueManagerment() {
        boolean flag = true;
        do {
            System.out.println("🌺🌺🌺🌺🌺Catagories🌺🌺🌺🌺🌺🌺" +
                    "\n1. List All Catagories" +
                    "\n2. Create New Catalog" +
                    "\n3. Search By Catagories" +
                    "\n4. Hidden Catagories" +
                    "\n5. Return" +
                    "\nChoice: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // show Catagories
                    displayCatagories();
                    break;
                case 2:
                    // Add new catalogue
                    addNewCatagories();
                    break;
                case 3:
                    //  search by name
                    searchByCatagories();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("\nReturn!\n_____________________");
                    flag = false;
                    break;
                default:
                    System.err.println("\nEnter number from selected category, please enter again!");
            }
        } while (flag);
    }

    public static void displayCatagories() {
        List<Catagories> showCatalogList = catalogController.getCatalogList();
        if (showCatalogList.isEmpty()) {
            System.out.println("There are no Catagories.");
            return;
        } else {
            System.out.println("\u001B[36m ⭐⭐⭐⭐⭐Catalogue⭐⭐⭐⭐⭐\n");
            for (Catagories catagories : showCatalogList) {
                System.out.println("ID:" + catagories.getCatalogId() + " | Catalog Name:" + catagories.getCatalogName() +
                        "\nDescription: " + catagories.getDescription() +
                        "\nStatus: " + (catagories.isStatus() ? "Active" : "Sold!") + "\n" +
                        "\n_______________________________________");
            }
        }


    }

    public static void addNewCatagories() {
        Catagories addCatagories = new Catagories();
        addCatagories.setCatalogId(CatalogController.catalogService.getNewId());
        System.out.println("Input Catalog Name: ");
        String catalogName = InputMethods.getString();
        addCatagories.setCatalogName(catalogName);
        System.out.println("Description: ");
        String description = InputMethods.getString();
        addCatagories.setDescription(description);
        addCatagories.setStatus(true);
        CatalogController.catalogService.save(addCatagories);
        List<Catagories> cateList = CatalogController.getCatalogList();
        cateList.add(addCatagories);
        IOFile.writeToFile(IOFile.CATALOG_PATH, cateList);
        System.out.println("Successfully Added!");
    }

    public static void searchByCatagories() {
        System.out.println("Search By Catagories: ");
        String inputCatalogName = InputMethods.getString();
        CatalogController.searchByCatagories(inputCatalogName);
    }
}
