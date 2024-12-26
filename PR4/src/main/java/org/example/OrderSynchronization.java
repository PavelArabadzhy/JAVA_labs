package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderSynchronization {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public void processOrders(Product product) {
        executor.submit(() -> {
            OrderProcessor<Product> processor = new OrderProcessor<>(product);
            processor.processOrder();
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
