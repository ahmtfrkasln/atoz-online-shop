package com.ahmtfrkasln.atoz.controller;

import com.ahmtfrkasln.atoz.dto.CartDto;
import com.ahmtfrkasln.atoz.dto.ProductDto;
import com.ahmtfrkasln.atoz.dto.ShoppingCart;
import com.ahmtfrkasln.atoz.service.impl.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public ResponseEntity<ShoppingCart> getCart(){
        return ResponseEntity.ok(cartService.getShoppingCart());
    }

    @PostMapping("/add")
    public ResponseEntity<CartDto> getById(@RequestBody ProductDto product){
        return ResponseEntity.ok(cartService.addToCart(product.getId()));
    }
}
