package controller;

import business.CartItem;
import business.Users;
import service.lmp.CartService;

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

    public void save(CartItem cartItem) {
        cartService.save(cartItem);
    }

    public void delete(Integer id) {
        cartService.delete(id);
    }

    public CartItem findById(Integer id) {
        return cartService.findById(id);
    }

    public Long getNewId() {
        List<CartItem> cartItemList = findAll();
        Long NI = (long) (cartItemList.stream().map(CartItem::getId).max(Comparator.naturalOrder()).orElse(0) +1);
        return NI;
    }
}