package com.ahmtfrkasln.atoz.service.impl;

import com.ahmtfrkasln.atoz.AtozApplication;
import com.ahmtfrkasln.atoz.dto.CategoryDto;
import com.ahmtfrkasln.atoz.dto.CdDto;
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
class CdServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private CdServiceImpl cdService;

    @Test
    void save() {
        categoryService.save(new CategoryDto(CategoryCode.CD, "CD", 19L));

        CdDto cdWillBeSaved = new CdDto(null, "test artist1", 10L);
        cdWillBeSaved.setProduct(new ProductDto(null, "test cd1", BigDecimal.valueOf(100), null));
        CdDto cdHasBeenSaved = cdService.save(cdWillBeSaved);

        assertEquals(cdWillBeSaved.getArtist(), cdHasBeenSaved.getArtist());
        assertEquals(cdWillBeSaved.getTracksCount(), cdHasBeenSaved.getTracksCount());
        assertEquals(cdWillBeSaved.getNetPrice(), cdHasBeenSaved.getNetPrice());
        assertEquals("CD", cdHasBeenSaved.getCategory());
        assertEquals(cdWillBeSaved.getTitle(), cdHasBeenSaved.getTitle());
    }

    @Test
    void getByProductId() {
        categoryService.save(new CategoryDto(CategoryCode.CD, "CD", 19L));

        CdDto cdWillBeSaved = new CdDto(null, "test artist2", 10L);
        cdWillBeSaved.setProduct(new ProductDto(null, "test cd2", BigDecimal.valueOf(100), null));

        CdDto cdHasBeenSaved = cdService.save(cdWillBeSaved);
        CdDto cdByProductID = cdService.getByProductId(cdHasBeenSaved.getProduct_id());

        assertEquals(cdByProductID.getId(), cdHasBeenSaved.getId());
        assertEquals(cdByProductID.getArtist(), cdHasBeenSaved.getArtist());
        assertEquals(cdByProductID.getTracksCount(), cdHasBeenSaved.getTracksCount());
        assertEquals(cdByProductID.getNetPrice().longValue(), cdHasBeenSaved.getNetPrice().longValue());
        assertEquals(cdByProductID.getCategory(), cdHasBeenSaved.getCategory());
        assertEquals(cdByProductID.getTitle(), cdHasBeenSaved.getTitle());
    }

    @Test
    void getAllByPage() {
        categoryService.save(new CategoryDto(CategoryCode.CD, "CD", 19L));

        long cdCountBefore = cdService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        CdDto cdWillBeSaved = new CdDto(null, "test artist3", 10L);
        cdWillBeSaved.setProduct(new ProductDto(null, "test cd3", BigDecimal.valueOf(100), null));
        cdService.save(cdWillBeSaved);

        long cdCountAfter = cdService.getAllByPage(PageRequest.ofSize(10)).getTotalElements();

        assertEquals((cdCountBefore + 1), cdCountAfter);
    }
}