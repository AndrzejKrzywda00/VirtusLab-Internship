package rest.services;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import org.hibernate.dialect.PointbaseDialect;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public record ProductService() {

    private static final ProductDb repository = new ProductDb();

    // ----- GET ------

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getByName(String name) {
        return repository.findByName(name);
    }

    // ----- SET ------

    public Product add(Product product) {
        if(validateProduct(product)) {
           repository.save(product);
        }
        return product;
    }

    public List<Product> resetDatabase() {
        return repository.restoreAndReturnData();
    }

    // ----- DELETE ------

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(String name) {
        repository.deleteByName(name);
    }


    private boolean validateProduct(Product product) {
        // TODO -- make this throw exception
        return product.price().compareTo(BigDecimal.ZERO) > 0 && product.name().length() > 0 && product.type() != null;
    }

}
