package rest.services;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public record ProductService() {

    private static final ProductDb repository = new ProductDb();

    // ------ GET ------

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> getByType(Product.Type type) {
        return repository.findByType(type);
    }

}
