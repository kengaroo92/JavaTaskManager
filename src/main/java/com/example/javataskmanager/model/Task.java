package com.example.javataskmanager.model;

import jakarta.persistence.*; //Includes all JPA/Hibernate annotations.
import java.time.LocalDateTime;

@Entity //JPA Entity
@Table(name = "tasks")
public class Task {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment.
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status = "pending"; //This is the default status.

    @Column(nullable = false)
    private Integer priority = 1; //This is the default priority.

    @Column(nullable = false, updatable = false) //Not updated automatically.
    private LocalDateTime createdAt = LocalDateTime.now();

    public Task() {} //Required by JPA. No arg constructor.

    public Task(String name, Integer priority) { //All arg constructor.
        this.name = name;
        this.priority = priority;
    }

    // Getters and Setters (Controls read/write access).
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}