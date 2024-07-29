package dev.galasso.marketApp.service.impl;

import dev.galasso.marketApp.model.Product;
import dev.galasso.marketApp.repository.ProductRepository;
import dev.galasso.marketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return (repository.save(product));
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public Product alterProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductByKeyWord(String keyWord) {
        return null;
    }
}
