---
marp: true
title: Java Spring Boot & SQL
description: Short introduction for novice developers to use SQL in Java

theme: gaia
class:
  - invert
paginate: true
_paginate: false
footer: 'Slides by [Ansgar Hugo](http://www.ansgar-hugo.de)'
---
# Spring Data, JPA - Configuration
```yaml
spring:
  datasource:
    # jdbc database url
    url: jdbc:postgresql://localhost:5432/booking
    # username for the db user
    username: ${DB_USERNAME}
    # password for the db user
    password: ${DB_PASSWORD}
```
---
# Pass environment variables
```bash
export DB_USERNAME="db_user"
export DB_PASSWORD="change_secret"
```

---
# Flyway
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
- SQL is executed automatically on application start
- helps to keep the schema in sync with the code
```yaml
spring:
  flyway:
    locations: classpath:db/migration
    schemas: public
    enabled: true

```
---
# Java Persistence Entity
```java
@Entity
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private LocalDate birthday;
}
```
---
# Java Persistence Mapping
```java
@Entity
public class Booking {
  // ...

  @ManyToOne
  @JoinColumn(name = "player_id", nullable = false)
  private Player player;

  // ...
}
```

---
# Integration Testing

- [Testcontainers](https://www.testcontainers.org/)
- [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
- Non-docker alternative: H2 in memory DB

---

## Test Containers
```yaml
spring:
  datasource:
    driver-class-name: org.testcontainers.jdbc.ContainerDatabaseDriver
    url: jdbc:tc:postgresql:13.3:///booking
    username: ${EMBEDDED_DB_USERNAME}
    password: ${EMBEDDED_DB_PASSWORD}
```

---
## Transactions
```java
@Service
@Transactional
public class PlayerService {
...
}
```

