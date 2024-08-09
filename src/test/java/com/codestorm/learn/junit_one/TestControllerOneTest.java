package com.codestorm.learn.junit_one;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TestControllerOne.class)
class TestControllerOneTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestServiceOne testServiceOne;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void returnStringWithResponseEntity() throws Exception {
        String output = "Hello World!";

        mockMvc.perform(get("/api/v1/test/get"))
                .andExpect(status().isOk())
                .andExpect(content().string(output));
    }

    @Test
    public void returnStringFromService() throws Exception {
        String output = "Hello World!";
        Mockito.when(testServiceOne.giveMeString()).thenReturn(output);

        mockMvc.perform(get("/api/v1/test/service"))
                .andExpect(status().isOk())
                .andExpect(content().string(output));
    }


    @Test
    public void saveData() throws Exception {
        String input = "123";
        String output = String.format("%s - Data Saved!", input);

        Mockito.when(testServiceOne.saveData(anyString())).thenReturn(output);

        mockMvc.perform(post("/api/v1/test/save").param("data", input))
                .andExpect(status().isOk())
                .andExpect(content().string(output));

        verify(testServiceOne, times(1)).saveData(anyString());
    }

    @Test
    public void saveEmployee() throws Exception {
        Employee input = new Employee(null, "John", 28);
        String requestBody = objectMapper.writeValueAsString(input);

        Employee savedEmployee = new Employee(UUID.randomUUID().toString(), "John", 28);

        Mockito.when(testServiceOne.saveEmployee(any(Employee.class))).thenReturn(savedEmployee);

        mockMvc.perform(post("/api/v1/test/save-employee")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(savedEmployee.id()))
                .andExpect(jsonPath("$.name").value(savedEmployee.name()))
                .andExpect(jsonPath("$.age").isNumber());

        verify(testServiceOne, times(1)).saveEmployee(any(Employee.class));
    }

    @Test
    public void readData() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hey".getBytes());

        mockMvc.perform(multipart("/api/v1/test/read-data")
                        .file(mockMultipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().string("hello.txt"));
    }

}