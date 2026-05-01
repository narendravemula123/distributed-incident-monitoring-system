package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_events")
public class LogEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LogLevel level;

    @Column(length = 1000, nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Default constructor (required by JPA)
    public LogEvent() {}

    // Parameterized constructor
    public LogEvent(String serviceName, LogLevel level, String message) {
        this.serviceName = serviceName;
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getServiceName() { return serviceName; }
    public LogLevel getLevel() { return level; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Setters
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setLevel(LogLevel level) { this.level = level; }
    public void setMessage(String message) { this.message = message; }
}
