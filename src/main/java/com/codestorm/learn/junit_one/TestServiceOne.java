package com.codestorm.learn.junit_one;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TestServiceOne {

    public String giveMeString() {
        return "Hello World!";
    }

    public String saveData(String data){
        // repo logic
        return String.format("%s - Data Saved!", data);
    }

    public Employee saveEmployee(Employee employee){
        // repo logic
        return new Employee(UUID.randomUUID().toString(),
                employee.name(),
                employee.age());
    }
}
