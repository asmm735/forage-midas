# Midas
Project repo for the JPMC Advanced Software Engineering Forage program

## Overview

This is a comprehensive Spring Boot application demonstrating enterprise software engineering practices including microservices architecture, event-driven systems, and REST APIs.

## Learning Objectives (Tasks 1-5)

### Task 1: Data Ingestion Pipeline (Kafka Consumer)
- Set up Kafka consumer to ingest transaction data from external sources
- Implemented data validation and processing logic
- Learned about message-driven architecture with Spring Kafka
- **Key Skills**: Event streaming, message consumption, data validation

### Task 2: Transaction Service & Data Persistence (JPA/Hibernate)
- Built transaction service with business logic for processing transactions
- Implemented JPA repository pattern for database operations
- Learned Spring Data JPA and entity mapping with proper relationships
- Database design with user and transaction records
- **Key Skills**: ORM, repository pattern, service layer design

### Task 3: Event-Driven Architecture (Kafka Producer)
- Implemented Kafka producer to emit validated transactions as events
- Learned asynchronous communication patterns
- Decoupled components using message broadcasting
- Enabled real-time event processing across system
- **Key Skills**: Event publishing, decoupled architecture, async processing

### Task 4: Incentive Integration API (REST Client)
- Integrated external REST API (incentive API) using RestTemplate
- Learned REST client calls and JSON serialization/deserialization
- Applied incentive calculations to user balances correctly
- Understood API response handling with proper type conversions
- **Key Skills**: REST client integration, external API consumption, type conversion

### Task 5: Balance Query REST API (REST Controller)
- Built REST controller for querying user balances via GET endpoint
- Implemented request parameter handling with `@RequestParam`
- Learned proper type conversions (String to Long, double to float)
- Configured Spring Boot on custom port (33400)
- Handled null cases with graceful defaults
- **Key Skills**: REST API design, Spring MVC, type conversion, error handling

## Technical Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Messaging**: Apache Kafka
- **Data Access**: Spring Data JPA, Hibernate
- **Database**: Configured with application properties
- **Build Tool**: Maven
- **HTTP Port**: 33400

## Architecture Highlights

1. **Microservices Pattern**: Separate concerns for transaction processing, incentive calculation, and balance queries
2. **Event-Driven Design**: Kafka integration for asynchronous communication
3. **Repository Pattern**: JPA-based data access layer
4. **REST API**: Clean GET endpoint for balance queries with proper error handling
5. **Type Safety**: Proper type conversions and null checks throughout

## Key Learnings

- **Message-Driven Architecture**: Understanding Kafka for event streaming and real-time processing
- **Spring Ecosystem**: Proficiency with Spring Boot, Spring Data JPA, and Spring MVC
- **API Integration**: Consuming external REST APIs and handling responses
- **Database Design**: Relationship mapping and entity modeling
- **Type Conversions**: Managing type mismatches in Java (String to Long, double to float)
- **Error Handling**: Implementing proper null checks and default values
- **REST Best Practices**: Proper HTTP verbs, request parameters, and JSON serialization

## Running the Application

1. Ensure Kafka is running (or start the incentive API jar)
2. Configure database connection in `application.yml`
3. Run the Spring Boot application
4. Access balance queries at: `http://localhost:33400/balance?userId=<userId>`

---

**Completed**: December 2025 | **JPMorgan Forage Virtual Experience**
