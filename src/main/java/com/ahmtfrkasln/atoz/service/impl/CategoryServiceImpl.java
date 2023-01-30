package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.entity.Category;
import com.ahmtfrkasln.atoz.repository.CategoryRepository;
import com.ahmtfrkasln.atoz.service.CategoryService;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto save(CategoryDto category) {
        Category categoryToSave = modelMapper.map(category, Category.class);
        Category categoryDb = categoryRepository.findByCode(category.getCode());
        if (categoryDb != null){
            categoryToSave.setId(categoryDb.getId());
        }
        categoryDb = categoryRepository.save(categoryToSave);
        return modelMapper.map(categoryDb, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        return modelMapper.map(categoryRepository.findAll(), new TypeToken<List<CategoryDto>>(){}.getType());
    }
}
