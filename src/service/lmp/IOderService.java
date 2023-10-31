package service.lmp;

import business.Order;

import java.util.List;

public interface IOderService extends IGeneric<Order, Long>{
    long getNewId();
    void confirmOrder(long id);
    void cancelOrder(long id);
    void completeOrder(long id);
    void display(List<Order> list);
    Order findOrderWaitingById(long id);
    Order findOrderWaitingForUserById(long id);
    Order findOrderConfirmById(long id);

    List<Order> findOrderWaiting();
    List<Order> findOrderConfirm();
    List<Order> findOrderCancel();
    List<Order> findOrderComplete();

    List<Order> findAllForUser(long id);

    List<Order> findOrderWaitingForUser(long id);
    List<Order> findOrderConfirmForUser(long id);
    List<Order> findOrderCancelForUser(long id);
    List<Order> findOrderCompleteForUser(long id);
}
