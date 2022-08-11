package com.xyzstore.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    private long orderId;

    @OneToOne
    @JoinColumn(
            name = "productId",
            referencedColumnName = "productId"
    )
    private Product product;

    private double price;
    private int quantity;
    private int numberOfCarton;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumberOfCarton() {
        return numberOfCarton;
    }

    public void setNumberOfCarton(int numberOfCarton) {
        this.numberOfCarton = numberOfCarton;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", numberOfCarton=" + numberOfCarton +
                '}';
    }
}
