package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAll();
}
