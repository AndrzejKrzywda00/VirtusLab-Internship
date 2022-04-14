package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.ProductDb;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptGeneratorTest {

    @Test
    void shouldGenerateReceiptForGivenBasket() {

        // Given
        var productDb = new ProductDb();
        var cart = new Basket();
        var milk = productDb.findByName("Milk");
        var bread = productDb.findByName("Bread");
        var apple = productDb.findByName("Apple");
        var expectedTotalPrice = milk.price().multiply(BigDecimal.valueOf(2)).add(bread.price()).add(apple.price());

        /*
        2x milk
        1x bread
        1x apple
         */

        cart.addProduct(milk);
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(apple);

        var receiptGenerator = new ReceiptGenerator();

        // When
        var receipt = receiptGenerator.generate(cart);

        // Then
        assertNotNull(receipt);
        assertEquals(3, receipt.entries().size());
        assertEquals(expectedTotalPrice, receipt.totalPrice());
        assertEquals(0, receipt.discounts().size());
    }


    @Test
    void shouldGenerateReceiptForGivenLargerBasket() {

        var productDb = new ProductDb();
        var cart = new Basket();
        var milk = productDb.findByName("Milk");
        var bread = productDb.findByName("Bread");
        var apple = productDb.findByName("Apple");
        var expectedTotalPrice =
                    milk.price().multiply(BigDecimal.valueOf(2))
                .add(bread.price().multiply(BigDecimal.valueOf(5)))
                .add(apple.price().multiply(BigDecimal.valueOf(8)));

        cart.addProduct(milk);
        cart.addProduct(milk);
        for(int i=0; i<5; i++) {
            cart.addProduct(bread);
        }
        for(int j=0; j<8; j++) {
            cart.addProduct(apple);
        }

        var receiptGenerator = new ReceiptGenerator();

        // When
        var receipt = receiptGenerator.generate(cart);

        // Then
        assertNotNull(receipt);
        assertEquals(3, receipt.entries().size());
        assertEquals(expectedTotalPrice, receipt.totalPrice());
        assertEquals(0, receipt.discounts().size());
    }

    // 10% discount scenario
    @Test
    void shouldGenerateReceiptForGivenBasketWithDiscount() {

    }

}
