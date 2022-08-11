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
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_order_map",
            joinColumns = @JoinColumn(
                    name = "bill_id",
                    referencedColumnName = "billId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "orderId"
            )
    )
    private List<Order> orders;
    private double totalAmount;
    private boolean eligibleDiscount;
    private double discount;

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", orders=" + orders +
                ", totalAmount=" + totalAmount +
                ", eligibleDiscount=" + eligibleDiscount +
                ", discount=" + discount +
                '}';
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isEligibleDiscount() {
        return eligibleDiscount;
    }

    public void setEligibleDiscount(boolean eligibleDiscount) {
        this.eligibleDiscount = eligibleDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
