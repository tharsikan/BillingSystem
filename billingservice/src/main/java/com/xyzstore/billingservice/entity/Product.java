package com.xyzstore.billingservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name= "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long productId;
    @Column(
            name= "name",
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private double cartonPrice;
    @Column(
            nullable = false
    )
    private int unitsPerCarton;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Transient
//    private List<ProductOrder> productOrders;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", cartonPrice=" + cartonPrice +
                ", unitsPerCarton=" + unitsPerCarton +
                '}';
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public void setUnitsPerCarton(int unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public int getUnitsPerCarton() {
        return unitsPerCarton;
    }

}
