package org.example;

import org.example.Clothing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClothingTest {


    @Test
    public void testClothingCreation() {

        Clothing clothing = Clothing.builder()
                .name("T-Shirt")
                .size("M")
                .color("Red")
                .build();

        assertEquals("T-Shirt", clothing.getName());
        assertEquals("M", clothing.getSize());
        assertEquals("Red", clothing.getColor());
    }

    @Test
    public void testValidSize() {
        Clothing clothing = Clothing.builder()
                .name("T-Shirt")
                .size("M")
                .color("Blue")
                .build();

        assertDoesNotThrow(clothing::validateSize);
    }

    @Test
    public void testInvalidSize() {
        Clothing clothing = Clothing.builder()
                .name("T-Shirt")
                .size("XL")
                .color("Green")
                .build();


        assertThrows(IllegalArgumentException.class, clothing::validateSize);
    }
}
