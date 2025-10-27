NetworkApp Backend API Documentation
1. Authentication
1.1 Register

URL: /auth/register

Method: POST

Headers: Content-Type: application/json

Request Body:

{
  "username": "aman",
  "email": "aman@example.com",
  "password": "123456"
}


Response: 200 OK if successful

Notes: Creates a new user.

1.2 Login

URL: /auth/login

Method: POST

Headers: Content-Type: application/json

Request Body:

{
  "email": "aman@example.com",
  "password": "123456"
}


Response:

{
  "token": "<JWT_TOKEN>"
}


Notes: Returns JWT token to be used for protected endpoints.

2. User Management
2.1 Get Profile

URL: /user/profile

Method: GET

Headers:
Authorization: Bearer <JWT_TOKEN>

Response:

{
  "id": 1,
  "username": "aman",
  "email": "aman@example.com",
  "bio": "Hello world",
  "profilePicture": "profile_pic_url"
}

2.2 Update Profile

URL: /user/profile/update

Method: PUT

Headers:
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

Request Body:

{
  "username": "newname",
  "bio": "Updated bio",
  "profilePicture": "new_pic_url"
}


Response: Updated profile object (same as GET /user/profile)

3. Notes

All endpoints except /auth/register and /auth/login are protected, JWT required.

Use Postman or any API client to test requests without frontend.