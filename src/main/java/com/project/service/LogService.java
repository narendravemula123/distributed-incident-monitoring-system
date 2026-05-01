package com.project.service;

import com.project.model.LogEvent;
import com.project.model.LogLevel;
import com.project.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    // ✅ Save log event
    public LogEvent saveLog(LogEvent logEvent) {
        logEvent.setTimestamp(LocalDateTime.now());
        return logRepository.save(logEvent);
    }

    // ✅ Get logs by level
    public List<LogEvent> getLogsByLevel(LogLevel level) {
        return logRepository.findByLevel(level);
    }

    // ✅ Get logs by service name
    public List<LogEvent> getLogsByService(String serviceName) {
        return logRepository.findByServiceName(serviceName);
    }

    // ✅ Get logs in time range
    public List<LogEvent> getLogsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return logRepository.findByTimestampBetween(start, end);
    }

    // 🚨 Detect anomalies (simple logic for now)
    public List<LogEvent> detectRecentErrors(int minutes) {
        LocalDateTime time = LocalDateTime.now().minusMinutes(minutes);
        return logRepository.findByLevelAndTimestampAfter(LogLevel.ERROR, time);
    }

    // 🔍 Search logs by keyword
    public List<LogEvent> searchLogs(String keyword) {
        return logRepository.findByMessageContainingIgnoreCase(keyword);
    }

}
