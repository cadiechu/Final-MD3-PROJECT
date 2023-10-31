package run;

import business.Products;
import business.Users;
import config.IOFile;
import controller.CatalogController;
import controller.ProductController;
import controller.UsersController;
import service.CatalogService;
import service.ProductsService;
import service.lmp.ICatalogService;
import service.lmp.IProductService;
import utils.InputMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class ProductManagerment {
    private static ProductController productController = new ProductController();
    private static ICatalogService catalogService = new CatalogService();
    private static IProductService productService = new ProductsService();

    public static void ProductManagerment() {
        boolean flag = true;
        do {
            System.out.println("\u001B[32m👑👑👑👑👑Product Managerment👑👑👑👑👑" +
                    "\n1. List of Products" +
                    "\n2. Add new Product" +
                    "\n3. Edit Product Details" +
                    "\n4. Hidden Products" +
                    "\n5. Return" +
                    "\nChoice:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    //show products
                    displayProducts();
                    break;
                case 2:
                    //add new
                    addNewProduct();
                    break;
                case 3:
                    //edit
                    editProduct();
                    break;
                case 4:
                    //hide
                    hideProduct();
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

    public static void displayProducts() {
        List<Products> showProducts = productController.getListProduct();
        if (showProducts.isEmpty()) {
            System.out.println("There are no products.");
            return;
        }

        System.out.println("👑👑👑👑👑List of Products👑👑👑👑👑");
        for (Products products : showProducts) {
            System.out.println("\u001B[36m" +
                    "SP: " + products.getProductName() + " | ID: " + products.getProductId() +
                    "\nCatagories: " + catalogService.findById(products.getProductId()).getCatalogName() +
                    "\nDescription: " + products.getDescription() +
                    "\nPrice: " + products.getUnitPrice() + " | Stock: " + products.getStock() +
                    "\nCreated: " + products.getCreated_at() +
                    "\nUpdated: " + products.getUpdate_at() +
                    "\nStatus: " + (products.isStatus() ? "Active" : "Sold!"));
            System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n");
        }

    }

    public static void addNewProduct() {
        if (CatalogController.catalogService.findAll().isEmpty()) {
            System.out.println("The category list is empty, please go back and add categories.");
            return;
        }
        Products addProduct = new Products();
        long newId = productController.getNewId();
        addProduct.setProductId(newId);
        System.out.println("______________________");
        CatalogueManagerment.displayCatagories();
        System.out.println("\n____________________________\nPlease choose a category by ID.");
        while (true) {
            long inputId = InputMethods.getLong();
            if (CatalogController.catalogService.findById(inputId) != null) {
                addProduct.setCatalogId(inputId);
                break;
            } else {
                System.out.println("Please enter a category by ID.");
            }
        }

        System.out.println("Enter Product's name: ");
        String addName = InputMethods.getString();
        addProduct.setProductName(addName);
        System.out.println("Enter Description: ");
        String adddescription = InputMethods.getString();
        addProduct.setDescription(adddescription);
        System.out.println("Enter Price: ");
        double addunitPrice = InputMethods.getDouble();
        addProduct.setUnitPrice((float) addunitPrice);
        System.out.println("Stock: ");
        int addStock = InputMethods.getInteger();
        addProduct.setStock(addStock);
        addProduct.setStatus(true);
        addProduct.setCreated_at(LocalDate.from(LocalDateTime.now()));
        addProduct.setUpdate_at(LocalDate.from(LocalDateTime.now()));
        ProductController.productService.save(addProduct);
        System.out.println("Added Successfully!");
    }

    public static void editProduct() {
        boolean flag = true;
        while (flag) {
            System.out.println("_____________________________\n" +
                    "1. Change Product Status" +
                    "\n2. Remove Product" +
                    "\n3. Return" +
                    "\nChoice");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    changProductStatus();
                    break;
                case 2:
                    deleteProductById();
                    break;
                case 3:
                    System.out.println("\nReturn!\n_____________________");
                    flag = false;
                    break;
                default:
                    System.err.println("\nEnter number from selected Products, please enter again!");
            }
        }
    }

    public static void changProductStatus() {
        System.out.println("Enter ProductID:");
        long inputId = InputMethods.getLong();
        Products editProduct = ProductController.findById(inputId);
        if (editProduct == null) {
            while (true) {
                System.out.println("ProductID Not Found!");
                return;
            }
        }
        System.out.println("Enter Product Status: Active press True, Others: Any key! ");
        boolean editStatus = InputMethods.getBoolean();
        editProduct.setStatus(editStatus);
        ProductController.productService.save(editProduct);
        System.out.println("Has successfully edited!\n___________________________");
    }

    public static void deleteProductById() {
        System.out.println("Enter ProductID:");
        long inputId = InputMethods.getLong();
        Products deleteProduct = ProductController.findById(inputId);
        if (deleteProduct == null) {
            while (true) {
                System.out.println("ProductID Not Found!");
                return;
            }
        } else {
            productService.delete(inputId);
            System.out.println("Deteleted Successfully!");

        }

    }

    public static void hideProduct() {
        System.out.println("Please enter Product ID:");
        long hideId = InputMethods.getLong();
        Products hideProduct = ProductController.productService.findById(hideId);
        if (hideProduct == null) {
            while (true) {
                System.out.println("ProductID Not Found!");
                char index = InputMethods.getChar();
                if (index == 'y') {
                    hideProduct();
                } else {
                    break;
                }
            }
        }
        if (!hideProduct.isStatus()) {
            System.out.println(" Product has been changed!");
            return;
        }
        hideProduct.setStatus(false);
        System.out.println(" The product is hiding. ");
    }
}
