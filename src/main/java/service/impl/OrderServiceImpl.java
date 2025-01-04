package service.impl;

import dao.OrderDao;
import model.Order;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao dao;

    public OrderServiceImpl(OrderDao dao) {
        this.dao = dao;
    }

    @Override
    public Order saveOrder(Order order) {
        return dao.saveOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    @Override
    public void deleteOrderById(Integer id) {
        dao.deleteOrderById(id);
    }

    @Override
    public Order findOrderById(int idValue) {
        return dao.findOrderById(idValue);
    }
}
