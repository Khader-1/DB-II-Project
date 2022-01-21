# DB II Project

## Prerequesites

- you should have [docker](https://www.docker.com/) installed on your device

## Installation

- clone the project

```bash
git clone https://github.com/Khader-1/DB-II-Project.git
```

- build it using docker compose

```bash
docker-compose up
```

- After build finishes you can access the app at port [`6868`](http://localhost:6868)

## ERD

## !["ERD"](university_db_schema.png)

### Project Description:

Create an application for University registration system, Using PL/SQL, the different data of students is manipulated as per different requirement. The data is allowed to be added and deleted from the tables.

### Notes:

1. Find Attach Project Schema (university.sql) Feel free to use any programing language to build application (Java , php , asp ..)
1. All Project Requirement must be as Stored in DB (Procedure, Functions...).

### How to use universitySchema.sql ?

1. Connect as sys as sysdba using SqlPlus
1. Create user as following:

```
        CREATE USER your_name
    	IDENTIFIED BY your_password
    	DEFAULT TABLESPACE USERS
    	QUOTA 10M ON USERS;


    	GRANT CREATE SESSION, RESOURCE, CREATE VIEW,
    	CREATE SYNONYM, CREATE MATERIALIZED VIEW, ALTER SESSION
    	TO your_name;

```

3. Create new connection to new user in sql developer
4. Copy all Schema sql and Run all script
