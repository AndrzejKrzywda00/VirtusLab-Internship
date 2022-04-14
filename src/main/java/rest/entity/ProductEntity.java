package rest.entity;

import com.virtuslab.internship.product.Product;
import lombok.RequiredArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@RequiredArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private BigDecimal price;

    private Product.Type type;

}
