package run;

import business.Users;
import controller.UsersController;
import service.UsersService;
import utils.InputMethods;

import java.util.List;

public class UsersManagerment {
    public static void UserManagerment() {
        boolean flag = true;
        while (flag) {
            System.out.println("🌛🌛🌛🌛Users Managerment🌜🌜🌜🌜\n" +
                    "1. List All Users\n" +
                    "2. Search for Users\n" +
                    "3. Block/ Unblock User's account\n" +
                    "4. Return\n" +
                    "Lựa chọn: ");
            byte choie = InputMethods.getByte();
            switch (choie) {
                case 1:
                    List<Users> Ul = UsersController.getUsersList();
                    Ul.forEach((Users) -> Users.displayData());
                    break;
                case 2:
                    System.out.println("Input user's name: ");
                    String strInput = InputMethods.getString();
                    UsersController.findUserByName(strInput);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\nReturn!\n_____________________");
                    flag = false;
                    break;
            }
        }
    }
}
