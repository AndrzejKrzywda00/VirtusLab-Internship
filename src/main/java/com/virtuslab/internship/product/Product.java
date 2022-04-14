package com.virtuslab.internship.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    private String name;
    private Type type;
    private BigDecimal price;

    public enum Type {
        DAIRY, FRUITS, VEGETABLES, MEAT, GRAINS
    }

    public Type type() {
        return type;
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }

}
