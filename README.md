# CRUD Project

A simple Spring Boot REST API application for managing users with basic CRUD (Create, Read, Update, Delete) operations.

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA** - Database access layer
- **H2 Database** - In-memory database
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🛠️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/joaoliveira6704/SpringBootAuthAPI.git
   cd crudProject
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or run directly from your IDE by executing the main class:
   ```java
   com.joaooliveira.crudProject.CrudProjectApplication
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:user`
     - Username: `sa`
     - Password: (leave empty)

5. **Access the swagger-ui**
   - Base URL: `http://localhost:8080/swagger-ui/index.html`

## 📡 API Endpoints

### User Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users` | Create a new user |
| GET | `/users` | Get all users |
| GET | `/users?id={id}` | Get user by email |
| PUT | `/users?id={id}` | Update user by ID |
| DELETE | `/users?id={id}` | Delete user by ID |

### Example Requests

**Create a new user:**
```bash
POST http://localhost:8080/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

**Get user by id:**
```bash
GET http://localhost:8080/users?id=1
```

**Update a user:**
```bash
PUT http://localhost:8080/users?id=1
Content-Type: application/json

{
  "name": "John Smith",
  "email": "john.smith@example.com"
}
```

**Delete a user:**
```bash
DELETE http://localhost:8080/users?id=1
```

## 🗂️ Project Structure

```
crudProject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/joaooliveira/crudProject/
│   │   │       ├── business/          # Service layer
│   │   │       ├── controller/        # REST controllers
│   │   │       ├── infrastructure/
│   │   │       │   ├── entities # Entities layer
│   │   │       │   ├── repository # Repository layer
│   │   │       └── CrudProjectApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🔧 Configuration

The application uses H2 in-memory database by default. Configuration is in `application.properties`:

```properties
# H2 Database
spring.application.name=crudProject
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:user
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

## ⚠️ Important Notes

- **No Authentication**: This is a basic CRUD application without security. All endpoints are publicly accessible.
- **In-Memory Database**: Data is lost when the application stops. For persistence, switch to PostgreSQL/MySQL.
- **Table Name Issue**: If you encounter SQL syntax errors, ensure your entity uses `@Table(name = "users")` instead of `user` (reserved keyword in H2).

## 🚧 Future Enhancements

- [ ] Add JWT authentication and authorization
- [ ] Add email search
- [ ] Add input validation
- [ ] Add pagination for list endpoints
- [ ] Switch to PostgreSQL for production
- [ ] Add unit and integration tests
- [ ] Add exception handling
- [ ] Add logging

## 👤 Author

João Oliveira

## 📄 License

This project is open source and available for educational purposes.
