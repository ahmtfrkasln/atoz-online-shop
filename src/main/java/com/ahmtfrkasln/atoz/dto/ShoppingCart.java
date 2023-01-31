package com.ahmtfrkasln.atoz.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @Getter
    @Setter
    List<CartDto> cart;

    public String getTotalPrice(){
        double total = 0D;
        for (CartDto item : cart){
            total += item.getNetPrice().doubleValue() * (( 100 + item.getProduct().getCategory().getVat())/100D);
        }
        return String.format("%.2f", total);
    }
}
