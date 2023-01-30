package com.ahmtfrkasln.atoz.service;

import com.ahmtfrkasln.atoz.dto.DvdDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DvdService {
    DvdDto save(DvdDto dvd);
    DvdDto getByProductId(Long product_id);
    Page<DvdDto> getAllByPage(Pageable pageable);
}
