package service.lmp;

import business.*;
import controller.OrderController;
import controller.ProductController;
import controller.UsersController;
import service.UsersService;

import java.util.Comparator;
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
                if (ProductController.findById(c.getProduct()).getProductId() == ProductController.findById(cartItem.getProduct()).getProductId()){
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

    public long getNewId(){
        Long PL = cartItems.stream().map(CartItem::getId).max(Comparator.naturalOrder()).orElse(0L) + 1;
        return PL;

    }

    public void checkOut(String phoneNumber, String address) {
        Order order = new Order();
        order.setOrderId(OrderController.getNewId());

        List<OrderDetail> orderDetails = cartItems.stream().map(cartItem -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(ProductController.findById(cartItem.getProduct()).getProductId());
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setProductName(ProductController.findById(cartItem.getProduct()).getProductName());
            orderDetail.setUnitPrice(ProductController.findById(cartItem.getProduct()).getUnitPrice());
            orderDetail.setQuantity(cartItem.getQuantity());
            return orderDetail;
        }).toList();

        order.setUserId(userLogin.getUserId());
        order.setName(userLogin.getFullName());
        order.setPhoneNumber(phoneNumber);
        order.setAddress(address);
        double total = cartItems.stream().mapToDouble(c -> ProductController.findById(c.getProduct()).getUnitPrice() * c.getQuantity()).sum();
        order.setTotal(total);

        OrderController.orderService.save(order);



    }

    public void addProdToListCart(long id, int quantity) {
        CartItem cartItem = new CartItem();
        //Prod
        cartItem.setProduct(ProductController.productService.findById(id).getProductId());
        //Quantity
        cartItem.setQuantity(quantity);
        //Save cart to user
        save(cartItem);
    }
}
