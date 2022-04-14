package rest.controllers;

import com.virtuslab.internship.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rest.services.BasketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {

    private final BasketService service;

    @GetMapping("")
    public List<Product> get() {
        return service.getAll();
    }

    @GetMapping("/product_name={name}")
    public List<Product> getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping("/product_type={type}")
    public List<Product> getByType(@PathVariable Product.Type type) {
        return service.getByType(type);
    }

    @PostMapping("product_name={name}")
    public Product post(@PathVariable String name) {
        return service.add(name);
    }

    @DeleteMapping("/product_name={name}")
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @DeleteMapping("/product_type={type}")
    public void deleteByType(@PathVariable Product.Type type) {
        service.deleteByType(type);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        service.deleteAll();
    }

}
