package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
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

        return applyDiscounts(new Receipt(receiptEntries));
    }

    private Receipt applyDiscounts(Receipt receipt) {
        var tenPercentDiscount = new TenPercentDiscount();
        var fifteenPercentDiscount = new FifteenPercentDiscount();
        return tenPercentDiscount.apply(fifteenPercentDiscount.apply(receipt));
    }

}
