package rest.repositories;

import com.virtuslab.internship.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.ProductEntity;

import java.util.List;

public interface BasketRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> getByName(String name);
    List<ProductEntity> getByType(Product.Type type);
    void deleteByName(String name);
    void deleteByType(Product.Type type);
}
