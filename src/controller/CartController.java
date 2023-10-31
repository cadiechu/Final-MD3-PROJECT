package controller;

import business.CartItem;
import business.Products;
import business.Users;
import run.CatalogueManagerment;
import run.ProductManagerment;
import service.lmp.CartService;
import utils.InputMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class CartController {
    private static CartService cartService = new CartService();

    public CartController(Users userLogin) {
        this.cartService = new CartService(userLogin);
    }

    public static List<CartItem> findAll() {
        List<CartItem> rL = cartService.findAll();
        return rL;
    }

    public static void save(CartItem cartItem) {
        cartService.save(cartItem);
    }

    public void delete(Integer id) {
        cartService.delete(id);
    }

    public CartItem findById(Integer id) {
        return cartService.findById(id);
    }

    public static long getNewId() {
        return cartService.getNewId();
    }

    public static void addNewItem() {
        CartItem addCart = new CartItem();
        long newId = getNewId();
        addCart.setId(newId);
        System.out.println("______________________");
        ProductManagerment.displayProducts();
        System.out.println("\n____________________________\nPlease choose a product by Id");
        while (true) {
            long inputId = InputMethods.getLong();
            if (ProductController.findById(inputId) != null) {
                addCart.setProduct(inputId);
                break;
            } else {
                System.out.println("Please enter a product by ID.");
            }
        }

        System.out.println("Enter Quantity: ");
        int addQuan = InputMethods.getInteger();
        addCart.setQuantity(addQuan);

        save(addCart);
        System.out.println("Added Successfully!");
    }
}