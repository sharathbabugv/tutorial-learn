package com.codestorm.learn.records;

import java.util.HashMap;
import java.util.Map;

public class PostRecordWithFunction {

    public void doSomeOperation() {
        Map<String, Integer> map = new HashMap<>();
        map.put("HI", 5);
        map.put("BYE", 2);
        map.put("WELCOME", 3);

//        map.entrySet().stream()
//                .map(m -> m.getKey() + " has repeated " + m.getValue() + " times")
//                .forEach(System.out::println);

        record Operation(String a, Integer b) {
            public String toString() {
                return String.format("%s has repeated %d times", a, b);
            }
        }

        map.entrySet().stream()
                .map(m -> new Operation(m.getKey(), m.getValue()))
                .forEach(System.out::println);


    }

}
