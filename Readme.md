# Todo List API

## Overview
This project is a RESTful API for managing a to-do list. It includes user authentication and CRUD operations for to-do items, ensuring secure access control. The API supports user registration, login, and task management with proper validation, error handling, and pagination.

## Features
- User authentication (Registration & Login)
- JWT-based authentication
- CRUD operations for to-do items
- Secure access control
- Error handling & data validation
- Pagination & filtering for to-do items

## Technologies Used
- Spring Boot
- PostgreSQL
- JSON Web Tokens (JWT) for authentication
- bcrypt for password hashing

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/todo-api.git
   cd todo-api
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Configure the `application.properties` file with necessary environment variables (e.g., database connection, JWT secret key).
4. Start the server:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### User Authentication

#### Register a new user
- **Endpoint:** `POST /register`
- **Request Body:**
  ```json
  {
    "name": "John Doe",
    "email": "john@doe.com",
    "password": "password"
  }
  ```
- **Response:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
  }
  ```

#### User Login
- **Endpoint:** `POST /login`
- **Request Body:**
  ```json
  {
    "email": "john@doe.com",
    "password": "password"
  }
  ```
- **Response:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
  }
  ```

### To-Do List Management

#### Create a To-Do Item
- **Endpoint:** `POST /todos`
- **Headers:** `Authorization: Bearer <token>`
- **Request Body:**
  ```json
  {
    "title": "Buy groceries",
    "description": "Buy milk, eggs, and bread"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "title": "Buy groceries",
    "description": "Buy milk, eggs, and bread"
  }
  ```

#### Update a To-Do Item
- **Endpoint:** `PUT /todos/{id}`
- **Headers:** `Authorization: Bearer <token>`
- **Request Body:**
  ```json
  {
    "title": "Buy groceries",
    "description": "Buy milk, eggs, bread, and cheese"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "title": "Buy groceries",
    "description": "Buy milk, eggs, bread, and cheese"
  }
  ```

#### Delete a To-Do Item
- **Endpoint:** `DELETE /todos/{id}`
- **Headers:** `Authorization: Bearer <token>`
- **Response:**
  ```json
  {
    "message": "Deleted successfully"
  }
  ```

#### Get To-Do Items
- **Endpoint:** `GET /todos?page=1&limit=10`
- **Headers:** `Authorization: Bearer <token>`
- **Response:**
  ```json
  {
    "data": [
      {
        "id": 1,
        "title": "Buy groceries",
        "description": "Buy milk, eggs, bread"
      },
      {
        "id": 2,
        "title": "Pay bills",
        "description": "Pay electricity and water bills"
      }
    ],
    "page": 1,
    "limit": 10,
    "total": 2
  }
  ```

## Security Measures
- Password hashing using bcrypt
- JWT-based authentication
- User authorization for CRUD operations

