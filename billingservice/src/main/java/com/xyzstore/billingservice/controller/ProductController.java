package com.xyzstore.billingservice.controller;

import com.xyzstore.billingservice.entity.Order;
import com.xyzstore.billingservice.entity.Product;
import com.xyzstore.billingservice.service.ProductOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    ProductOrderServiceImpl productOrderService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product){
        return new ResponseEntity<Product>(productOrderService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = null;
        try{
            products = productOrderService.getAllProduct();
        }catch (Exception exception){
            exception.getMessage();
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long product_id){
        Product product = null;
        try{
            product = productOrderService.getProductById(product_id).get();
        }catch (Exception exception){
            exception.getMessage();
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
