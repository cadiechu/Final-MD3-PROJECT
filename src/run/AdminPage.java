package run;

import business.Users;
import service.UsersService;
import service.lmp.IUserService;
import utils.InputMethods;

public class AdminPage {
    private static final IUserService userService = new UsersService();
    public static Users accountLogin;

    public static void AdminPage() {
        boolean flag = true;
        do {
            System.out.println("\u001B[35m 🌛🌛🌛🌛🌛 ADMIN 🌜🌜🌜🌜🌜" +
                    "\n1. Users Managerment" +
                    "\n2. Catalogue Managerment" +
                    "\n3. Products Managerment" +
                    "\n4. Orders Managerment" +
                    "\n5. Sign Out" +
                    "\nChoice: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    UsersManagerment.UserManagerment();
                    break;
                case 2:
                    CatalogueManagerment.catalogueManagerment();
                    break;
                case 3:
                    ProductManagerment.ProductManagerment();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Sign Out!");
                    flag = false;
                default:
                    System.err.println("\nEnter number from selected category, please enter again!");
            }
        } while (flag);
    }
}

