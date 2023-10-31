package controller;

import service.OrderService;

public class OrderController {
    public static OrderService orderService;

    public static Long getNewId(){
        return orderService.getNewId();
    }
}
