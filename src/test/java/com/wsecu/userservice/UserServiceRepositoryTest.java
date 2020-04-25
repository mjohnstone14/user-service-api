package com.wsecu.userservice;

import com.wsecu.userservice.data.UserServiceRepository;
import com.wsecu.userservice.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserServiceRepositoryTest {
    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private UserServiceRepository userRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(userRepository).isNotNull();
    }

    @Test
    void saveUserToDatabase() {
        User user = new User("Stanley", "testStanley", "stanley@test.com");
        userRepository.save(user);
        assertThat(userRepository.findAll()).isNotNull();
    }

    @Test
    void getTheUserByUsername() {
        User user = new User("Stanley", "testStanley", "stanley@test.com");
        userRepository.save(user);
        assertThat(userRepository.findByUserName("testStanley")).isNotNull();
    }

    @Test
    void getTheUserByEmail() {
        User user = new User("Stanley", "testStanley", "stanley@test.com");
        userRepository.save(user);
        assertThat(userRepository.findByEmail("stanley@test.com")).isNotNull();
    }

    @Test
    void removeUser() {
        User user = new User("Stanley", "testStanley", "stanley@test.com");
        userRepository.save(user);
        assertThat(userRepository.findByEmail("stanley@test.com")).isNotNull();
        userRepository.delete(user);
        assertThat(userRepository.findByEmail("stanley@test.com")).isNull();
    }
}
