package rest.services;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rest.repositories.ProductRepository;
import java.util.List;

@Service
public record ReceiptService(ModelMapper mapper, ProductRepository repository) {

    static ReceiptGenerator generator = new ReceiptGenerator();

    // ------ GET ------

    public Receipt get() {
        Basket basket = new Basket();
        List<Product> products = repository.findAll().stream().map(productEntity -> mapper.map(productEntity, Product.class)).toList();
        basket.addAll(products);
        return generator.generate(basket);
    }

}
