package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product findById(Integer id);

    Product alterProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getAllProducts();

    List<Product> getProductByKeyWord(String keyWord);
}
