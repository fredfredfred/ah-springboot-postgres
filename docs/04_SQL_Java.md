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
# Spring Data, JPA - References
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

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
# Spring Data

---
# Integration Testing

- [Testcontainers](https://www.testcontainers.org/)
- [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
- Non-docker alternative: H2 in memory DB

---

# JPQL
