package service;

import model.Order;

import java.util.List;


public interface OrderService {
    Order saveOrder(Order order);


    List<Order> getAllOrders();


    void deleteOrderById(Integer id);


    Order findOrderById(int idValue);
}
