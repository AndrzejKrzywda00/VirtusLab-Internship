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

    @PostMapping("")
    public Product add(@RequestBody Product product) {
        return service.add(product);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

}
