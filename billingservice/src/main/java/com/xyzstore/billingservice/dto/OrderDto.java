package com.xyzstore.billingservice.dto;

import lombok.Data;

@Data
public class OrderDto {
    long productId;
    int quantity;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
