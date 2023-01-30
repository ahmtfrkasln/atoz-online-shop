package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.dto.BookDto;
import com.ahmtfrkasln.atoz.entity.Book;
import com.ahmtfrkasln.atoz.entity.Category;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import com.ahmtfrkasln.atoz.repository.BookRepository;
import com.ahmtfrkasln.atoz.repository.CategoryRepository;
import com.ahmtfrkasln.atoz.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto save(BookDto book) {
        Category category = categoryRepository.findByCode(CategoryCode.BOOK);
        Book bookToSave = modelMapper.map(book, Book.class);
        bookToSave.getProduct().setCategory(category);
        return modelMapper.map(bookRepository.save(bookToSave), BookDto.class);
    }

    @Override
    public BookDto getByProductId(Long product_id) {
        return modelMapper.map(bookRepository.findByProductId(product_id), BookDto.class);
    }

    @Override
    public Page<BookDto> getAllByPage(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(book -> modelMapper.map(book, BookDto.class));
    }
}
