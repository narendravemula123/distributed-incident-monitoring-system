package com.project.controller;

import com.project.model.LogEvent;
import com.project.model.LogLevel;
import com.project.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    // ✅ Add new log
    @PostMapping
    public LogEvent addLog(@RequestBody LogEvent logEvent) {
        return logService.saveLog(logEvent);
    }

    // ✅ Get logs by level
    @GetMapping("/level/{level}")
    public List<LogEvent> getByLevel(@PathVariable LogLevel level) {
        return logService.getLogsByLevel(level);
    }

    // ✅ Get logs by service
    @GetMapping("/service/{serviceName}")
    public List<LogEvent> getByService(@PathVariable String serviceName) {
        return logService.getLogsByService(serviceName);
    }

    // ✅ Get logs by time range
    @GetMapping("/range")
    public List<LogEvent> getByTimeRange(
            @RequestParam String start,
            @RequestParam String end) {

        return logService.getLogsByTimeRange(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end)
        );
    }

    // 🚨 Detect recent errors
    @GetMapping("/errors/recent")
    public List<LogEvent> getRecentErrors(@RequestParam int minutes) {
        return logService.detectRecentErrors(minutes);
    }

    // 🔍 Search logs
    @GetMapping("/search")
    public List<LogEvent> searchLogs(@RequestParam String keyword) {
        return logService.searchLogs(keyword);
    }
}
