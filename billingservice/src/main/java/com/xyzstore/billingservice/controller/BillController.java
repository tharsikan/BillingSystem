package com.xyzstore.billingservice.controller;

import com.xyzstore.billingservice.dto.OrderDto;
import com.xyzstore.billingservice.entity.Bill;
import com.xyzstore.billingservice.entity.Order;
import com.xyzstore.billingservice.service.ProductOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BillController {
    @Autowired
    ProductOrderServiceImpl productOrderService;

    @PostMapping("/bill")
    public ResponseEntity<Bill> saveBill(@RequestBody List<OrderDto> orderDtos){
        return new ResponseEntity<Bill>(productOrderService.saveBill(orderDtos), HttpStatus.CREATED);
    }
}
