# 📚 Spring JPA Basics Demo

This project is a comprehensive demo application built with **Spring Boot** and **Spring Data JPA**, showcasing fundamental and advanced concepts of JPA (Java Persistence API). It covers relationship mappings, embedded types, repository patterns, inheritance, and composite keys.

## 🚀 Features Covered

### 🔗 Relationship Mappings

- **@ManyToMany**  
  Demonstrates a bidirectional many-to-many relationship between entities like `Student` and `Course`.

- **@ManyToOne**  
  A many-to-one relationship such as `Order` → `Customer`.

- **@OneToOne**  
  A one-to-one relationship such as `User` → `Profile`.

### 🧩 Embeddable Types

- **@Embeddable** and **@Embedded**  
  Showcases how to reuse address or contact details across multiple entities using embedded classes.

### 📂 Repository Layer

- **JpaRepository**  
  Leverages Spring Data JPA's `JpaRepository` interface to abstract common CRUD operations.

### 🧬 Inheritance Mapping

- Demonstrates **single-table**, **joined**, and **table-per-class** inheritance strategies using `@Inheritance`.

### 🧷 Composite Attributes and Keys

- Use of `@EmbeddedId` and `@IdClass` to define entities with composite primary keys.

---

## 🛠️ Tech Stack

| Tool / Framework | Description                        |
|------------------|------------------------------------|
| Spring Boot      | Application framework              |
| Spring Data JPA  | ORM abstraction layer              |
| Hibernate        | JPA implementation                 |
| PostgreSQL       | Primary relational database        |
| MySQL            | Alternate DB (for config demo)     |
| Maven            | Dependency & build tool            |
| Faker            | To generate mock data for database |

---

## 🐳 Setting Up PostgreSQL & MySQL with Docker

You can quickly spin up PostgreSQL and MySQL databases using Docker to support this application.

### 🛠 PostgreSQL Setup (Default)

```bash
docker run --name jpa_postgres \
  -v <pathtolocaldir>:/var/lib/postgresql/data \
  -e POSTGRES_DB=jpa_demo \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 \
  -d postgres
```

```bash
docker run --name jpa_mysql \
  -v <pathtolocaldir>:/var/lib/mysql \
  -e MYSQL_DATABASE=jpa_demo \
  -e MYSQL_ROOT_PASSWORD=password \
  -p 3306:3306 \
  -d mysql
```
