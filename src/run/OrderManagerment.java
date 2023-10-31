package run;

import utils.InputMethods;

public class OrderManagerment {
    public static void orderManagerment() {
        boolean flag = true;
        do {
            System.out.println("💼💼💼💼💼Cart Managerment💼💼💼💼💼" +
                    "\n1. To Pay " +
                    "\n2. To Ship" +
                    "\n3. To Receive" +
                    "\n4. Completed" +
                    "\n5. Cancelled/Refund" +
                    "\n6. Return" +
                    "\nChoice:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Return!\n________________________");
                    flag = false;
                    break;
                default:
                    System.err.println("\nEnter number from selected category, please enter again!");
            }
        } while (flag);
    }
}
