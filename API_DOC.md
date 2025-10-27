📘 API Documentation — NetworkingApp
🧩 Base URL
http://localhost:8080/api

🧑‍💻 Authentication Endpoints
1. Register a new user

POST /auth/register

📥 Request Body:
{
  "name": "Aman Soni",
  "email": "aman@example.com",
  "password": "123456"
}

📤 Response:

✅ 201 Created

{
  "id": 1,
  "name": "Aman Soni",
  "email": "aman@example.com"
}

2. Login user

POST /auth/login

📥 Request Body:
{
  "email": "aman@example.com",
  "password": "123456"
}

📤 Response:

✅ 200 OK

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
🔒 The token returned is a JWT that you’ll use to access secured endpoints.

3. Access protected endpoint (example)

GET /users/profile

🔑 Header:
Authorization: Bearer <your-jwt-token>

📤 Response:

✅ 200 OK

{
  "id": 1,
  "name": "Aman Soni",
  "email": "aman@example.com"
}

