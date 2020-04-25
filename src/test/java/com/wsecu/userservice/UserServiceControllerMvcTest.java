package com.wsecu.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsecu.userservice.controller.UserServiceController;
import com.wsecu.userservice.data.UserServiceRepository;
import com.wsecu.userservice.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserServiceRepository userRepository;

    @InjectMocks
    private UserServiceController controller;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
        userRepository.save(new User("Stanley", "stanleyTest", "stanley@test.com"));
    }

    @Test
    public void getUserWhenExists() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/get-user/{email}", "stanley@test.com")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
