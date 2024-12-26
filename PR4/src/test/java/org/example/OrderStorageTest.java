package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStorageTest {

    private OrderStorage orderStorage;


    @BeforeEach
    void setUp() {
        orderStorage = new OrderStorage();
    }


    @Test
    void testAddOrderWithValidProduct() {

        Clothing product = Clothing.builder()
                .name("T-shirt")
                .size("M")
                .color("Red")
                .build();


        orderStorage.addOrder(product);

        assertEquals(1, orderStorage.getOrders().size(), "Order should be added to the list."); // Перевірка, що кількість замовлень тепер 1
        assertEquals("T-shirt", orderStorage.getOrders().get(0).getName(), "Product name should be 'T-shirt'."); // Перевірка, що назва продукту правильна
    }


    @Test
    void testAddNullOrder() {

        assertThrows(NullPointerException.class, () -> {
            orderStorage.addOrder(null);
        }, "Adding a null product should throw a NullPointerException.");
    }


    @Test
    void testProcessAllOrdersWithEmptyList() {
        orderStorage.processAllOrders();
        assertTrue(orderStorage.getOrders().isEmpty(), "The orders list should be empty.");
    }

    @Test
    void testAddMultipleOrders() {
        Clothing product1 = Clothing.builder()
                .name("T-shirt")
                .size("M")
                .color("Red")
                .build();

        Electronics product2 = Electronics.builder()
                .name("Laptop")
                .brand("Dell")
                .model("XPS 13")
                .build();

        orderStorage.addOrder(product1);
        orderStorage.addOrder(product2);

        assertEquals(2, orderStorage.getOrders().size(), "There should be two orders."); // Перевірка, що кількість замовлень - 2
        assertEquals("T-shirt", orderStorage.getOrders().get(0).getName(), "First product should be 'T-shirt'."); // Перевірка, що перший продукт - це T-shirt
        assertEquals("Laptop", orderStorage.getOrders().get(1).getName(), "Second product should be 'Laptop'."); // Перевірка, що другий продукт - це Laptop
    }
}
