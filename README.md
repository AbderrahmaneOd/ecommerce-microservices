# Microservices E-commerce Platform

A modern, distributed e-commerce application built with **Spring Boot microservices architecture** for learning purposes. This project demonstrates best practices in building **scalable**, **resilient**, and **maintainable** microservices using the Spring ecosystem.

---

## Architecture Overview

The platform is designed as a collection of loosely coupled microservices, each responsible for a specific business capability. The architecture includes:

- **API Gateway**: Single entry point for all client requests, handles routing and load balancing
- **Config Server**: Centralized configuration management for all services
- **Discovery Server**: Service registration and discovery with Eureka
- **Product Service**: Manages product catalog and information (MongoDB)
- **Inventory Service**: Handles stock management and availability (PostgreSQL)
- **Order Service**: Processes customer orders with circuit breaker patterns (PostgreSQL)
- **User Service**: Manages user accounts and authentication (MongoDB)
- **Cart Service:** Manages shopping cart (Redis)
- **Notification Service**: Sends order confirmations and updates to customers via email

## Project Structure

```
microservices-ecommerce/
├── api-gateway/
├── config-server/
├── discovery-server/
├── inventory-service/
├── notification-service/
├── order-service/
├── product-service/
├── user-service/
├── cart-service/
├── docker-compose.dev.yaml
├── docker-compose.local.yaml
└── README.md
```

## Technologies

- **Spring Boot**: Core framework for building the microservices
- **Spring Cloud**: For distributed systems patterns
  - Netflix Eureka for service discovery
  - Spring Cloud Config for centralized configuration
  - Spring Cloud Gateway for API Gateway
- **Spring WebFlux**: Reactive programming with WebClient
- **Spring Data**: Data access with MongoDB and PostgreSQL
- **Apache Kafka**: Event-driven messaging between services
- **Docker & Docker Compose**: Containerization and orchestration
- **Maven**: Build and dependency management with Jib for containerization
- **GitHub Actions**: CI/CD pipeline with matrix builds

## Communication Patterns

The project demonstrates different communication styles between services:

- **Synchronous Communication**: Order Service → Inventory Service using WebClient
- **Asynchronous Communication**: Order Service → Notification Service using Kafka
- **Resilience Patterns**: Circuit breaker implementation in Order Service for fault tolerance

## Getting Started

### Prerequisites

- Docker and Docker Compose
- Java 17
- Maven

### Configuration Setup

The project uses a centralized configuration repository:

- Config Repository: [https://github.com/AbderrahmaneOd/ecommerce-microservices-app-config](https://github.com/AbderrahmaneOd/ecommerce-microservices-app-config)
- This repository is used by the Config Server to provide configuration to all other services

### Docker Image Building

Each service uses Google's Jib Maven plugin to build Docker images. To build and push images to your own Docker Hub account:

1. Modify the `pom.xml` in each service to update the image name:

```xml
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.4.4</version>
    <configuration>
        <to>
            <image>yourusername/service-name:latest</image>
        </to>
    </configuration>
</plugin>
```

2. Build and push the image:

```bash
cd service-directory
mvn compile jib:build
```

### Email Configuration

The Notification Service requires email configuration. Update the following properties in your configuration:

```properties
spring.mail.username=your-email@example.com
spring.mail.password=your-email-password
```

### Running the Application

#### Full Deployment

1. Clone the repository:

```bash
git clone https://github.com/AbderrahmaneOd/ecommerce-microservices
cd ecommerce-microservices
```

2. Start all services with Docker Compose:

```bash
docker-compose -f docker-compose.dev.yaml up -d
```

3. The application will be accessible at:
   - API Gateway: http://localhost:8080
   - Eureka Dashboard: http://localhost:8761
   - Kafka UI: http://localhost:8090

#### Local Development

For local development, you can use the `docker-compose.local.yml` file which only starts the required infrastructure (databases, Kafka, etc.):

```bash
docker-compose -f docker-compose.local.yml up -d
```

This allows you to run individual services from your IDE with the local profile while connecting to the containerized dependencies.

### Services and Ports

| Service              | Port | API endpoint     | Database          | Description                        |
| -------------------- | ---- | ---------------- | ----------------- | ---------------------------------- |
| Config Server        | 8888 | N/A              | N/A               | Centralized configuration          |
| Discovery Server     | 8761 | N/A              | N/A               | Service registration and discovery |
| API Gateway          | 8080 | N/A              | N/A               | Entry point for client requests    |
| Product Service      | 8081 | /api/products    | MongoDB (27017)   | Product catalog management         |
| Order Service        | 8082 | /api/orders      | PostgreSQL (5431) | Order processing                   |
| Inventory Service    | 8083 | /api/inventories | PostgreSQL (5432) | Stock management                   |
| Notification Service | 8084 | N/A              | N/A               | Customer email notifications       |
| User Service         | 8085 | /api/users       | MongoDB (27018)   | User management                    |
| Cart Service         | 8086 | /api/cart        | Redis             | Shopping cart management           |
| Kafka UI             | 8090 | N/A              | N/A               | Kafka management UI                |

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
