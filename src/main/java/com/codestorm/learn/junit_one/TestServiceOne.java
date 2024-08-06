package com.codestorm.learn.junit_one;

import org.springframework.stereotype.Service;

@Service
public class TestServiceOne {

    public String giveMeString() {
        return "Hello World!";
    }

    public String giveMeStringParam(boolean value) {
        if (value) {
            return "Hello World!";
        } else {
           return null;
        }
    }
}
