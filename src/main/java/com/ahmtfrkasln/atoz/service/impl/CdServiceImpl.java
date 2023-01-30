package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.dto.CdDto;
import com.ahmtfrkasln.atoz.entity.Category;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import com.ahmtfrkasln.atoz.entity.Cd;
import com.ahmtfrkasln.atoz.repository.CategoryRepository;
import com.ahmtfrkasln.atoz.repository.CdRepository;
import com.ahmtfrkasln.atoz.service.CdService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CdServiceImpl implements CdService {

    private final CdRepository cdRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CdServiceImpl(CdRepository cdRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.cdRepository = cdRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CdDto save(CdDto cd) {
        Category category = categoryRepository.findByCode(CategoryCode.CD);
        Cd cdToSave = modelMapper.map(cd, Cd.class);
        cdToSave.getProduct().setCategory(category);
        return modelMapper.map(cdRepository.save(cdToSave), CdDto.class);
    }

    @Override
    public CdDto getByProductId(Long product_id) {
        return modelMapper.map(cdRepository.findByProductId(product_id), CdDto.class);
    }

    @Override
    public Page<CdDto> getAllByPage(Pageable pageable) {
        Page<Cd> cds = cdRepository.findAll(pageable);
        return cds.map(cd -> modelMapper.map(cd, CdDto.class));
    }
}
