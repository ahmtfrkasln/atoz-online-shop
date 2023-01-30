package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
    Book findByProductId(Long product_id);
}
