package com.ahmtfrkasln.atoz.service;

import com.ahmtfrkasln.atoz.dto.CdDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CdService {
    CdDto save(CdDto cd);
    CdDto getByProductId(Long product_id);
    Page<CdDto> getAllByPage(Pageable pageable);
}
