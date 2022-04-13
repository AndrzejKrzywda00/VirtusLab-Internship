package com.virtuslab.internship.discount;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;
import java.math.BigDecimal;

public class FifteenPercentDiscount {

    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if(shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            System.out.println(totalPrice);
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean isAmountOfGrainProductsEvenOrGreaterThanThree(Receipt receipt) {

        int amountOfGrainProducts = 0;

        for(ReceiptEntry entry : receipt.entries()) {
            if(entry.product().type() == Product.Type.GRAINS) {
                amountOfGrainProducts += entry.quantity();
            }
        }

        return amountOfGrainProducts >= 3;
    }

    private boolean shouldApply(Receipt receipt) {
        return !isTenPercentApplied(receipt) && isAmountOfGrainProductsEvenOrGreaterThanThree(receipt);
    }

    private boolean isTenPercentApplied(Receipt receipt) {
        return receipt.discounts().contains(TenPercentDiscount.NAME);
    }

}
