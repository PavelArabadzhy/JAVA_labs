package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Clothing extends Product {
    private String name;
    private String size;
    private String color;

    public void validateSize() {
        if (!(size.equals("S") || size.equals("M") || size.equals("L"))) {
            throw new IllegalArgumentException("Invalid size");
        }
    }
}
