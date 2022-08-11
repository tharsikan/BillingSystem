package com.xyzstore.billingservice.entity;

import com.xyzstore.billingservice.repository.OrderRepository;
import com.xyzstore.billingservice.repository.BillRepository;
import com.xyzstore.billingservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillRepository productOrderRepository;

    @Test
    public Optional<Product> getProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

//    public void createOrder(double discountPercentage,double unitPriceIncrementPercentage){
//        Bill productOrder = new Bill();
//        Order order = new Order();
//        order.setDiscount(discountPercentage);
//        order.setSingleUnitPriceIncrement(unitPriceIncrementPercentage);
//    }
//    public void saveProduct(){
//        Product product = new Product();
//        product.setName("hoursewheel");
//        product.setCartonPrice(100);
//        product.setUnitsPerCarton(12);
//
//        productRepository.save(product);
//    }
//
//    public Order createOrder(){
//
//        Order order = new Order();
//        order.setDiscount(0.1);
//        order.setSingleUnitPriceIncrement(1.3);
//        return orderRepository.save(order);
//    }
//
//    @Test
//    public void addProduct(Long productId,int quantity){
//        saveProduct();
//        Product product = getProductById(1l).get();
//        Order order = createOrder();
//        Bill productOrder = new Bill();
//        productOrder.setProduct(product);
//        productOrder.setOrder(order);
//
//        int numberofcartons = quantity / product.getUnitsPerCarton();
//        int numberofsingleunits = quantity % product.getUnitsPerCarton();
//        double total = product.getCartonPrice() * (numberofcartons + numberofsingleunits * order.getSingleUnitPriceIncrement());
//
//        productOrder.setTotal(total);
//        System.out.println(productOrder);
//    }
}