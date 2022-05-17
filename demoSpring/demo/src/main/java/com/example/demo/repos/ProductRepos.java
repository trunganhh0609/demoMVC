package com.example.demo.repos;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepos extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
