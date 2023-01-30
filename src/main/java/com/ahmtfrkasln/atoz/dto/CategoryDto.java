package com.ahmtfrkasln.atoz.dto;

import com.ahmtfrkasln.atoz.entity.CategoryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private CategoryCode code;
    private String name;
    private Long vat;
}
