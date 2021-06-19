# ah-springboot-postgres
Example Spring Boot project with Hibernate, Flyway and PostgreSQL

---
# 1. Setup
Prerequisites:
- macOS
- Installed homebrew
- Shell (e.g. iTerm, Terminal)
- Docker

---
## 1.1 Install Spring on macOS
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
## 1.3 Create and delete database
```bash
# create database
createdb test
# delete database
dropdb test
# create database for spring boot project
createdb booking

```

