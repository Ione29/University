package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice) {
        if (category != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryAndPriceBetween(category, minPrice, maxPrice);
        } else if (category != null) {
            return productRepository.findByCategory(category);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        } else {
            return findAll();
        }
    }
}