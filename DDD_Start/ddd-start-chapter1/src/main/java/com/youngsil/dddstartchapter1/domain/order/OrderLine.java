package com.youngsil.dddstartchapter1.domain.order;

import lombok.Getter;

@Getter
public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return this.price * this.quantity;
    }
}
