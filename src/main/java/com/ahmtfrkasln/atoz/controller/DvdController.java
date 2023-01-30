package com.ahmtfrkasln.atoz.controller;

import com.ahmtfrkasln.atoz.dto.DvdDto;
import com.ahmtfrkasln.atoz.service.DvdService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dvd")
public class DvdController {

    private final DvdService dvdService;

    public DvdController(DvdService dvdService) {
        this.dvdService = dvdService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<DvdDto> getByProductId(@PathVariable("id") Long id){
        return ResponseEntity.ok(dvdService.getByProductId(id));
    }

    @GetMapping
    public ResponseEntity<Page<DvdDto>> getAllPaged(Pageable pageable){
        return ResponseEntity.ok(dvdService.getAllByPage(pageable));
    }
}
