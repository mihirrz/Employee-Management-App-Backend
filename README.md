# Employee Management App Backend

This is the backend of the Employee Management App, a platform for managing employee information, roles, and authentication. The backend is built using **Spring Boot** and **H2 Database**.

## Features

- Add, update, fetch, and delete employee records
- Role-based authentication and authorization
- Password encryption and secure handling of user data
- API endpoints for managing employees
- ApiResponse: For all general success and failure responses.
- ApiErrorResponse: For structured error messages when something goes wrong (e.g., 404 Not Found, 500 Internal Server Error).
- ErrorDetails: Specifically for detailed field-level validation errors.

## Technologies Used

- **Spring Boot**: Framework for building the backend
- **H2 Database**: In-memory database for development and testing
- **Spring Security**: For authentication and authorization
- **Maven**: For dependency management and building the project
- **Lombok**: For reducing boilerplate code (Lombok is not working in my IDE, debugging in progress)

## Setup Instructions

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/mihirrz/Employee-Management-App-Backend.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Employee-Management-App-Backend
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```


## API Endpoints

### Create a New Employee
- **URL**: `POST /api/employee/createNewEmployee`
- **Request Body**:
  ```json
  {
    "employeeFirstName": "Mihir",
    "employeeLastName": "Raj",
    "employeeContactNumber": "1234567890",
    "employeeEmail": "mihirraj@52gmail.com",
    "employeeRole": "ADMIN",
    "employeeDesignation": "Developer",
    "password": "admin123"
  }
  ```

### Get All Employees
- **URL**: `GET /api/employee/employeesList`

### Update an Employee
- **URL**: `PUT /api/employee/updateEmployee/{id}`
- **Request Body**:
  ```json
  {
    "employeeFirstName": "UpdatedFirstName",
    "employeeLastName": "UpdatedLastName",
    "employeeContactNumber": "9876543210",
    "employeeEmail": "updatedemail@example.com",
    "employeeRole": "USER",
    "employeeDesignation": "Tester",
    "password": "newpassword"
  }
  ```

### Delete an Employee
- **URL**: `DELETE /api/employee/deleteEmployee/{id}`

## Using POSTMAN

You can test the API endpoints using **POSTMAN** with Basic Authentication. The authentication credentials are specified in the `application.yaml` file as follows:

```yaml
    admin:
      username: admin
      password: admin123
    user:
      username: user
      password: user123
```

### Steps:

1. Open POSTMAN and create a new request.
2. For each API endpoint, set the **Authorization** type to **Basic Auth**.
3. Enter the following credentials:
   - **Username**: `admin`
   - **Password**: `admin123`
4. Test the endpoints by providing the required input and headers as described in the API section.

## Contribution

Feel free to fork this repository and submit pull requests for any enhancements or bug fixes. For major changes, please open an issue first to discuss what you would like to change.


---

### Author

Developed by **Mihir Raj**. For any queries or support, reach out at [mihirraj52@gmail.com](mailto:mihirraj52@gmail.com).
