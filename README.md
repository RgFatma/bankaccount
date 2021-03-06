# Spring Boot Sample

Spring Boot Web application to provide REST API in JSON

## 1. Getting started

### 1.1. Build the project 

```
$ mvn clean install
```

### 1.2. Run Application

```
$ mvn spring-boot:run
```
The web application is accessible via localhost:8080
### 1.3. API

Method | Path                                            | Description                                  |
-------|-------------------------------------------------|----------------------------------------------|
GET    | /api/v1/client/{client_id}                      | retrieve all the accounts by client id       |
GET    | /api/v1/account/{account_number}/operation      | retrieve all the operations by account number|
POST   | /api/v1/account/deposit                         | deposit amount                               |
POST   | /api/v1/account/retreive                        | credit amount                                |


## 1. Database 

  * By default application data is stored in in-memory database (H2)
  * sql script in src/main/resources/data.sql: automatically used to initialize the data