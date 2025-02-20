package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private List<Product> products;
    private double totalPrice;
    private String status;

    public Order(Cart cart) {
        this.products = List.copyOf(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
        this.status = "Нове";
    }
}