# Distributed Incident Monitoring System

## 🚀 Overview
A scalable backend system built using Spring Boot to ingest, process, and analyze application logs from distributed services. The system enables real-time incident detection using rule-based anomaly identification and supports efficient debugging, monitoring, and observability across distributed systems.

## ⭐ Key Features
- REST APIs for log ingestion and retrieval across services  
- Centralized log storage for distributed environments  
- Rule-based anomaly detection for identifying system failures  
- Incident correlation to group related events for faster debugging  
- Structured logging for improved observability and traceability  
- Log filtering based on severity levels (INFO, WARN, ERROR)  

## ⚙️ Tech Stack
- **Backend:** Spring Boot, Java  
- **Database:** MySQL / H2  
- **API:** RESTful Services  
- **Architecture:** Layered (Controller, Service, Repository)  

## 🧱 System Design Highlights
- Designed to handle high-volume log ingestion from multiple services  
- Decoupled architecture separating API layer, business logic, and persistence  
- Efficient querying and storage of log events using relational database  
- Supports scalable backend processing and fault detection  
- Uses enum-based log levels for structured severity classification  

## 🧠 Design Approach
- Logs are received via REST endpoints and stored in a centralized database  
- Rule-based engine evaluates log patterns to detect anomalies (ERROR/WARN)  
- Related logs are grouped to identify incidents across services  
- System ensures consistency and reliability in log processing workflows  
- Service layer handles business logic for filtering and anomaly detection  

## 🔄 Example Flow
1. A service sends log events via API (POST /logs)  
2. Logs are stored in the database with structured format  
3. Rule engine analyzes logs for anomalies based on severity  
4. Alerts are triggered for abnormal patterns  
5. Related events are grouped for incident analysis  

## 📚 Key Learnings
- Designing scalable backend systems using Spring Boot  
- Building REST APIs for real-time data ingestion  
- Implementing rule-based anomaly detection  
- Handling distributed system observability challenges  
- Applying layered architecture for clean system design  

## 🎯 Motivation
This project was built to understand how modern distributed systems handle logging, monitoring, and failure detection, and how backend services can be designed for reliability, scalability, and observability.

## 📁 Project Structure

```
src/main/java/com/project/
├── controller/
│   └── LogController.java
├── service/
│   └── LogService.java
├── model/
│   ├── LogEvent.java
│   └── LogLevel.java
├── repository/
│   └── LogRepository.java
└── MonitoringApplication.java
```


## ▶️ Future Enhancements
- Integrate Kafka for real-time log streaming  
- Add dashboard for visualization  
- Implement ML-based anomaly detection  
- Add alert notification system (email/SMS)  
