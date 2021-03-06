package rest.controllers;

import com.virtuslab.internship.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rest.services.ProductService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/name={name}")
    public Product getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping("/type={type}")
    public List<Product> getByType(@PathVariable Product.Type type) {
        return service.getByType(type);
    }

}
