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
        final double[] total = {0D};
        cart.forEach(item -> total[0] += Double.valueOf(item.getPrice()));
        return total[0] + "";
    }
}
