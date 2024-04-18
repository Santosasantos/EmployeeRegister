# EmployeeRegister Application

EmployeeRegister is a Spring Boot application for managing employee details.

## Features

- Create, read, update, and delete employee details.
- Update specific fields before deleting an employee.
- Integration with PostgreSQL database.
- RESTful API endpoints for CRUD operations.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK)
- PostgreSQL database
- Maven

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Santosasantos/employee-register.git
    ```

2. **Configure PostgreSQL:**

    - Create a PostgreSQL database and note down the database URL, username, and password.
    - Update the `application.properties` file in `src/main/resources` directory with your database connection details:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Run the application:**

   Navigate to the project directory and run the following command:

    ```bash
    mvn spring-boot:run
    ```

4. **Access the application:**

   Open your web browser and go to http://localhost:8080 to access the application.

## Usage

- Use the provided RESTful API endpoints to perform CRUD operations on employee details.
- Refer to the API documentation for more details on available endpoints and request/response formats.

## API Documentation

- API documentation is available at http://localhost:8080/swagger-ui.html after running the application.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please create an issue or submit a pull request.


