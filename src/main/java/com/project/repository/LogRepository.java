package com.project.repository;

import com.project.model.LogEvent;
import com.project.model.LogLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<LogEvent, Long> {

    // 🔍 Find logs by level (ERROR, WARN, INFO)
    List<LogEvent> findByLevel(LogLevel level);

    // ⏱️ Find logs within a time range
    List<LogEvent> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    // 🖥️ Find logs by service name
    List<LogEvent> findByServiceName(String serviceName);

    // 🚨 Find error logs after a certain time
    List<LogEvent> findByLevelAndTimestampAfter(LogLevel level, LocalDateTime time);

    // 🔎 Search logs containing keyword in message
    List<LogEvent> findByMessageContainingIgnoreCase(String keyword);

    // 📊 Find logs by service + level
    List<LogEvent> findByServiceNameAndLevel(String serviceName, LogLevel level);

}
