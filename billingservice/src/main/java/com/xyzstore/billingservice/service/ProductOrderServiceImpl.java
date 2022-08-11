package com.xyzstore.billingservice.service;

import com.xyzstore.billingservice.dto.OrderDto;
import com.xyzstore.billingservice.entity.Bill;
import com.xyzstore.billingservice.entity.Order;
import com.xyzstore.billingservice.entity.Product;
import com.xyzstore.billingservice.repository.OrderRepository;
import com.xyzstore.billingservice.repository.BillRepository;
import com.xyzstore.billingservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillRepository billRepository;

    public List<Product> getAllProduct(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public List<Order> getAllOrder(){
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    public Optional<Product> getProductById(long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public Optional<Order> getOrderById(long id){
        Optional<Order> order = orderRepository.findById(id);
        return order;
    }
    public Product saveProduct(Product product){
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setCartonPrice(product.getCartonPrice());
        newProduct.setUnitsPerCarton(product.getUnitsPerCarton());

        return productRepository.save(newProduct);
    }

    @Value("${constant.singleUnitPriceIncrementPercentage}")
    private double incrementPercentage;

    public Order saveOrder(OrderDto orderDto){
        Product product = getProductById(orderDto.getProductId()).get();

        Order order = new Order();
        order.setQuantity(orderDto.getQuantity());
        order.setProduct(product);

        int numberOfCarton = orderDto.getQuantity() / product.getUnitsPerCarton();
        int singleUnits = orderDto.getQuantity() % product.getUnitsPerCarton();
        double singleUnitsPrice = singleUnits * (product.getCartonPrice()/product.getUnitsPerCarton()) * incrementPercentage;
        double price = product.getCartonPrice() * numberOfCarton + singleUnitsPrice;
        order.setPrice(price);
        order.setNumberOfCarton(numberOfCarton);
        return orderRepository.save(order);
    }

    @Value("${constant.discountPercentage}")
    private double discountPercentage;

    public Bill saveBill(List<OrderDto> orderDtos) {
        int totalCarton = 0;
        double discount = 0;
        double totalPrice = 0;
        Bill bill = new Bill();
        bill.setEligibleDiscount(false);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < orderDtos.size(); i++) {
            orders.add(saveOrder(orderDtos.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            totalCarton = totalCarton + orders.get(i).getNumberOfCarton();
            totalPrice = totalPrice + orders.get(i).getPrice();
        }
        if(totalCarton >= 3){
            bill.setEligibleDiscount(true);
            discount = totalPrice * discountPercentage;
            totalPrice = totalPrice - discount;
            bill.setDiscount(discount);
        }

        bill.setOrders(orders);
        bill.setTotalAmount(totalPrice);

        return billRepository.save(bill);
    }




}
