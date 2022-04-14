# VirtusLab-Internship
This repository holds code for first stage of recruitment process for internship in VirtusLab.
---
1. First task was to make tests not fail. The problem with first test was that the inequality qualifying for the discount activation was inverted. The second problem was with null value of the discounts field in the receipt, I changed it to empty ArrayList declaration. Third problem was with proper generation of Receipt based on list of Products in the basket. I solved this one with HashMap<Product, Integer> which allowed me to keep track of what is in the basket in clean and efficent way. All tests passed, moreover i wrote all necessary additional tests, to try all possible situations that may occurr.

2. Discount system. I wrote new class: FifteenPercentDiscount which works similarly to the TenPercentDiscount class. It implements all required functionality. Again tests where prepared in all scenarios and all of them pass.

3. API. I created Spring Boot app to handle this problem. I built standard layerd architecture for REST-like API and prepared endpoints for easy adding products to basket and generating a receipt. The API looks like this:

Additionally: Product was moved to normal class instead of record to make mapper work correctly.

the basket API:

GET     /basket
GET     /basket/product_name={name}
GET     /basket/product_type={type}
POST    /basket/product_name={name}
DELETE  /basket/product_name={name}
DELETE  /basket/product_type={type}
DELETE  /basket/all

Posting takes data from the preconfigured list of products.
---

the products API:

GET     /products
GET     /products/name={name}
GET     /products/type={type}

Of course methods are readonly.
---

the receipt API:

GET /recepit

Returns generated receipt data.
---

This API mimics the behavior of most online stores. Testing was conducted with use of Insomnia.
