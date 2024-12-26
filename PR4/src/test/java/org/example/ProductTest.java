package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductName() {
        Product product = new Electronics("Laptop");

        assertEquals("Laptop", product.getName());
    }
}
