package com.ahmtfrkasln.atoz.controller;

import com.ahmtfrkasln.atoz.dto.CdDto;
import com.ahmtfrkasln.atoz.service.CdService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cd")
public class CdController {

    private final CdService cdService;

    public CdController(CdService cdService) {
        this.cdService = cdService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<CdDto> getByProductId(@PathVariable("id") Long id){
        return ResponseEntity.ok(cdService.getByProductId(id));
    }

    @GetMapping
    public ResponseEntity<Page<CdDto>> getAllPaged(Pageable pageable){
        return ResponseEntity.ok(cdService.getAllByPage(pageable));
    }
}
