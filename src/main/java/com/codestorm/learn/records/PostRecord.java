package com.codestorm.learn.records;

import java.time.LocalDateTime;

public record PostRecord(Long id, String description, LocalDateTime postedDateTime) {
}
