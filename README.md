The enterprise-grade "city list" application, which allows the user to do the following:
- browse through the paginated list of cities with the corresponding photos
- search by the name
- edit the city (editing the city should be only allowed for users with Spring Security's role ROLE_ALLOW_EDIT)

Technical clarification
- Java 17
- Spring Boot 2.7.8
- Build system: Gradle
- Database management system: PostgreSQL
- Database migration: Liquibase
- Docker

To run application:

You should use docker, so type in the current project directory on the command line: docker-compose up

Notes:
- there are 2 users in the database: 

    [username: user password: 123] ROLE_READ_ONLY

    [username: superuser password: 12345] ROLE_ALLOW_EDIT
- for any request, you must be authorized under one of the users proposed above

Examples of endpoints:

1. Authorization:

POST: http://localhost:8080/api/login

2. To find cities using pagination (by default will be first page of 10 cities):

GET: http://localhost:8080/api/v1/cities?page=1&size=2

3. To get city by name:

GET: http://localhost:8080/api/v1/cities/minsk

4. To update name or photo of city (only for users with ROLE_ALLOW_EDIT):

PATCH: http://localhost:8080/api/v1/cities?id=1

JSON Body:

{
  "name": "updatedName"
}