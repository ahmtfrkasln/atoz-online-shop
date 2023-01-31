package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.AtozApplication;
import com.ahmtfrkasln.atoz.dto.BookDto;
import com.ahmtfrkasln.atoz.dto.CartDto;
import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.dto.ProductDto;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AtozApplication.class)
class CartServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private CartServiceImpl cartService;

    @Test
    void addToCart() {
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));
        BookDto bookWillBeSaved = new BookDto(null, "test author1", 150L);
        bookWillBeSaved.setProduct(new ProductDto(null, "test book1", BigDecimal.valueOf(10.55), null));
        BookDto bookHasBeenSaved = bookService.save(bookWillBeSaved);

        CartDto cart = cartService.addToCart(bookHasBeenSaved.getProduct_id());

        assertEquals(bookHasBeenSaved.getTitle(), cart.getTitle());
        assertEquals(bookHasBeenSaved.getCategory(), cart.getCategory());
        assertEquals(bookHasBeenSaved.getNetPrice(), cart.getNetPrice());
        assertEquals(bookHasBeenSaved.getProduct_id(), cart.getProduct_id());
    }

    @Test
    void getCart() {
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));

        int cartCountBefore = cartService.getShoppingCart().getCart().size();

        BookDto bookWillBeSaved = new BookDto(991L, "test author2", 150L);
        bookWillBeSaved.setProduct(new ProductDto(9991L, "test book2", BigDecimal.valueOf(10.55), null));
        BookDto bookHasBeenSaved = bookService.save(bookWillBeSaved);
        cartService.addToCart(bookHasBeenSaved.getProduct_id());

        bookWillBeSaved = new BookDto(992L, "test author3", 150L);
        bookWillBeSaved.setProduct(new ProductDto(9992L, "test book3", BigDecimal.valueOf(10.55), null));
        bookHasBeenSaved = bookService.save(bookWillBeSaved);
        cartService.addToCart(bookHasBeenSaved.getProduct_id());

        int cartCountAfter = cartService.getShoppingCart().getCart().size();

        assertEquals((cartCountBefore + 2), cartCountAfter);
    }
}