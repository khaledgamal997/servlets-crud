# Java User Management Web Application

This is a Java web application that allows you to manage users through a user interface (UI) and exposes APIs for CRUD operations (Create, Read, Update, Delete) on user data. The application is built using Java Servlets and JSP files, and it connects to a MySQL database to store user information.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat or any Java Servlet container
- MySQL database server

## Setup

1. Clone the repository to your local machine:

```
git clone 
```

2. Create a MySQL database and import the `user_management.sql` script located in the `db_scripts` directory to create the necessary table for user data.

3. Update the database configuration in the `db.properties` file located in the `src/main/resources` directory. Modify the database URL, username, and password according to your MySQL setup:

```
db.url=jdbc:mysql://localhost:3306/your_database_name
db.username=your_database_username
db.password=your_database_password
```

4. Build the project using your preferred build tool (e.g., Maven, Gradle).

5. Deploy the generated WAR file to your Apache Tomcat or any other Java Servlet container.

6. Access the application using the URL of your deployed application (e.g., `http://localhost:8080/user-management`).

## Features

### API Endpoints

The application exposes the following API endpoints to manage users:

- `GET /api/users`: Retrieves a list of all users in the database.
- `GET /api/users/{id}`: Retrieves a specific user by ID.
- `POST /api/users`: Creates a new user with the provided user data.
- `PUT /api/users/{id}`: Updates an existing user with the provided user data.
- `DELETE /api/users/{id}`: Deletes a user with the given ID.

### User Interface

The application provides a user-friendly web interface that allows you to interact with the user data. The UI is built using JSP files and enables you to perform the following operations:

- View a list of all users.
- View details of a specific user.
- Add a new user.
- Edit an existing user.
- Delete a user.



