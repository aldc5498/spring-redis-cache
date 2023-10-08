package com.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@EnableCaching
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

}
