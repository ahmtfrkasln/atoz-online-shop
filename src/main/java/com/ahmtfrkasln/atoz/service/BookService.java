package com.ahmtfrkasln.atoz.service;

import com.ahmtfrkasln.atoz.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(BookDto book);
    BookDto getByProductId(Long product_id);
    Page<BookDto> getAllByPage(Pageable pageable);
}
