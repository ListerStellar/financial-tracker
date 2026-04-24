# Finance Tracker API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.14.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-3.0.2-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

Finance Tracker RESTful API designed for reliability, scalability, and ease of deployment. Built with the latest Java 21 and Spring Boot 4 ecosystem, it provides a solid foundation for tracking and analyzing financial transactions.

---

## Tech Stack & Architecture

- **Core**: Java 21 (Eclipse Temurin JRE)
- **Framework**: Spring Boot 4.0.5
  - Spring Web MVC for RESTful endpoints
  - Spring Data JPA for data access
- **Database**: PostgreSQL 15
- **Build Tool**: Gradle (Kotlin DSL)
- **Code Generation**: Lombok to reduce boilerplate
- **API Documentation**: Springdoc OpenAPI (Swagger UI) 3.0.2
- **Containerization**: Docker & Docker Compose (Multi-stage builds)

---

## Getting Started

The project is fully dockerized. No local database installation is required.

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/) & [Docker Compose](https://docs.docker.com/compose/install/)

### One-Click Run

To start the application and its database in detached mode:

```bash
docker-compose up -d --build
```

The application will be available at `http://localhost:8080`.

### Local Development (Without Docker App)

If you prefer to run the application locally via your IDE or Gradle, while keeping the database in Docker:

1. Spin up only the PostgreSQL container:
   ```bash
   docker-compose up -d db
   ```
2. Run the application via Gradle:
   ```bash
   ./gradlew bootRun
   ```

---

## API Documentation

Once the application is running, you can explore and interact with the REST API using the built-in Swagger UI.

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## Docker Architecture

The project utilizes a multi-stage `Dockerfile` to ensure the final image is lightweight and secure:
1. **Build Stage**: Uses `gradle:8.14.1-jdk21` to compile and package the application.
2. **Runtime Stage**: Uses the minimal `eclipse-temurin:21-jre-jammy` image to run the compiled `.jar`.

The `docker-compose.yml` orchestrates the application alongside a PostgreSQL container and sets up volume mounts for data persistence (`postgres_data`).

---

## Project Structure

The project follows standard Spring Boot directory layout and best practices:
- Uses Kotlin DSL (`build.gradle.kts`) for concise and type-safe build scripts.
- Implements layered architecture (Controllers, Services, Repositories).

---

*Designed and engineered for high-performance financial tracking.*
