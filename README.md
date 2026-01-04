# 📚 Smart Library Management System

A web-based **Smart Library Management System** developed using **Java, JSP, Servlets, Hibernate (JPA), and MySQL**.  
This application helps manage library operations such as **admin management, book management, and session handling** efficiently.

---

## 🚀 Features

### 👤 Admin Module
- Admin login and logout
- View admin profile
- Update admin details
- Delete admin account

### 📘 Book Management
- Add new books
- View all books
- View book by ID
- Update book details
- Delete books

### 🔐 Security & Session Management
- Session-based authentication
- Secure access to admin pages
- Proper redirects on logout and unauthorized access

---

## 🛠️ Tech Stack

| Layer       | Technology           |
|------------|---------------------|
| Backend     | Java, Servlets      |
| Frontend    | JSP, HTML, CSS      |
| ORM         | Hibernate (JPA)     |
| Database    | MySQL               |
| Server      | Apache Tomcat       |
| Build Tool  | Maven               |
| IDE         | Eclipse             |

---

## 🏗️ Project Architecture (Layered Design)

```
library_management_system_using_hibernate_jsp/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       ├── controller/    → Servlet controllers handling HTTP requests and responses
│       │       ├── dao/           → DAO layer; executes database operations using Hibernate
│       │       ├── dto/           → Entity classes representing database tables
│       │       └── util/          → Utility classes (e.g., JPA utility for EntityManager)
│       └── webapp/
│           ├── *.jsp              → JSP pages for user interface
│           ├── *.html             → Static HTML pages
│           └── *.css              → Stylesheets
├── pom.xml                        → Maven project configuration
└── persistence.xml                → JPA/Hibernate configuration
```

---

## 🔄 Application Flow

1. Admin logs into the system
2. Session is created after successful authentication
3. Admin can manage books and profile
4. Hibernate handles database operations
5. MySQL stores application data

---

## 📌 Future Enhancements

1. User role management  
2. Book issue and return module  
3. Search and pagination  
4. Password encryption  
5. Migration to Spring Boot  

---

## ⭐ Support

If you find this project useful, please ⭐ star the repository and share your feedback!
