package com.virtuslab.internship.discount;

import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FifteenPercentDiscountTest {

    @Test
    void shouldNotApply15PercentDiscountWhenTooFewGrainProducts() {

        // Given
        var productDb = new ProductDb();
        var potato = productDb.findByName("Potato");
        var banana = productDb.findByName("Banana");
        var butter = productDb.findByName("Butter");
        var bread = productDb.findByName("Bread");

        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(potato, 10));
        receiptEntries.add(new ReceiptEntry(banana, 15));
        receiptEntries.add(new ReceiptEntry(butter, 2));
        receiptEntries.add(new ReceiptEntry(bread, 2));

        var receipt = new Receipt(receiptEntries);
        var fifteenPercentDiscount = new FifteenPercentDiscount();
        var tenPercentDiscount = new TenPercentDiscount();
        var expectedTotalPrice =
                        potato.price().multiply(BigDecimal.valueOf(10))
                        .add(banana.price().multiply(BigDecimal.valueOf(15)))
                        .add(butter.price().multiply(BigDecimal.valueOf(2)))
                        .add(bread.price().multiply(BigDecimal.valueOf(2)))
                        .multiply(BigDecimal.valueOf(0.9));

        // When
        var receiptAfterDiscount = tenPercentDiscount.apply(fifteenPercentDiscount.apply(receipt));

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldOnlyApply15PercentDiscount() {

        /*
        This scenario is as follows:
        Total price is greater than 50
        But 15% discount applies and falls below 50
        So the only remaining discount is 15%
         */

        // Given
        var productDb = new ProductDb();
        var bread = productDb.findByName("Bread");
        var cereals = productDb.findByName("Cereals");

        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 6));
        receiptEntries.add(new ReceiptEntry(cereals, 3));

        var receipt = new Receipt(receiptEntries);
        var fifteenPercentDiscount = new FifteenPercentDiscount();
        var tenPercentDiscount = new TenPercentDiscount();
        var expectedTotalPrice =
                    cereals.price().multiply(BigDecimal.valueOf(3))
                    .add(bread.price().multiply(BigDecimal.valueOf(6)))
                    .multiply(BigDecimal.valueOf(0.85));

        // When
        var receiptAfterDiscount = tenPercentDiscount.apply(fifteenPercentDiscount.apply(receipt));

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());

    }

    @Test
    void shouldApplyBothDiscounts() {

        var productDb = new ProductDb();
        var bread = productDb.findByName("Bread");
        var cereals = productDb.findByName("Cereals");

        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 10));
        receiptEntries.add(new ReceiptEntry(cereals, 15));

        var receipt = new Receipt(receiptEntries);
        var fifteenPercentDiscount = new FifteenPercentDiscount();
        var tenPercentDiscount = new TenPercentDiscount();
        var expectedTotalPrice =
                cereals.price().multiply(BigDecimal.valueOf(15))
                        .add(bread.price().multiply(BigDecimal.valueOf(10)))
                        .multiply(BigDecimal.valueOf(0.85))
                        .multiply(BigDecimal.valueOf(0.9));

        // When
        var receiptAfterDiscount = tenPercentDiscount.apply(fifteenPercentDiscount.apply(receipt));

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(2, receiptAfterDiscount.discounts().size());
    }

}
