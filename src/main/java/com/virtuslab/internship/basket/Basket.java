package com.virtuslab.internship.basket;

import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private final List<Product> products;
    private final Map<Product, Integer> productsAmounts = new HashMap<>();

    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        updateOccurrences(product);
    }

    public Map<Product, Integer> toCumulativeAmountMap() {
        return productsAmounts;
    }

    private void updateOccurrences(Product product) {
        int amount = productsAmounts.getOrDefault(product, 0);
        productsAmounts.put(product, (amount+1));
    }

    public void addAll(List<Product> products) {
        for(Product product : products) {
            this.addProduct(product);
        }
    }

    public Integer getAmountOfProduct(Product product) {
        return productsAmounts.get(product);
    }
}
