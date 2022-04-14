package rest.services;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rest.entity.ProductEntity;
import rest.repositories.BasketRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public record BasketService(ModelMapper mapper, BasketRepository repository) {

    private static final ProductDb productsDb = new ProductDb();

    // ------ GET ------

    public List<Product> getAll() {
        return repository.findAll().stream().map(productEntity -> mapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }

    public List<Product> getByName(String name) {
        return repository.getByName(name).stream().map(productEntity -> mapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }

    public List<Product> getByType(Product.Type type) {
        return repository.getByType(type).stream().map(productEntity -> mapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }


    // ------ POST ------

    public Product add(String name) {
        var product = productsDb.findByName(name);
        ProductEntity productEntity = repository.save(mapper.map(product, ProductEntity.class));
        return mapper.map(productEntity, Product.class);
    }


    // ------ DELETE ------

    public void deleteAll() {
        var product = new Product();
        repository.deleteAll();
    }

    public void deleteByType(Product.Type type) {
        repository.deleteByType(type);
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

}
