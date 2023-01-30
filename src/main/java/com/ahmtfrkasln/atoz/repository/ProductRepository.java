package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
