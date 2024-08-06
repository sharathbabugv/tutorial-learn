package com.codestorm.learn.junit_one;

import org.springframework.stereotype.Service;

@Service
public class TestServiceOne {

    public String giveMeString() {
        return "Hello World!";
    }

    public String giveMeStringParam(boolean value) {
        return value ? "Hello World!" : null;
    }
}
