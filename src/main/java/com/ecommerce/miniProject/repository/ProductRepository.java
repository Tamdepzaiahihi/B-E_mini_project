package com.ecommerce.miniProject.repository;

import com.ecommerce.miniProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
