package com.tts.ecomspring.service;

import com.tts.ecomspring.model.Product;
import com.tts.ecomspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public List<String> findDistinctBrands(){
        return productRepository.findDistinctBrands();
    }

    public List<String> findDistinctCategories(){
        return productRepository.findDistinctCategories();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByBrandAndOrCategory(String brand, String category) {
        if (category == null && brand == null)
            return productRepository.findAll();
        else if (category == null)
            return productRepository.findByBrand(brand);
        else if(brand == null)
            return productRepository.findByCategory(category);
        else
            return productRepository.findByBrandAndOrCategory(brand, category);
    }
}
