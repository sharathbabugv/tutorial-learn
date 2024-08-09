package com.codestorm.learn.junit_one;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/test")
public class TestControllerOne {

    private final TestServiceOne serviceOne;

    public TestControllerOne(TestServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    @GetMapping("/get")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/service")
    public ResponseEntity<String> returnStringFromService() {
        String valueFromService = serviceOne.giveMeString();
        return ResponseEntity.ok(valueFromService);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestParam String data) {
        return ResponseEntity.ok(serviceOne.saveData(data));
    }

    @PostMapping("/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(serviceOne.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/read-data")
    public ResponseEntity<String> readData(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
