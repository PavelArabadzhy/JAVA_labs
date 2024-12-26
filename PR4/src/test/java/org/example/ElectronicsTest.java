package org.example;

import org.example.Electronics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElectronicsTest {


    @Test
    public void testElectronicsCreation() {
        Electronics electronics = Electronics.builder()
                .name("Laptop")
                .brand("Dell")
                .model("XPS 13")
                .build();

        assertEquals("Laptop", electronics.getName());
        assertEquals("Dell", electronics.getBrand());
        assertEquals("XPS 13", electronics.getModel());
    }


    @Test
    public void testElectronicsConstructor() {
        Electronics electronics = new Electronics("Smartphone");

        assertEquals("Smartphone", electronics.getName());
    }


    @Test
    public void testElectronicsConstructorWithParams() {
        Electronics electronics = new Electronics("Smartphone", "Samsung", "Galaxy S21");

        assertEquals("Smartphone", electronics.getName());
        assertEquals("Samsung", electronics.getBrand());
        assertEquals("Galaxy S21", electronics.getModel());
    }


    @Test
    public void testValidModel() {
        Electronics electronics = Electronics.builder()
                .name("Laptop")
                .brand("Lenovo")
                .model("ThinkPad X1")
                .build();

        assertDoesNotThrow(electronics::validateModel);
    }

    @Test
    public void testInvalidModel() {
        Electronics electronics = Electronics.builder()
                .name("Laptop")
                .brand("HP")
                .model("")
                .build();


        assertThrows(IllegalArgumentException.class, electronics::validateModel);
    }
}
