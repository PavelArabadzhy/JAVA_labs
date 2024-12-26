package org.example;

public class OrderProcessor<T extends Product> {
    private final T product;


    public OrderProcessor(T product) {
        this.product = product;
    }

    // обробка замовлення
    public void processOrder() {
        if (product != null) {
            System.out.println("Processing order for: " + product.getName());
        } else {
            System.err.println("Error: Product is null!");
        }
    }
}
