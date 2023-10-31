package service.lmp;

import business.*;
import controller.OrderController;
import controller.ProductController;
import controller.UsersController;
import service.UsersService;

import java.util.List;

public class CartService implements IGeneric<CartItem,Integer>{
     Users userLogin;
     UsersService usersService;
    List<CartItem> cartItems;
    public CartService(Users userLogin) {
        this.userLogin = userLogin;
        usersService= new UsersService();
    }

    public CartService() {

    }

    @Override
    public List<CartItem> findAll() {
       return cartItems ;
    }

    @Override
    public boolean save(CartItem cartItem) {
        boolean flag = true;
        if (userLogin.getCart()==null){
            flag=true;
        }else {
            for (CartItem c : userLogin.getCart()){
                if (c.getProduct().getProductId()==cartItem.getProduct().getProductId()){
                    c.setQuantity(c.getQuantity()+cartItem.getQuantity());
                    flag=false;
                    break;
                }
            }
        }
        if (flag){
            userLogin.getCart().add(cartItem);
        }
        UsersController.usersService.save(userLogin);
        return true;
    }

    @Override
    public void delete(Integer id) {
        cartItems.remove(findById(id));
        UsersController.usersService.save(userLogin);
    }

    public CartItem findById(Integer id) {
        for (CartItem ci : userLogin.getCart()) {
            if(ci.getId()==id){
                return  ci;
            }
        }
        return  null;
    }

    public void checkOut(String phoneNumber, String address) {
        Order order = new Order();
        order.setOrderId(OrderController.getNewId());

        List<OrderDetail> orderDetails = cartItems.stream().map(cartItem -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(cartItem.getProduct().getProductId());
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setProductName(cartItem.getProduct().getProductName());
            orderDetail.setUnitPrice(cartItem.getProduct().getUnitPrice());
            orderDetail.setQuantity(cartItem.getQuantity());
            return orderDetail;
        }).toList();

        order.setUserId(userLogin.getUserId());
        order.setName(userLogin.getFullName());
        order.setPhoneNumber(phoneNumber);
        order.setAddress(address);
        double total = cartItems.stream().map(c->c.getProduct().getUnitPrice()*c.getQuantity()).reduce(0F, Float::sum);
        order.setTotal(total);

        OrderController.orderService.save(order);
    }

    public void addProdToListCart(long id, int quantity) {
        CartItem cartItem = new CartItem();
        //Prod
        cartItem.setProduct(ProductController.productService.findById(id));
        //Quantity
        cartItem.setQuantity(quantity);
        //Save cart to user
        save(cartItem);
    }
}
