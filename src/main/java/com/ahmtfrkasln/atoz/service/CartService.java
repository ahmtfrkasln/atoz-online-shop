package com.ahmtfrkasln.atoz.service;

import com.ahmtfrkasln.atoz.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto addToCart(Long product_id);

    List<CartDto> getCart();
}
