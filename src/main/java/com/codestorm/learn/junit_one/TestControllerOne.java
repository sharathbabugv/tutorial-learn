package com.codestorm.learn.junit_one;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/test")
public class TestControllerOne {

    private final TestServiceOne testServiceOne;

    public TestControllerOne(TestServiceOne testServiceOne) {
        this.testServiceOne = testServiceOne;
    }

    @GetMapping("/get")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/service")
    public ResponseEntity<String> returnStringFromService() {
        return ResponseEntity.ok(testServiceOne.giveMeString());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestParam String data) {
        return ResponseEntity.ok(testServiceOne.saveData(data));
    }

    @PostMapping("/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(testServiceOne.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/read-data")
    public ResponseEntity<String> readData(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
