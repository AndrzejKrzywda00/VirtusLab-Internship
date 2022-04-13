package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        return mapBasketToReceipt(basket);
    }

    private Receipt mapBasketToReceipt(Basket basket) {

        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        for(Map.Entry<Product, Integer> element : basket.toCumulativeAmountMap().entrySet()) {
            receiptEntries.add(new ReceiptEntry(element.getKey(), basket.getAmountOfProduct(element.getKey())));
        }

        return new Receipt(receiptEntries);
    }

}
