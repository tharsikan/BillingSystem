package com.xyzstore.billingservice.controller;

import com.xyzstore.billingservice.dto.OrderDto;
import com.xyzstore.billingservice.entity.Order;
import com.xyzstore.billingservice.service.ProductOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {
    @Autowired
    ProductOrderServiceImpl productOrderService;

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrders(@RequestBody OrderDto orderDto){
        return new ResponseEntity<Order>(productOrderService.saveOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = null;
        try{
            orders = productOrderService.getAllOrder();
        }catch (Exception exception){
            exception.getMessage();
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long order_id){
        Order order = null;
        try{
            order = productOrderService.getOrderById(order_id).get();
        }catch (Exception exception){
            exception.getMessage();
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
