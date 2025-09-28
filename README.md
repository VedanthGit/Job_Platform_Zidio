# Job Platform Backend (Spring Boot + MySQL + Spring Cloud)

This is the **backend service** for the Job Platform application.  
It is built using **Spring Boot, Spring Data JPA,Spring Security, Spring Cloud (Eureka + Config), and MySQL**  
The backend exposes a REST API for managing jobs, employees, recruiters, applications, subscriptions, notifications, and analytics.

---

## ⚡ Features
- User authentication & role-based access (Admin, Employee, Recruiter).
- CRUD APIs for Employees, Recruiters, Job Posts, and Applications.
- File uploads (resume, certificates, invoices).
- Subscription & Payment tracking with invoice generation.
- System audit logs for tracking activities.
- Analytics dashboard APIs.
- Email notifications (for communication & updates).

---

## 🛠️ Tech Stack
- **Java 17/21**
- **Spring Boot** (REST, Security, JPA)
- **MySQL** (Database)
- **Maven** (Build tool)
- **Postman** (API testing)

---

## ⚙️ Setup & Installation

### 1. Clone the Repository
```bash
git clone https://github.com/<your-username>/job_platform.git
cd job_platform
```

---

### 2. Configure Database
- **Create a database in MySQL:**
```bash
CREATE DATABASE job_platform_db;
```
- **Update your src/main/resources/application.properties:**
```bashspring.datasource.url=jdbc:mysql://localhost:3306/job_platform_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Run the Application
- **Use Maven Wrapper**
```bash
./mvnw spring-boot:run
```
- **Or using Maven directly:**
```bash
mvn spring-boot:run
```

**The server will start at:**
👉 ``` http://localhost:8080 ```

---

## ⚙️ Setup & Installation

### 🚀 Create Project with Spring Initializr

You can generate this project using Spring Initializr or directly via your IDE (IntelliJ IDEA / Eclipse / VS Code).

### 1. Go to Spring Initializr
👉 ```https://start.spring.io/```

---

### 2. Project Settings
- **Project:** Maven
- **Language:** Java
- **Spring Boot Version:** 2.7.15 (or latest LTS compatible with Java 17/21)
- **Project Metadata:**
  - **Group:** ```com.example```
  - **Artifact:** ```job_platform```
  - **Name:** ```job_platform```
  - **Package:** ```com.example.job_platform```
- **Java Version:** 17 (can also upgrade to 21 later)

---

### 2. Select Dependencies
- **Spring Boot Starts:**
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Validation
  - Spring Boot DevTools
  - Spring Boot Test

- **Database:** MySQL Driver
- **Cloud:**
  - Spring Cloud Config Server
  - Spring Cloud Config Client
  - Eureka Server
  - Eureka Discovery Client

- **other:**
  - **Spring Mail**
  - **Webflux (for reactive APIs)**
⚡ After generation, you’ll get a ZIP → unzip it and open in your IDE.

---

### 4. Import as Maven Project
- Open your IDE(IntelliJ/Eclipse).
- Select **Import Project → Maven**.
- Point to the unzipped folder.
- Maven will automatically download all dependencies from ```pom.xml```.

---

### 5. Run the Application
- **Use Maven Wrapper**
```bash
./mvnw spring-boot:run
```
- **Or using Maven directly:**
```bash
mvn spring-boot:run
```

**The server will start at:**
👉 ``` http://localhost:8080 ```

---

## 📬 API Endpoints (Test with Postman)
Here are some key endpoints (all responses are JSON):

### 🔑 Authentication
* **Register →** ```POST /api/auth/register```
* **Login →** ```POST /api/auth/login```

### 👤 Admin

* **Get all users →** ``` GET /api/admins/users```

* **Get users by role →** ```GET /api/admins/users/role?role=EMPLOYEE```

* **Update user status →** ```PUT /api/admins/users/status```

* **Get system status →** ```GET /api/admins/status```

### 👨‍💼 Employee

* **Get all employees →** ```GET /api/employees/allEmployees```

* **Get employee by email →** ```GET /api/employees/email/{email}```

* **Create employee →** ```POST /api/employees/create```

* **Update employee →** ```PUT /api/employees/update/{id}```

### 🏢 Recruiter

* **Get all recruiters →** ```GET /api/recruiters/allRecruiters```

* **Create recruiter →** ```POST /api/recruiters/save```

* **Update recruiter →** ```PUT /api/recruiters/update```

### 📄 Job Posts

* **Create job →** ```POST /api/jobposts```

* **Get all jobs →** ```GET /api/jobposts```

* **Search jobs by title →** ```GET /api/jobposts/search/title/{jobTitle}```

* **Delete job →** ```DELETE /api/jobposts/{id}```

### 📑 Applications

* **Get all applications →** ```GET /api/applications/allApplications```

* **Apply to job →** ```POST /api/applications/apply```

* **Update application status →** ```PUT /api/applications/status```

* **Delete application →** ```DELETE /api/applications/{id}```

### 📊 Analytics

* **Dashboard summary →** ```GET /api/dashBoard/summary```

### 📝 Audit Logs

* **Save log →** ```POST /api/auditLogs```

* **Get logs by module →** ```GET /api/auditLogs/log/module/{module}```

* **Get logs by actor →** ```GET /api/auditLogs/log/actor/{actor}```

### 📧 Notifications

* **Send email →** ```POST /api/notifications/email```

### 💳 Subscriptions

* **Create subscription →** ```POST /api/subscriptions```

* **Get all subscriptions →** ```GET /api/subscriptions/user```

* **Download invoice →** ```GET /api/subscriptions/invoice/{id}```

### 📤 File Uploads

* **Upload resume →** ```POST /api/uploadFiles/resume```

* **Upload certificate →** ```POST /api/uploadFiles/image```

* **Upload invoice →** ```POST /api/uploadFiles/invoice```

---

## 🧪 Testing with Postman

1. Import your endpoints manually into Postman or create a collection.
2. Use raw JSON in request body where applicable.
   Example (Register user):
```bash
{
  "username": "testuser",
  "password": "password123",
  "email": "testuser@example.com"
}
```
3. Check responses in Postman and verify results in your MySQL DB.

---

## 📂 Project Structure

src/main/java/com/example/job_platform
 ├── Controller      # REST controllers (API layer)  
 ├── DTO             # Data Transfer Objects  
 ├── Entity          # JPA entities  
 ├── Enum            # Enum definitions (Role, Status, etc.)  
 ├── Repository      # Spring Data JPA repositories  
 ├── Service         # Business logic services  
 └── Security        # Security, JWT, config  

