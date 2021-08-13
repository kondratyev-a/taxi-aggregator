package com.kondratyev.taxiaggregator.bootstrap;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.PriceLevel;
import com.kondratyev.taxiaggregator.domain.User;
import com.kondratyev.taxiaggregator.repositories.LocationRepository;
import com.kondratyev.taxiaggregator.repositories.PriceRepository;
import com.kondratyev.taxiaggregator.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final PriceRepository priceRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public DataLoader(PriceRepository priceRepository, LocationRepository locationRepository, UserRepository userRepository) {
        this.priceRepository = priceRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (priceRepository.findAll().isEmpty()) {
            loadPrices();
        }
    }

    private void loadPrices() {

        // Users
        log.debug("Starting loading users");

        User ivan = new User();
        ivan.setName("Иван Петров");
        User savedIvan = userRepository.save(ivan);

        User petr = new User();
        ivan.setName("Петр Иванов");
        User savedPetr = userRepository.save(petr);

        log.debug("Users loaded");

        // Locations
        log.debug("Starting loading location");

        Location pererva = new Location(55.6653078,37.7595318);
        Location savedPererva = locationRepository.save(pererva);

        Location kremlin = new Location(55.7520233,37.5824805);
        Location savedKremlin = locationRepository.save(kremlin);

        log.debug("Locations loaded");

        // Prices
        log.debug("Starting loading prices");

        Price goThere = new Price(154, savedPererva, savedKremlin, PriceLevel.ECONOMY);
        Price goBack = new Price(398, savedKremlin, savedPererva, PriceLevel.PREMIUM);

        priceRepository.save(goThere);
        priceRepository.save(goBack);

        log.debug("Prices loaded");

    }

}