package com.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableCaching
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;



    @Override
    @Cacheable("product")
    public List<Product> getAllProducts() {
        System.out.println("from db");
        return productRepo.findAll();
    }

    @Override
    @Cacheable(key = "#id", value = "Product")
    public Product getProduct(Integer id) {
        System.out.println("From db");
        return productRepo.findById(id).get();
    }

    @Override
    @CacheEvict(key = "#id",value = "Product")
    public void deleteProduct(Integer id) {
        Product product = this.productRepo.findById(id).get();
        productRepo.delete(product);
    }

    @Override
    @CachePut(key="#product.id", value = "Product")
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
}
