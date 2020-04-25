package com.wsecu.userservice.data;

import com.wsecu.userservice.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadData {
    @Bean
    CommandLineRunner initDatabase(UserServiceRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User( "Robin Williams", "rwilliams", "rwilliams@gmail.com")));
            log.info("Preloading " + repository.save(new User("Agatha Christie", "achristie", "achristie@gmail.com")));
            log.info("Preloading " + repository.save(new User("Marcus Aurelius", "maurelius", "maurelius@gmail.com")));
            log.info("Preloading " + repository.save(new User("Nina Simone", "nsimone", "nsimone@gmail.com")));
        };
    }
}
