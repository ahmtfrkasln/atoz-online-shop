package com.ahmtfrkasln.atoz.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class CartDto extends ProductJson {
    @Getter
    @Setter
    private Long id;
}
