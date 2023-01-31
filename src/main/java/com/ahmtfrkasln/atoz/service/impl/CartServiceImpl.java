package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.dto.CartDto;
import com.ahmtfrkasln.atoz.dto.ShoppingCart;
import com.ahmtfrkasln.atoz.entity.Cart;
import com.ahmtfrkasln.atoz.entity.Product;
import com.ahmtfrkasln.atoz.repository.CartRepository;
import com.ahmtfrkasln.atoz.repository.ProductRepository;
import com.ahmtfrkasln.atoz.service.CartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CartDto addToCart(Long product_id) {
        Product product = productRepository.findById(product_id).orElseThrow();
        Cart cart = cartRepository.save(new Cart(null, product));
        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(modelMapper.map(cartRepository.findAll(), new TypeToken<List<CartDto>>(){}.getType()));
    }
}
