package com.example.redis;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(Integer id) ;

    void deleteProduct(Integer id);

    Product saveProduct(Product product);

}
