# ah-springboot-postgres
Example Spring Boot project with Hibernate, Flyway and PostgreSQL

---
# 1. Setup
Prerequisites
## 1.1 Install Spring
For example using the spring-boot command line tool.
```bash
# install the spring-cli on macOS
brew tap spring-io/tap
brew install spring-boot

# initialize spring project

spring init --dependencies=web,data-jpa,flyway,postgresql,testcontainers \
--java-version 1.11 springboot-postgres
# use 'spring init --list' to discover dependencies
```

```bash

```


