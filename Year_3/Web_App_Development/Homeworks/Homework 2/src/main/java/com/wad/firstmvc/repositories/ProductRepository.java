package com.wad.firstmvc.repositories;
import com.wad.firstmvc.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);

}
