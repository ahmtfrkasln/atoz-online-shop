package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.AtozApplication;
import com.ahmtfrkasln.atoz.dto.BookDto;
import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.dto.ProductDto;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AtozApplication.class)
class BookServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private BookServiceImpl bookService;

    @Test
    void save() {
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));

        BookDto bookWillBeSaved = new BookDto(null, "test author1", 150L);
        bookWillBeSaved.setProduct(new ProductDto(null, "test book1", BigDecimal.valueOf(10.55), null));
        BookDto bookHasBeenSaved = bookService.save(bookWillBeSaved);

        assertEquals(bookWillBeSaved.getAuthor(), bookHasBeenSaved.getAuthor());
        assertEquals(bookWillBeSaved.getPages(), bookHasBeenSaved.getPages());
        assertEquals(bookWillBeSaved.getNetPrice(), bookHasBeenSaved.getNetPrice());
        assertEquals("Book", bookHasBeenSaved.getCategory());
        assertEquals(bookWillBeSaved.getTitle(), bookHasBeenSaved.getTitle());
    }

    @Test
    void getByProductId() {
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));

        BookDto bookWillBeSaved = new BookDto(null, "test author2", 150L);
        bookWillBeSaved.setProduct(new ProductDto(null, "test book2", BigDecimal.valueOf(10.55), null));

        BookDto bookHasBeenSaved = bookService.save(bookWillBeSaved);
        BookDto bookByProductID = bookService.getByProductId(bookHasBeenSaved.getProduct_id());

        assertEquals(bookByProductID.getId(), bookHasBeenSaved.getId());
        assertEquals(bookByProductID.getAuthor(), bookHasBeenSaved.getAuthor());
        assertEquals(bookByProductID.getPages(), bookHasBeenSaved.getPages());
        assertEquals(bookByProductID.getNetPrice(), bookHasBeenSaved.getNetPrice());
        assertEquals(bookByProductID.getCategory(), bookHasBeenSaved.getCategory());
        assertEquals(bookByProductID.getTitle(), bookHasBeenSaved.getTitle());
    }

    @Test
    void getAllByPage() {
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));

        long bookCountBefore = bookService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        BookDto book = new BookDto(null, "test author3", 150L);
        book.setProduct(new ProductDto(null, "test book3", BigDecimal.valueOf(10.55), null));
        bookService.save(book);

        long bookCountAfter = bookService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        assertEquals((bookCountBefore + 1), bookCountAfter);
    }
}