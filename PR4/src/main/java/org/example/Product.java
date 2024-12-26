package org.example;
import lombok.Data;

@Data
public abstract class Product {
    private String name;

    public void validateSize() {
    }

    public void validateModel() {
    }
}
