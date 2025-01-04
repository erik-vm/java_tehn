package controller;


import jakarta.validation.Valid;
import model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;

    }


    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return service.findOrderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder(@RequestBody @Valid Order order) {
        return service.saveOrder(order);
    }

    @DeleteMapping("/del{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        service.deleteOrderById(id);
    }
}
