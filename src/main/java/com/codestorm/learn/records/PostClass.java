package com.codestorm.learn.records;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostClass {

    private Long id;
    private String description;
    private LocalDateTime postedDateTime;

    public PostClass() {
    }

    public PostClass(Long id, String description, LocalDateTime postedDateTime) {
        this.id = id;
        this.description = description;
        this.postedDateTime = postedDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostedDateTime() {
        return postedDateTime;
    }

    public void setPostedDateTime(LocalDateTime postedDateTime) {
        this.postedDateTime = postedDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostClass postClass = (PostClass) o;
        return Objects.equals(id, postClass.id) && Objects.equals(description, postClass.description) && Objects.equals(postedDateTime, postClass.postedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, postedDateTime);
    }

    @Override
    public String toString() {
        return "PostClass{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", postedDateTime=" + postedDateTime +
                '}';
    }
}
