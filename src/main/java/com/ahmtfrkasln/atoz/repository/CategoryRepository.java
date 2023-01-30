package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Category;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category findByCode(CategoryCode code);
}
