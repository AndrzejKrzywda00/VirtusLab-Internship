package rest.services;

import com.virtuslab.internship.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rest.entities.ProductEntity;
import rest.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public record ProductService(ModelMapper mapper, ProductRepository repository) {

    // GET

    public List<Product> getAll() {
        return repository.findAll().stream().map(productEntity -> mapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }

    // POST

    public Product add(Product product) {
        if(validateProduct(product)) {
            ProductEntity productEntity = repository.save(mapper.map(product, ProductEntity.class));
        }
        // TODO -- fix this
        return product;
    }

    // DELETE

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    private boolean validateProduct(Product product) {
        return product.price().compareTo(BigDecimal.ZERO) > 0 && product.name().length() > 0 && product.type() != null;
    }

}
