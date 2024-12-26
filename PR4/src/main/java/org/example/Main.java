package org.example;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Electronics electronics = Electronics.builder()
                .name(faker.commerce().productName())
                .brand(faker.company().name())
                .model(faker.code().ean8())
                .build();

        Clothing clothing = Clothing.builder()
                .name(faker.commerce().productName())
                .size(faker.number().digit())
                .color(faker.color().name())
                .build();

        System.out.println("Electronics: " + electronics);
        System.out.println("Clothing: " + clothing);
    }
}
