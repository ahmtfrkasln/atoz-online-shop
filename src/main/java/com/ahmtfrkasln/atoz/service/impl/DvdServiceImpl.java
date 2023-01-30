package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.dto.DvdDto;
import com.ahmtfrkasln.atoz.entity.Category;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import com.ahmtfrkasln.atoz.entity.Dvd;
import com.ahmtfrkasln.atoz.repository.CategoryRepository;
import com.ahmtfrkasln.atoz.repository.DvdRepository;
import com.ahmtfrkasln.atoz.service.DvdService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DvdServiceImpl implements DvdService {

    private final DvdRepository dvdRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public DvdServiceImpl(DvdRepository dvdRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.dvdRepository = dvdRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public DvdDto save(DvdDto dvd) {
        Category category = categoryRepository.findByCode(CategoryCode.DVD);
        Dvd dvdToSave = modelMapper.map(dvd, Dvd.class);
        dvdToSave.getProduct().setCategory(category);
        return modelMapper.map(dvdRepository.save(dvdToSave), DvdDto.class);
    }

    @Override
    public DvdDto getByProductId(Long product_id) {
        return modelMapper.map(dvdRepository.findByProductId(product_id), DvdDto.class);
    }

    @Override
    public Page<DvdDto> getAllByPage(Pageable pageable) {
        Page<Dvd> dvds = dvdRepository.findAll(pageable);
        return dvds.map(dvd -> modelMapper.map(dvd, DvdDto.class));
    }
}
