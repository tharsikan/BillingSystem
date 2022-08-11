package com.xyzstore.billingservice.repository;

import com.xyzstore.billingservice.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProduct(){
        Product product = new Product();
        product.setName("hoursewheel");
        product.setCartonPrice(100);
        product.setUnitsPerCarton(12);

        productRepository.save(product);
    }

    @Test
    public void getAllProduct(){
        List<Product> productList = productRepository.findAll();
        System.out.println(productList);
    }

    @Test
    public void printProductByName(){
        List<Product> productList = productRepository.findByName("hoursewheel");
        System.out.println(productList);
    }
}