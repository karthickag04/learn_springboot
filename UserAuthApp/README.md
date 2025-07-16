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

<!-- MySQL Database Driver -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
</dependency>

<!-- Development Tools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

**Purpose**: Sets up the foundation for a Spring Boot web application with JSP view support, JPA database integration, and MySQL database connectivity.

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

# ===== DATABASE CONFIG =====
spring.datasource.url=jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=test01
spring.datasource.password=test@123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# ===== JPA & HIBERNATE CONFIG =====
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
**Purpose**: 
- Sets custom server port to 8085
- Configures JSP view resolver to locate JSP files in `/WEB-INF/jsp/` directory
- **Database Configuration**: Connects to MySQL database 'userdb' on localhost:3306
- **JPA Settings**: Auto-updates database schema, shows SQL queries, uses MySQL8 dialect

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
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String Email);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
```
**Purpose**: 
- Data access layer extending JpaRepository with @Repository annotation
- Provides CRUD operations for User entity
- Custom methods for email validation and authentication queries
- **existsByEmail**: Checks if user exists with given email
- **findByEmailAndPassword**: Used for user authentication
- **findByEmail**: Retrieves user by email address

#### 3.3 Service Layer (`UserService.java`)
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
```
**Purpose**: 
- Business logic layer with service annotation
- **getAllUsers()**: Retrieves all users from database
- **saveUser()**: Saves/persists user data to database (used for registration)
- Ready for expansion with authentication and validation logic

### Step 4: Web Layer Implementation

#### 4.1 Web Controller (`HomeController.java`)
```java
@Controller
public class HomeController {
    @Autowired
    UserService userService;
    
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
    
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
```
**Purpose**: 
- Handles HTTP GET requests for main application routes
- Returns JSP view names (resolved using configured prefix/suffix)
- **GET Mappings**: Provides navigation to home, login, and registration pages
- **POST /register**: Processes user registration form submission
  - Uses @ModelAttribute to bind form data to User object
  - Calls userService.saveUser() to persist user data
  - Redirects to login page after successful registration

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
- **✅ Functional**: Form submits to `/register` POST handler in HomeController

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
| `/register` | POST | Process registration | ✅ Implemented |
| `/login` | POST | Process login | ❌ Not implemented |

## 🔧 Current Implementation Status

### ✅ Completed Features
- [x] Spring Boot application setup with Maven
- [x] JSP view configuration and rendering
- [x] Basic web controller with GET mappings
- [x] JPA entity model for User
- [x] Repository layer with custom query methods and @Repository annotation
- [x] Service layer with user retrieval and save functionality
- [x] Responsive JSP pages with embedded CSS
- [x] WAR packaging support
- [x] MySQL database configuration and connectivity
- [x] User registration POST handler implementation
- [x] Form data binding with @ModelAttribute
- [x] Database persistence for user registration

### ❌ Missing Implementation
- [ ] POST request handler for login form
- [ ] Password encoding/hashing
- [ ] Session management
- [ ] Form validation and error handling
- [ ] Security configuration
- [ ] User authentication logic in login process
- [ ] Success/error feedback pages

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
- **Repository**: Spring Data JPA with @Repository annotation
- **Database**: MySQL 8.x configured
- **Connection**: jdbc:mysql://localhost:3306/userdb
- **Username**: test01
- **Password**: test@123
- **Schema Management**: Auto-update enabled (spring.jpa.hibernate.ddl-auto=update)
- **SQL Logging**: Enabled for debugging (spring.jpa.show-sql=true)

## 🎯 Next Steps for Complete Implementation

1. **Add POST handler for login** in HomeController for authentication processing
2. **Implement authentication logic** in UserService using findByEmailAndPassword
3. **Add password encoding** using BCrypt for security
4. **Configure session management** to maintain user login state
5. **Add form validation** and error messaging for user feedback
6. **Configure Spring Security** for comprehensive security features
7. **Add success/error pages** for login and registration feedback
8. **Create MySQL database** 'userdb' with proper user credentials

### Database Setup Requirements

Before running the application, ensure MySQL database is properly configured:

1. **Install MySQL Server** (version 8.0 or higher)
2. **Create Database**:
   ```sql
   CREATE DATABASE userdb;
   ```
3. **Create Database User**:
   ```sql
   CREATE USER 'test01'@'localhost' IDENTIFIED BY 'test@123';
   GRANT ALL PRIVILEGES ON userdb.* TO 'test01'@'localhost';
   FLUSH PRIVILEGES;
   ```
4. **Verify Connection**: Ensure MySQL service is running on localhost:3306

The application will automatically create the 'users' table on first run due to `spring.jpa.hibernate.ddl-auto=update` setting.

## 📚 Learning Objectives Covered

This implementation demonstrates:
- Spring Boot application structure and configuration
- MVC pattern implementation with Spring
- JPA entity mapping and repository pattern with MySQL integration
- JSP view integration with Spring Boot
- Maven dependency management and WAR packaging
- Form data binding and processing with @ModelAttribute
- RESTful URL mapping conventions
- Database connectivity and configuration
- Auto-schema generation with Hibernate

## 🔄 Current Workflow

### Registration Process (✅ Functional)
1. User navigates to `/register` (GET)
2. Registration form is displayed (Register.jsp)
3. User fills form and submits (POST to `/register`)
4. HomeController receives form data via @ModelAttribute
5. UserService.saveUser() persists data to MySQL database
6. User is redirected to login page

### Login Process (⚠️ Partially Functional)
1. User navigates to `/login` (GET)
2. Login form is displayed (Login.jsp)
3. User submits credentials (POST to `/login`)
4. **❌ No POST handler exists** - requires implementation

---

**Note**: This implementation provides a functional user registration system with MySQL database persistence. The login functionality requires additional POST handler implementation to complete the authentication workflow. The foundation is solid with proper MVC structure, database connectivity, and form processing capabilities.
