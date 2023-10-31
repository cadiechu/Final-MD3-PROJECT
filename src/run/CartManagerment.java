package run;

import business.CartItem;
import business.Products;
import controller.CartController;
import utils.InputMethods;

import java.util.List;

public class CartManagerment {
    public static void cartManagerment() {
        boolean flag = true;
        do {
            System.out.println("🌛🌛🌛🌛🌛Cart🌜🌜🌜🌜🌜" +
                    "\n1. List of Products" +
                    "\n2. Change Quantity" +
                    "\n3. Remove products from cart" +
                    "\n4. Payment" +
                    "\n5. Return" +
                    "\nChoice: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    List<CartItem> pL = CartController.findAll();
                    if (pL != null){
                        for(CartItem item: pL){
                            System.out.println(
                                    item.getId()+"\n"+
                                            item.getProduct()+"\n"+
                                            item.getQuantity()
                            );
                        }
                    }
                    else
                        System.out.println("Cart empty!");
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
