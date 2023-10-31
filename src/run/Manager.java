package run;

import business.Users;
import controller.UsersController;
import utils.InputMethods;

import java.time.LocalDateTime;
import java.util.Objects;

public class Manager {
    public static Users currentLogin;

    public static void main(String[] args) {
        do {
            System.out.println("\n\u001B[36m🌛🌛🌛🌛🌛WELCOME TO MYSHOP🌜🌜🌜🌜🌜\n" +
                    "1. Sign In\n" +
                    "2. Sign Up \n" +
                    "3. Quit\n" +
                    "Choice : ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.err.println("End Task!");
                    System.exit(0);
                default:
                    System.err.println("\nEnter number from selected category, please enter again!");
            }
        } while (true);
    }

    public static void login() {
        System.out.print("\u001B[36m ⭐⭐⭐⭐⭐LOGIN⭐⭐⭐⭐⭐\n" +
                "Username: ");
        String username = InputMethods.getString();
        System.out.print("Password: ");
        String password = InputMethods.getString();
        if (Objects.equals(username, "admin") && Objects.equals(password, "chau1")) {
            System.out.println("\nRedirect to Admin Page!\n_____________________");
            AdminPage.AdminPage();
        } else {
            Users usersLogin = UsersController.login(username, password);
            if (usersLogin == null) {
                currentLogin = usersLogin;
                System.out.println("\n\n__________________________\nLog in Success! Redirect to HomePage!");
                HomePage.HomePage();
            }
        }
    }

    public static void register() {
        Users newUser = new Users();
        System.out.println("==================REGISTER======================");
        newUser.setUserId(UsersController.usersService.getNewId());
        System.out.println("Input Username :");
        String userName = InputMethods.getString();
        newUser.setUserName(userName);
        System.out.println("Input Password :");
        String password = InputMethods.getString();
        newUser.setPassword(password);
        System.out.println("Input Phone :");
        String phone = InputMethods.getString();
        newUser.setPhone(phone);
        System.out.println("Your fullname :");
        String fullName = InputMethods.getString();
        newUser.setFullName(fullName);
        System.out.println("Your Email :");
        String email = InputMethods.getString();
        newUser.setEmail(email);
        //Role
        newUser.setRole(false);
        //status
        newUser.setStatus(true);
        //Time Create
        LocalDateTime createdTime = LocalDateTime.now();
        newUser.setCreatedAt(createdTime);
        UsersController.usersService.save(newUser);
        System.out.println("Successfully Registered!");
        login();
    }
}
