# ah-springboot-postgres
Example Spring Boot project with Hibernate, Flyway and PostgreSQL

---
# 1. Setup
Prerequisites:
- macOS
- Installed homebrew
- terminal

---
## 1.1 Install Spring on macOS
For example using the spring-boot command line tool.
```bash
# install the spring-cli
brew tap spring-io/tap
brew install spring-boot

# initialize spring project

spring init --dependencies=web,data-jpa,flyway,postgresql,testcontainers \
--java-version 11 --package-name com.fcoach --name api springboot-postgres
# use 'spring init --list' to discover dependencies
```
## 1.2 Install
```bash
brew install postgresql
# runs: initdb --locale=C -E UTF-8 /opt/homebrew/var/postgres
brew services start postgresql
psql -l
# output
                          List of databases
   Name    | Owner  | Encoding | Collate | Ctype | Access privileges
-----------+--------+----------+---------+-------+-------------------
 postgres  | <user> | UTF8     | C       | C     |
 template0 | <user> | UTF8     | C       | C     | =c/<user>        +
           |        |          |         |       | <user>=CTc/<user>
 template1 | <user> | UTF8     | C       | C     | =c/<user>        +
           |        |          |         |       | <user>=CTc/<user>
```


## 1.3 Create and delete database
```bash
# create database
createdb test
# delete database
dropdb test
```

