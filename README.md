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
- Swagger

To run application:

You should use docker, so type in the current project directory on the command line: docker-compose up

Notes:
- there are 2 users in the database: 

    [username: user password: 123] ROLE_READ_ONLY

    [username: superuser password: 12345] ROLE_ALLOW_EDIT
- for any request, you must be authorized under one of the users proposed above

Examples of endpoints:

1. Authorization:

http://localhost:8080/api/login

2. Swagger:

http://localhost:8080/api/swagger-ui/index.html

