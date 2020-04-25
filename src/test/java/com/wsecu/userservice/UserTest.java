package com.wsecu.userservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsecu.userservice.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    @DisplayName("Validate User to JsonNode transformation")
    void shouldGetJsonNodeFromUser() throws Exception {
        Logger log = LoggerFactory.getLogger(UserTest.class) ;
        ObjectMapper mapper = new ObjectMapper();
        log.info("Running: Validate user to json node transformation at {}", new Date());

        User user = new User("James", "jwilliams", "jameswilliams@gmail.com");
        JsonNode node = mapper.valueToTree(user);
        assertAll("user",
                () -> assertEquals("James", node.get("name").textValue(), "Should get the name"),
                () -> assertEquals("jwilliams", node.get("userName").textValue(), "Should get userName"),
                () -> assertEquals("jameswilliams@gmail.com", node.get("email").textValue(), "Should get email")
                );
    }
}
