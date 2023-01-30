package com.ahmtfrkasln.atoz.initializer;

import com.ahmtfrkasln.atoz.dto.*;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import com.ahmtfrkasln.atoz.service.CdService;
import com.ahmtfrkasln.atoz.service.DvdService;
import com.ahmtfrkasln.atoz.service.impl.BookServiceImpl;
import com.ahmtfrkasln.atoz.service.impl.CategoryServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements ApplicationRunner {

    private final CategoryServiceImpl categoryService;
    private final BookServiceImpl bookService;
    private final CdService cdService;
    private final DvdService dvdService;

    public DataInitializer(CategoryServiceImpl categoryService, BookServiceImpl bookService, CdService cdService, DvdService dvdService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.cdService = cdService;
        this.dvdService = dvdService;
    }

    public void run(ApplicationArguments args){
        saveCategories();
        saveBooks();
        saveCds();
        saveDvds();
    }

    private void saveCategories(){
        categoryService.save(new CategoryDto(CategoryCode.CD, "CD", 19L));
        categoryService.save(new CategoryDto(CategoryCode.DVD, "DVD", 19L));
        categoryService.save(new CategoryDto(CategoryCode.BOOK, "Book", 7L));
    }

    private void saveBooks(){
        BookDto book = new BookDto(null, "J.R.R. Tolkien", 150L);
        book.setProduct(new ProductDto(null, "Lord Of The Rings", BigDecimal.valueOf(10.55), null));
        bookService.save(book);

        book = new BookDto(null, "Stephen Hawking", 150L);
        book.setProduct(new ProductDto(null, "Theory of Everything", BigDecimal.valueOf(13.99), null));
        bookService.save(book);
    }

    private void saveCds(){
        CdDto cd = new CdDto(null, "Sia", 11L);
        cd.setProduct(new ProductDto(null, "This is Acting", BigDecimal.valueOf(8.35), null));
        cdService.save(cd);

        cd = new CdDto(null, "Adele", 9L);
        cd.setProduct(new ProductDto(null, "Hello", BigDecimal.valueOf(7.99), null));
        cdService.save(cd);
    }

    private void saveDvds(){
        DvdDto dvd = new DvdDto(null, 135L);
        dvd.setProduct(new ProductDto(null, "Edge of Tomorrow", BigDecimal.valueOf(5.55), null));
        dvdService.save(dvd);

        dvd = new DvdDto(null, 120L);
        dvd.setProduct(new ProductDto(null, "Logan", BigDecimal.valueOf(5.55), null));
        dvdService.save(dvd);

        dvd = new DvdDto(null, 145L);
        dvd.setProduct(new ProductDto(null, "Interstellar", BigDecimal.valueOf(5.55), null));
        dvdService.save(dvd);
    }
}
