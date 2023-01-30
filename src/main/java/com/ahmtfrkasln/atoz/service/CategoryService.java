package com.ahmtfrkasln.atoz.service;

import com.ahmtfrkasln.atoz.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto category);
    List<CategoryDto> getAll();
}
