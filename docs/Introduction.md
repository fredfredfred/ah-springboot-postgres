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
# Relational Databases
- RDBMS: Relational database management system
- SQL: Structured Query Language
  https://en.wikipedia.org/wiki/Relational_database
---
# Popular Vendors

https://db-engines.com/en/ranking
![width:600px](img/top_vendors.png "Popular DBMS")

---
# Relations / Tables / Entities

| SQL term           | Relational term          | Example                                             |
| :-------------     | :-------------           | :-----                                              |
| Table              | Relation or Base relvar  | Player, Court, Booking                              |
| Row                | Tuple or record          | Booking "Fred, Friday, 14:00, Court 1               |
| Column             | Attribute or field       | Player.id, Player.first_name, Player.last_name      |
| View or result set | Derived relation         | All bookings for court 2 on friday                  |

---
## Entity Relationsship Diagram
https://tc-dorfen.de/anlage

---
## Relationsship Concepts and Terms
- Primary key
- Foreign key
- Many to one: Children -> Mother
- Many to many: Student <-> Teacher
- One to many: Mother -> Children

Question: What relationship has "parents - children"?
---

## ACID

ACID is a feature of database transactions intended to guarantee data validity.

- Atomicity: Transaction is a single unit
- Consistency: Data wont get corrupt by your transaction
- Isolation: Concurrent transactions do not influence each other
  - here it gets more complicated as conflicts are possible and strategies exist (concurrency control mechanisms) to
    mitigate them
- Durability: Survive power outage

---
# SQL - Structured Query Language
- ANSI Standard since SQL-86, but many dialects and proprietary per vendor
- SQL-86, SQL-89, SQL-92,... SQL:2016
- Don't panik, the Standard covers 99% of use cases


- DDL: Data definition language
- DQL: Data query language
- DML: Data manipulation language
- DCL: Data control language (GRANT, REVOKE)

---
# Flyway
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)

---
# Spring Data, JPA
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

---
# Spring Data

---
# Integration Testing

- [Testcontainers](https://www.testcontainers.org/)
- [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
- Non-docker alternative: H2 in memory DB

---

# JPQL
