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

---
# Popular Vendors

https://db-engines.com/en/ranking
![width:600px](img/top_vendors.png "Logo Title Text 1")

---
# Relations / Tables / Entities

| SQL term           | Relational term          | Example                                             |
| :-------------     | :-------------           | :-----                                              |
| Table              | Relation or Base relvar  | Game                                                |
| Row                | Tuple or record          | Game "Spanien – Schweden"                           |
| Column             | Attribute or field       | Date, stage, team_left, team_right, goals_left, ... |
| View or result set | Derived relvar           | All games in group stage                            |

---
## Entity Relationsship Diagram
https://www.fussball-wm.pro/wp-content/uploads/sites/1/2021/06/em-spielplan-2021.pdf
https://www.uefa.com/uefaeuro-2020/fixtures-results/#/md/33673

---
## Relationsship Concepts and Terms
- Primary key
- Foreign key
- Many to one
- Many to many
- One to many

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
# SQL
Structured Query Language

---
# Flyway
---
# JPA, Hibernate
---
# Sring Data

---


# Integration Testing

- Testcontainers
- Non-docker alternative: H2 in memory DB

Other popular testing frameworks can be found on [Libhunt][3], for example:

- [Rest assured][1]
- [Wiremock][2]
- Apache camel
- [Citrus framework](https://citrusframework.org)

---

# JPQL

[1]: https://rest-assured.io

[2]: http://wiremock.org

[3]: https://java.libhunt.com/categories/448-testing

[https://en.wikipedia.org/wiki/Relational_database]: https://en.wikipedia.org/wiki/Relational_database
