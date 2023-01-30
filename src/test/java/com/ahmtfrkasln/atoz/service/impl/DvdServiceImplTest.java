package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.AtozApplication;
import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.dto.DvdDto;
import com.ahmtfrkasln.atoz.dto.ProductDto;
import com.ahmtfrkasln.atoz.entity.CategoryCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AtozApplication.class)
class DvdServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private DvdServiceImpl dvdService;

    @Test
    void save() {
        categoryService.save(new CategoryDto(CategoryCode.DVD, "DVD", 19L));

        DvdDto dvdWillBeSaved = new DvdDto(null, 135L);
        dvdWillBeSaved.setProduct(new ProductDto(null, "Test DVD1", BigDecimal.valueOf(5.55), null));
        DvdDto dvdHasBeenSaved = dvdService.save(dvdWillBeSaved);

        assertEquals(dvdWillBeSaved.getRunTime(), dvdHasBeenSaved.getRunTime());
        assertEquals(dvdWillBeSaved.getNetPrice(), dvdHasBeenSaved.getNetPrice());
        assertEquals("DVD", dvdHasBeenSaved.getCategory());
        assertEquals(dvdWillBeSaved.getTitle(), dvdHasBeenSaved.getTitle());
    }

    @Test
    void getByProductId() {
        categoryService.save(new CategoryDto(CategoryCode.DVD, "DVD", 19L));

        DvdDto dvdWillBeSaved = new DvdDto(null, 135L);
        dvdWillBeSaved.setProduct(new ProductDto(null, "Test DVD2", BigDecimal.valueOf(8.55), null));

        DvdDto dvdHasBeenSaved = dvdService.save(dvdWillBeSaved);
        DvdDto dvdByProductID = dvdService.getByProductId(dvdHasBeenSaved.getProduct_id());

        assertEquals(dvdByProductID.getId(), dvdHasBeenSaved.getId());
        assertEquals(dvdByProductID.getRunTime(), dvdHasBeenSaved.getRunTime());
        assertEquals(dvdByProductID.getNetPrice(), dvdHasBeenSaved.getNetPrice());
        assertEquals(dvdByProductID.getCategory(), dvdHasBeenSaved.getCategory());
        assertEquals(dvdByProductID.getTitle(), dvdHasBeenSaved.getTitle());
    }

    @Test
    void getAllByPage() {
        categoryService.save(new CategoryDto(CategoryCode.DVD, "DVD", 19L));

        long dvdCountBefore = dvdService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        DvdDto dvdWillBeSaved = new DvdDto(null, 135L);
        dvdWillBeSaved.setProduct(new ProductDto(null, "Test DVD3", BigDecimal.valueOf(5.55), null));
        dvdService.save(dvdWillBeSaved);

        long dvdCountAfter = dvdService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        assertEquals((dvdCountBefore + 1), dvdCountAfter);
    }
}