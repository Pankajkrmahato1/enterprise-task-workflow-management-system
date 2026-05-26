# Enterprise Task Workflow Management System

An enterprise-grade, high-performance task tracking and workflow automation backend built using **Spring Boot 3.5** and **PostgreSQL 14**. This system is designed to streamline complex project management operations by facilitating structured role-based access control, dynamic task progression pipelines, and data isolation principles across organizational teams.

The core architecture leverages **Spring Data JPA** for automated schema migrations and object-relational mapping, hosted entirely on an externalized local database infrastructure.

---

## 🚀 Key Features

* **Role-Based User Management:** Fine-grained authentication separating operations between organizational tiers (`ADMIN`, `Manager`, `Engineer`) via decoupled Request/Response Data Transfer Objects (DTOs).
* **Dynamic Workflow Automation:** Structural state machines ensuring tasks progress seamlessly through customized workflow pipelines without data integrity leaks.
* **Decoupled Architecture:** Strict separation of concerns adhering to the Controller-Service-Repository pattern, ensuring presentation models (DTOs) remain entirely abstracted from structural storage entities.
* **Enterprise Storage Integration:** Fully optimized to interface with dedicated external database engines (NVMe/SSD), supporting persistent indexing and rapid connection pooling via HikariCP.

---

## 🛠️ Tech Stack & Architecture

* **Framework:** Spring Boot 3.5.14 (Java 22.0.1)
* **Database Engine:** PostgreSQL 14.18
* **Persistence Layer:** Spring Data JPA / Hibernate ORM 6.6
* **Connection Management:** HikariCP Connection Pool
* **Security Architecture:** Spring Security (Stateless / Basic Execution)
* **API Testing Framework:** Insomnia REST Client

---

## 📂 Project Architecture Layout

The codebase implements a structured **Layer-by-Type** packages layout, keeping data models completely independent of network transit states:

```text
com.github.pankajkrmahato1.enterprise_task_workflow_management_system/
│
├── config/             # Framework security adjustments & custom beans
├── controller/         # REST API Gateways exposing public/private endpoints
├── dto/                # Inbound/Outbound request payloads (Network Data Contracts)
├── entity/             # Relational mapping entities bound to the PostgreSQL cluster
├── repository/         # Data Access Objects (DAOs) running underlying SQL interactions
└── service/            # Core business logic execution layers
