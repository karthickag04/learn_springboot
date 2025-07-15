# UserAuthApp - Spring Boot User Authentication Application

A Spring Boot web application implementing basic user authentication functionality with JSP views, JPA data persistence, and Maven build system.

## 📋 Project Overview

This is a Spring Boot web application that provides a foundation for user authentication using:
- **Framework**: Spring Boot 3.5.3
- **Java Version**: Java 21
- **Database**: JPA with auto-configured database
- **View Technology**: JSP (JavaServer Pages)
- **Build Tool**: Maven
- **Packaging**: WAR (Web Application Archive)
- **Server**: Embedded Tomcat

## 🏗️ Project Structure

```
UserAuthApp/
├── pom.xml                           # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/gtec/UserAuthApp/
│   │   │   ├── UserAuthAppApplication.java    # Main application class
│   │   │   ├── ServletInitializer.java        # WAR deployment initializer
│   │   │   ├── controller/
│   │   │   │   └── HomeController.java        # Web controller for routing
│   │   │   ├── model/
│   │   │   │   └── User.java                  # User entity model
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java        # Data access layer
│   │   │   └── service/
│   │   │       └── UserService.java           # Business logic layer
│   │   ├── resources/
│   │   │   └── application.properties         # Application configuration
│   │   └── webapp/WEB-INF/jsp/
│   │       ├── Index.jsp                      # Home page
│   │       ├── Login.jsp                      # Login form
│   │       └── Register.jsp                   # Registration form
│   └── test/
│       └── java/com/gtec/UserAuthApp/
│           └── UserAuthAppApplicationTests.java
└── target/                                    # Build output directory
```

## 🚀 Step-by-Step Implementation Guide

### Step 1: Project Setup and Dependencies

#### 1.1 Maven Configuration (`pom.xml`)
The project uses Spring Boot parent starter with these key dependencies:

```xml
<!-- Core Spring Boot Web Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JSP Support -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <version>11.0.9</version>
</dependency>

<!-- JPA Data Persistence -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Development Tools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

**Purpose**: Sets up the foundation for a Spring Boot web application with JSP view support and JPA database integration.

### Step 2: Application Configuration

#### 2.1 Main Application Class (`UserAuthAppApplication.java`)
```java
@SpringBootApplication
public class UserAuthAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserAuthAppApplication.class, args);
    }
}
```
**Purpose**: Entry point of the Spring Boot application with auto-configuration enabled.

#### 2.2 WAR Deployment Support (`ServletInitializer.java`)
```java
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserAuthAppApplication.class);
    }
}
```
**Purpose**: Enables deployment as a WAR file to external servlet containers.

#### 2.3 Application Properties (`application.properties`)
```properties
spring.application.name=UserAuthApp
server.port=8085
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
**Purpose**: 
- Sets custom server port to 8085
- Configures JSP view resolver to locate JSP files in `/WEB-INF/jsp/` directory

### Step 3: Data Layer Implementation

#### 3.1 User Entity Model (`User.java`)
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    
    // Constructors, getters, and setters
}
```
**Purpose**: 
- JPA entity representing user data
- Maps to "users" table in database
- Auto-generated ID using identity strategy
- Contains basic user fields: username, email, password

#### 3.2 Repository Layer (`UserRepository.java`)
```java
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existedByEmail(String Email);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
```
**Purpose**: 
- Data access layer extending JpaRepository
- Provides CRUD operations for User entity
- Custom methods for email validation and authentication queries
- **Note**: `existedByEmail` appears to have a typo (should be `existsByEmail`)

#### 3.3 Service Layer (`UserService.java`)
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
```
**Purpose**: 
- Business logic layer with service annotation
- Currently implements basic user retrieval functionality
- Ready for expansion with authentication and registration logic

### Step 4: Web Layer Implementation

#### 4.1 Web Controller (`HomeController.java`)
```java
@Controller
public class HomeController {
    @GetMapping("/")
    public String IndexPage() {
        return "Index";
    }
    
    @GetMapping("/register")
    public String RegisterPage() {
        return "Register";
    }
    
    @GetMapping("/login")
    public String LoginPage() {
        return "Login";
    }
}
```
**Purpose**: 
- Handles HTTP GET requests for main application routes
- Returns JSP view names (resolved using configured prefix/suffix)
- Provides navigation to home, login, and registration pages

### Step 5: View Layer Implementation

#### 5.1 Home Page (`Index.jsp`)
**Features**:
- Welcome page with navigation links
- Styled with embedded CSS
- Links to Login, Register, and About pages
- Clean, centered layout with container styling

#### 5.2 Login Page (`Login.jsp`)
**Features**:
- Login form with username and password fields
- POST form submission to `/login` endpoint
- Styled input fields and submit button
- Back navigation to home page
- **Note**: Form submits to `/login` but no POST handler implemented in controller

#### 5.3 Registration Page (`Register.jsp`)
**Features**:
- Registration form with username, email, and password fields
- POST form submission to `/register` endpoint  
- Responsive form styling with validation
- Back navigation to home page
- **Note**: Form submits to `/register` but no POST handler implemented in controller

## ⚙️ How to Run the Application

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher

### Running the Application

1. **Navigate to project directory**:
   ```cmd
   cd d:\learn_springboot\UserAuthApp
   ```

2. **Build the project**:
   ```cmd
   mvnw clean compile
   ```

3. **Run the application**:
   ```cmd
   mvnw spring-boot:run
   ```

4. **Access the application**:
   - Open browser and navigate to: `http://localhost:8085`
   - Home page will be displayed with navigation options

### Alternative: Running as WAR
```cmd
mvnw clean package
java -jar target/UserAuthApp-0.0.1-SNAPSHOT.war
```

## 🌐 Application Endpoints

| URL | Method | Description | Status |
|-----|--------|-------------|---------|
| `/` | GET | Home page | ✅ Implemented |
| `/login` | GET | Login form page | ✅ Implemented |
| `/register` | GET | Registration form page | ✅ Implemented |
| `/login` | POST | Process login | ❌ Not implemented |
| `/register` | POST | Process registration | ❌ Not implemented |

## 🔧 Current Implementation Status

### ✅ Completed Features
- [x] Spring Boot application setup with Maven
- [x] JSP view configuration and rendering
- [x] Basic web controller with GET mappings
- [x] JPA entity model for User
- [x] Repository layer with custom query methods
- [x] Service layer foundation
- [x] Responsive JSP pages with embedded CSS
- [x] WAR packaging support

### ❌ Missing Implementation
- [ ] POST request handlers for login/register forms
- [ ] Password encoding/hashing
- [ ] Database configuration (H2/MySQL/PostgreSQL)
- [ ] Session management
- [ ] Form validation and error handling
- [ ] Security configuration
- [ ] User authentication logic
- [ ] Registration processing logic

## 📝 Key Configuration Details

### JSP Configuration
- **View Prefix**: `/WEB-INF/jsp/`
- **View Suffix**: `.jsp`
- **JSP Engine**: Tomcat Embedded Jasper 11.0.9

### Server Configuration
- **Port**: 8085 (configurable in application.properties)
- **Context Path**: Root (`/`)

### Database Configuration
- **ORM**: JPA/Hibernate (auto-configured)
- **Repository**: Spring Data JPA
- **Database**: Not explicitly configured (will use H2 in-memory by default)

## 🎯 Next Steps for Complete Implementation

1. **Add POST handlers** in HomeController for form processing
2. **Implement authentication logic** in UserService
3. **Add database configuration** for persistent storage
4. **Implement password encoding** using BCrypt
5. **Add form validation** and error messaging
6. **Configure Spring Security** for session management
7. **Add success/error pages** for user feedback

## 📚 Learning Objectives Covered

This implementation demonstrates:
- Spring Boot application structure and configuration
- MVC pattern implementation with Spring
- JPA entity mapping and repository pattern
- JSP view integration with Spring Boot
- Maven dependency management
- WAR packaging for deployment
- RESTful URL mapping conventions

---

**Note**: This is a foundational implementation focusing on project structure and basic functionality. Authentication logic and security features require additional implementation to be production-ready.
