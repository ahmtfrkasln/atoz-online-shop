package com.ahmtfrkasln.atoz.repository;

import com.ahmtfrkasln.atoz.entity.Cd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdRepository extends JpaRepository<Cd, Long> {
    Page<Cd> findAll(Pageable pageable);
    Cd findByProductId(Long product_id);
}
