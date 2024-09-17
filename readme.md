# Documentation

## Endpoints

| Método | Endpoint         | Descripción    |
| ------ | ---------------- | -------------- |
| POST   | /api/auth/singin | User auth.     |
| POST   | /api/auth/singup | User register. |
| GET    | /api/health      | API status     |

## Registration Flow

**Request Body**

```
{
  "username": "username",
  "password": "password",
  "email": "email@example.com"
}
```

**Response Body**

```
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
```

## Login Flow

**Request Body**

```
{
  "email": "email@example.com",
  "password": "password"
}
```

**Response Body**

```
{
  "token": "jwtToken",
  "expire": expireMils
}
```
