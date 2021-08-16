package com.kondratyev.taxiaggregator;

import com.kondratyev.taxiaggregator.controllers.PriceController;
import com.kondratyev.taxiaggregator.controllers.TripController;
import com.kondratyev.taxiaggregator.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaxiAggregatorApplicationTests {

    @Autowired
    PriceController priceController;

    @Autowired
    TripController tripController;

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
        assertThat(priceController).isNotNull();
        assertThat(tripController).isNotNull();
        assertThat(userController).isNotNull();
    }

}
