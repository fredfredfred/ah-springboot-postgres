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
## Create spring boot project
For example using the spring-boot command line tool.
```bash
# install the spring-cli
brew tap spring-io/tap
brew install spring-boot

# initialize spring project

spring init --dependencies=web,data-jpa,flyway,postgresql,testcontainers,lombok,restdocs,validation \
--java-version 11 --package-name com.fcoach --name api springboot-postgres
# use 'spring init --list' to discover dependencies
```
---
## Download Sample Project
```bash
cd myprojects
git clone git@github.com:fredfredfred/ah-springboot-postgres.git
```

---
## Spring Data, JPA
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

---
## Spring Data Repository
```java
@Repository
public interface PlayerRepository
  extends JpaRepository<Player, Long> {

  List<Player> findPlayerByName(String name);
  Page<Player> findPlayerByBirthdayLessThanEqual
    (LocalDate since, Pageable pageable);

}
```

---
## JPQL
SQL like query language with Java objects support (dot notation).
```java
@Query("select p from Player p where p.birthday >= :sinceDate")
List<Player> findPlayersBornSince(@Param("sinceDate") LocalDate since);
```

---
## Integration Testing

- [Testcontainers](https://www.testcontainers.org/)
- [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
- Non-docker alternative: H2 in memory DB

---

