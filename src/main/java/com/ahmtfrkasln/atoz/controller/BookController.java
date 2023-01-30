package com.ahmtfrkasln.atoz.controller;

import com.ahmtfrkasln.atoz.dto.BookDto;
import com.ahmtfrkasln.atoz.service.impl.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<BookDto> getByProductId(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getByProductId(id));
    }

    @GetMapping
    public ResponseEntity<Page<BookDto>> getAllPaged(Pageable pageable){
        return ResponseEntity.ok(bookService.getAllByPage(pageable));
    }
}
