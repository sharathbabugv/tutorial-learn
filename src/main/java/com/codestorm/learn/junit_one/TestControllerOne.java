package com.codestorm.learn.junit_one;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestControllerOne {

    private final TestServiceOne testServiceOne;

    public TestControllerOne(TestServiceOne testServiceOne) {
        this.testServiceOne = testServiceOne;
    }

    @GetMapping
    public String returnString() {
        return "Hello World!";
    }

    @GetMapping("/with-entity")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/simple-service")
    public ResponseEntity<String> returnStringFromService() {
        return ResponseEntity.ok(testServiceOne.giveMeString());
    }

    @GetMapping("/simple-service-param")
    public ResponseEntity<String> returnStringFromServiceWithParam() {
        String response = testServiceOne.giveMeStringParam(true);
        return StringUtils.isNotBlank(response)
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body("Value is null");
    }
}
