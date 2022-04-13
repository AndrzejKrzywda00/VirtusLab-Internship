package rest.services;

import com.virtuslab.internship.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rest.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record ProductService(ModelMapper mapper, ProductRepository repository) {

    public List<Product> getAll() {
        return repository.findAll().stream().map(productEntity -> mapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
