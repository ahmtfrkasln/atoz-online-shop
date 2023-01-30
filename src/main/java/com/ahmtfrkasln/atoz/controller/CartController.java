package com.ahmtfrkasln.atoz.controller;

import com.ahmtfrkasln.atoz.dto.CartDto;
import com.ahmtfrkasln.atoz.service.impl.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public ResponseEntity<List<CartDto>> getCart(){
        return ResponseEntity.ok(cartService.getCart());
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<CartDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(cartService.addToCart(id));
    }
}
