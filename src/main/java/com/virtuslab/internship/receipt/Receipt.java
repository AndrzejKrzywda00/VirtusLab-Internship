package com.virtuslab.internship.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @param entries are the products which are present in this receipt
 * @param discounts are all discounts applied
 * @param totalPrice is the calculated total price
 */
public record Receipt(List<ReceiptEntry> entries, List<String> discounts, BigDecimal totalPrice) {

    public Receipt(List<ReceiptEntry> entries) {
        this(entries,
                new ArrayList<>(),
                entries.stream()
                        .map(ReceiptEntry::totalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }
}
