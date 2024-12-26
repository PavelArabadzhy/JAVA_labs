package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderSynchronizationTest {

    @Test
    public void testProcessOrdersInThread() {
        OrderSynchronization orderSynchronization = new OrderSynchronization();

        Product product = new Electronics("Laptop", "Dell", "XPS-13");

        assertDoesNotThrow(() -> orderSynchronization.processOrders(product));

        orderSynchronization.shutdown();
    }
}
