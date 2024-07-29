package dev.galasso.marketApp.repository;

import dev.galasso.marketApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findAllByNameContaining(String keyWord);
}
