package run;

import business.Catagories;
import business.Products;
import business.Users;
import controller.CatalogController;
import controller.ProductController;
import controller.UsersController;
import service.CatalogService;
import service.ProductsService;
import service.UsersService;
import service.lmp.ICatalogService;
import service.lmp.IProductService;
import service.lmp.IUserService;
import utils.InputMethods;

import java.util.Collections;
import java.util.List;

public class HomePage {
    private static Users users;
    private static ProductController productController = new ProductController();
    private UsersController usersController = new UsersController();
    private static ICatalogService catalogService = new CatalogService();
    private static IProductService productService = new ProductsService();
    private static IUserService userService = new UsersService();

    public static void HomePage() {
        boolean flag = true;
        do {
            System.out.println("\u001B[32m🍁🍁🍁🍁🍁HOME PAGE🍁🍁🍁🍁🍁" +
                    "\n1. Catagories (Add To Cart)" +
                    "\n2. Top Sale(Add To Cart)" +
                    "\n3. All Products List(Add To Cart" +
                    "\n4. Cart" +
                    "\n5. Account" +
                    "\n6. Log Out" +
                    "\nChoice: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    showCatagories();
                    break;
                case 2:
                    // showTopSale();
                    ProductManagerment.displayProducts();
                    break;
                case 3:
                    // showListProduct();
                    ProductManagerment.displayProducts();
                    break;
                case 4:
                    // addToCart();
                    CartManagerment.cartManagerment();
                    break;
                case 5:
                    accountInfor();
                    break;
                case 6:
                    users = null;
                    flag = false;
                    System.out.println(" You have logged out. \n_________________________");
                    break;
                default:
                    System.err.println("\nEnter number from selected category, please enter again!");
            }
        } while (flag);
    }

    public static void accountInfor() {
        List<Users> usersInfo = UsersController.getUsersList();
        System.out.println("ACCOUNT INFORMATION\n_______________________" +
                "\nUsername:"  +
                "\nCustomer's name:" + users.getFullName() +
                "\nPhone:" + users.getPhone() +
                "\nEmail:" + users.getEmail() +
                "\nRole:" + users.isRole() +
                "\nCreatedTime:" + users.getCreatedAt() +
                "\nUpdateTime:" + users.getUpdateAt() +
                "\n_______________________" +
                "\n1. Edit Information" +
                "\n2. Change Password" +
                "\nChoice:");
    }

    public static void showCatagories() {
        CatalogueManagerment.displayCatagories();
//
//            System.out.println("________________\nEnter Catagories by ID:");
//
//            List<Products> productsSort = ProductController.productService.findAll();
//            String  searchName = InputMethods.;
//            List<Catagories> listSort = catalogService.findCatalogByName(searchName);
//            if (listSort.isEmpty()){
//                System.out.println("Catagories not found!");
//                return;
//            }

//                    for (Products list : listSort) {
//                        System.out.println("\u001B[36m" +
//                                "SP: " + list.getProductName() + " | ID: " + list.getProductId() +
//                                "\nCatagories: " + catalogService.findById(catagories.getCatalogId()).getCatalogName() +
//                                "\nDescription: " + list.getDescription() +
//                                "\nPrice: " + list.getUnitPrice() + " | Stock: " + list.getStock() +
//                                "\nCreated: " + list.getCreated_at() +
//                                "\nUpdated: " + list.getUpdate_at() +
//                                "\nStatus: " + (list.isStatus() ? "Active" : "Sold!")+
//                                "\n______________________________");
//                    }
    }
}

