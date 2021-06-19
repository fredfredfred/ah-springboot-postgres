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
## Install Postgres
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

---
## Create DB
```bash
# create user
createuser -s db_user
# optional for local testing: Set a password
psql booking db_user
  \password change_secret
  \q
```
## Setup user
```bash
# create user
createuser -s db_user
# optional for local testing: Set a password
psql booking db_user
  \password change_secret
  \q
# enable security for local postgres
vi /opt/homebrew/var/postgres/pg_hba.conf
# e.g. change 'trust' to 'password' or 'peer' (os user)
# host    all             all             127.0.0.1/32            trust
# to
# host    all             all             127.0.0.1/32            password
brew services restart postgresql
```
