# Documentation

## Endpoints

| Método | Endpoint         | Descripción    |
| ------ | ---------------- | -------------- |
| POST   | /api/auth/singin | User auth.     |
| POST   | /api/auth/singup | User register. |
| GET    | /api/health      | API status     |

## Registration Flow

**Request Body**
<code>
{
"username": "username",
"password": "password",
"email": "email@example.com"
}
</code>

**Response Body**
<code>
{
"id": 2,
"email": "email@example.com",
"password": "encodePass",
"username": "username",
"role": "role",
"createAt": "date",
"updateAt": "date",
"authorities": [],
"accountNonExpired": boolean,
"accountNonLocked": boolean,
"credentialsNonExpired": boolean,
"enabled": boolean
}

</code>

## Login Flow

**Request Body**
<code>
{
"email": "email@example.com",
"password": "password"
}
</code>

**Response Body**
<code>
{
"token": "jwtToken",
"expire": expireMils
}
</code>
