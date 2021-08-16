package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PriceRepositoryIT {

    @Autowired
    PriceRepository priceRepository;

    final Long priceId = 2921215L;
    final int amount = 352;

    @BeforeEach
    void setUp() {
        Price price = new Price();
        price.setPriceId(priceId);
        price.setPrice(amount);
        priceRepository.save(price);
    }

    @Test
    void findByPriceId() {
        Optional<Price> priceOptional = priceRepository.findByPriceId(priceId);
        assertTrue(priceOptional.isPresent());
        assertEquals(amount, priceOptional.get().getPrice());
    }
}