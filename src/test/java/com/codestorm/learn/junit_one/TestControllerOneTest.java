package com.codestorm.learn.junit_one;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TestControllerOne.class)
class TestControllerOneTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestServiceOne testServiceOne;

    @Test
    public void returnString() throws Exception {
        mockMvc.perform(get("/api/v1/test"))
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void returnStringNegative() throws Exception {
        mockMvc.perform(get("/api/v1/test"))
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void returnStringWithResponseEntity() throws Exception {
        mockMvc.perform(get("/api/v1/test/with-entity"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Hello World!"));
    }

    @Test
    public void returnStringFromService() throws Exception {
        Mockito.when(testServiceOne.giveMeString()).thenReturn("Hello World!");

        mockMvc.perform(get("/api/v1/test/simple-service"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Hello World!"));
    }

    @Test
    public void returnStringFromServiceWithParam() throws Exception {
        Mockito.when(testServiceOne.giveMeStringParam(false))
                .thenThrow(new RuntimeException("No returning any value!"));

        mockMvc.perform(get("/api/v1/test/simple-service-param"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Value is null"));

        Mockito.when(testServiceOne.giveMeStringParam(true))
                .thenReturn("This is valid test!");

        mockMvc.perform(get("/api/v1/test/simple-service-param"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "This is valid test!"));

    }

}