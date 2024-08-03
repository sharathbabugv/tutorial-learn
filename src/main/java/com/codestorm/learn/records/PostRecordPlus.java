package com.codestorm.learn.records;

import java.time.LocalDateTime;

public record PostRecordPlus(Long id, String description, LocalDateTime postedDateTime) {

    // NON CANONICAL
    public PostRecordPlus(Long id, String description) {
        this(id, description, LocalDateTime.now());
    }

    // CANONICAL
//    public PostRecordPlus(Long id, String description, LocalDateTime postedDateTime) {
//        if (id <= 0) {
//            throw new RuntimeException("CANONICAL : Id should be greater than zero");
//        }
//        this.id = id;
//        this.description = description;
//        this.postedDateTime = postedDateTime;
//    }

    // COMPACT
    public PostRecordPlus {
        // VALIDATION
        if(id <= 0){
            throw new RuntimeException("Id should be greater than zero");
        }

        if(description.isBlank()){
            throw new RuntimeException("Description should not be blank");
        }

        // TRANSFORMATION
        description = description.toLowerCase();
    }
}
