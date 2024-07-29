package dev.galasso.marketApp.controller;

import dev.galasso.marketApp.model.Product;
import dev.galasso.marketApp.repository.ProductRepository;
import dev.galasso.marketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> createNew(@RequestBody Product newProduct) {
        Product prod = service.createProduct(newProduct);
        if (prod != null) {
            return ResponseEntity.status(201).body(prod);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = service.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getAllByKeyWord(@RequestParam(name = "k") String keyWord) {
        return ResponseEntity.ok(service.getProductByKeyWord(keyWord));
    }
}
