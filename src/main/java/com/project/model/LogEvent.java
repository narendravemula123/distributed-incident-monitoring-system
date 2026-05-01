package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LogEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String level;
    private String message;
    private LocalDateTime timestamp;

    public LogEvent() {}

    public LogEvent(String serviceName, String level, String message) {
        this.serviceName = serviceName;
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getServiceName() { return serviceName; }
    public String getLevel() { return level; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setLevel(String level) { this.level = level; }
    public void setMessage(String message) { this.message = message; }
}
