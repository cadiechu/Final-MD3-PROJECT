package service;

import business.CartItem;
import business.Order;
import business.Users;
import config.IOFile;
import service.lmp.IOderService;

import java.util.Comparator;
import java.util.List;

public class OrderService implements IOderService {
    List<Order> orders ;
    private Users user;
    private UsersService usersService;
    public  OrderService(){
        this.orders = IOFile.readFromFile(IOFile.ORDER_PATH);
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
    public Order findById(long id) {
        return orders.stream().filter(order -> order.getOrderId() == id).findFirst().orElse(null);
    }
    @Override
    public boolean save(Order order) {
        if (findById(order.getOrderId()) != null) {
            // Order isExist
            orders.set(orders.indexOf(findById(order.getOrderId())), order);
        } else {
            // Add new order
            orders.add(order);
        }
        //Add to file
        IOFile.writeToFile(IOFile.ORDER_PATH, orders);
        return true;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public long getNewId() {
        return orders.stream().map(Order::getOrderId).max(Comparator.naturalOrder()).orElse(0L) + 1;
    }

    @Override
    public void confirmOrder(long id) {

    }

    @Override
    public void cancelOrder(long id) {

    }

    @Override
    public void completeOrder(long id) {

    }

    @Override
    public void display(List<Order> list) {

    }

    @Override
    public Order findOrderWaitingById(long id) {
        return null;
    }

    @Override
    public Order findOrderWaitingForUserById(long id) {
        return null;
    }

    @Override
    public Order findOrderConfirmById(long id) {
        return null;
    }

    @Override
    public List<Order> findOrderWaiting() {
        return null;
    }

    @Override
    public List<Order> findOrderConfirm() {
        return null;
    }

    @Override
    public List<Order> findOrderCancel() {
        return null;
    }

    @Override
    public List<Order> findOrderComplete() {
        return null;
    }

    @Override
    public List<Order> findAllForUser(long id) {
        return null;
    }

    @Override
    public List<Order> findOrderWaitingForUser(long id) {
        return null;
    }

    @Override
    public List<Order> findOrderConfirmForUser(long id) {
        return null;
    }

    @Override
    public List<Order> findOrderCancelForUser(long id) {
        return null;
    }

    @Override
    public List<Order> findOrderCompleteForUser(long id) {
        return null;
    }
}
