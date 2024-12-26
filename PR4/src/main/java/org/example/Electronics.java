package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Electronics extends Product {
    private String name;
    private String brand;
    private String model;

    public Electronics(String name) {
        this.name = name;
    }

    public Electronics(String name, String brand, String model) {
        this.name = name;
        this.brand = brand;
        this.model = model;
    }

    public void validateModel() {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
    }
}
