package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Dvd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
    Page<Dvd> findAll(Pageable pageable);
    Dvd findByProductId(Long product_id);
}
