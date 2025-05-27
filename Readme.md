Spring Boot 3.5.0 with Java 21  using Valkey as a Cache Provider

# Spring Boot 3.5.0 with Java 21 using Valkey as a Cache Provider
This project demonstrates how to use Valkey as a cache provider in a Spring Boot application. Valkey is a high-performance, Redis-compatible key-value store that can be used as a drop-in replacement for Redis.
- It provides a simple and efficient way to manage cache in Spring applications, leveraging the features of Valkey for better performance and scalability.
- This project includes basic CRUD operations with caching, session management, and a simple REST API to demonstrate the integration of Valkey with Spring Boot.
- The application uses Spring Data Redis to interact with Valkey, and it is configured to use Valkey as the cache provider.
- The project also includes Swagger for API documentation and testing.
- The application is built with Java 21 and Spring Boot 3.5.0, ensuring compatibility with the latest features and improvements in both technologies.
- The project is structured to follow best practices in Spring Boot development, making it easy to extend and customize for your specific use case.
- The application is designed to be run locally or in a Docker container, making it easy to set up and test in different environments.
- The project is open-source and can be used as a reference for integrating Valkey with Spring Boot applications.
- The application is designed to be easily deployable and scalable, making it suitable for production use cases.

## Prerequisites
- Java 21
- Maven 3.8.6
- Docker
- Valkey server running locally or in a Docker container
# Server
    redis_version:7.2.4
    server_name:valkey
    valkey_version:8.1.1
    valkey_release_stage:ga
- Spring Boot 3.5.0
- Spring Data Redis
- Spring session
- Spring Boot Starter Cache
- Spring Boot Starter Web
- Spring Boot Starter Test
- Spring Boot Starter Actuator

   
## Setup
1. Clone the repository:
   ```bash
   git clone
   
2. Navigate to the project directory:
   ```bash
   cd spring-valkey-cache
   ```
3. Build the project using Maven:
   ```bash
    mvn clean install
    ```
4. Run the Valkey server using Docker:
5. ```bash
   docker run -d --name valkey -p 6379:6379 valkey/valkey:latest
   ```
6. Start the Spring Boot application:
   ```bash
    mvn spring-boot:run
    ```
7. Access the application at `http://localhost:8080/`.
8. Test the cache functionality by sending a GET request to `http://localhost:8080/swagger-ui.html`.
9. You can also use the provided Swagger UI to interact with the API endpoints.


Tools  Used
- Docker 
- Maven
- IntelliJ IDEA
- Redis Insight
- Swagger (for API documentation)
- Lombok (for reducing boilerplate code)
- Spring Boot Actuator (for monitoring and management)
- Spring Boot Starter Web (for building web applications)
- Spring Boot Starter Cache (for caching support)
- Spring Boot Starter Data Redis (for Redis integration)
- Spring Boot Starter Test (for testing support)
- Spring Boot Starter Session (for session management)
- Spring Boot Starter Security (for security features)


## References

- https://hub.docker.com/r/valkey/valkey/
- https://valkey-java.io/
- https://valkey.io/topics/migration/
- https://fedoramagazine.org/how-to-move-from-redis-to-valkey/"# spring-valkey-cache" 
