package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.AtozApplication;
import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AtozApplication.class)
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void testSave() {
        CategoryDto dtoWillBeSaved = new CategoryDto(CategoryCode.CD, "CD", 19L);
        CategoryDto dtoHasBeenSaved = categoryService.save(dtoWillBeSaved);
        assertEquals(dtoWillBeSaved.getCode(), dtoHasBeenSaved.getCode());
        assertEquals(dtoWillBeSaved.getName(), dtoHasBeenSaved.getName());
        assertEquals(dtoWillBeSaved.getVat(), dtoHasBeenSaved.getVat());
    }

    @Test
    void testGetAll() {
        categoryService.save(new CategoryDto(CategoryCode.CD, "CD", 19L)); //CD will be updated
        categoryService.save(new CategoryDto(CategoryCode.DVD, "DVD", 19L));
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));

        assertEquals(3, categoryService.getAll().size());
    }
}