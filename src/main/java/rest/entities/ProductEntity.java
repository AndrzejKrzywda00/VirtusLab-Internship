package rest.entities;

import com.virtuslab.internship.product.Product;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

/*
Now make product entity somehow point to just normal class
or idk make it work nice
 */

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal price;

    private Product.Type type;
}
