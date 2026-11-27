# Post API

## Create Post

URL

```http
POST http://localhost:8080/posts
```

Request 1

```json
{
  "author": "Arshaan",
  "title": "Spring JPA",
  "description": "Spring JPA Tutorial",
  "status": "ACTIVE"
}
```

Request 2

```json
{
  "author": "John",
  "title": "Spring Boot",
  "description": "Spring Boot Tutorial",
  "status": "ACTIVE"
}
```

Request 3

```json
{
  "author": "David",
  "title": "Microservices",
  "description": "Microservices Tutorial",
  "status": "INACTIVE"
}
```

Request 4

```json
{
  "author": "Dilshan",
  "title": "Docker",
  "description": "Docker Tutorial",
  "status": "ACTIVE"
}
```

---

## Get All Posts

```http
GET /posts
```

---

## Get Post By Id

```http
GET /posts/{id}
```

Example

```http
GET /posts/1
```

---

## Update Post

```http
PUT /posts/{id}
```

Example

```json
{
  "author": "Arshaan Updated",
  "title": "Spring Data JPA",
  "description": "Updated Description",
  "status": "ACTIVE"
}
```

---

## Delete Post

```http
DELETE /posts/{id}
```

Example

```http
DELETE /posts/1
```

# Comment API

## Create Comment

URL

```http
POST /comments
```

Request 1

```json
{
  "author": "Arshaan",
  "message": "Good Tutorial"
}
```

Request 2

```json
{
  "author": "John",
  "message": "Very Helpful"
}
```

Request 3

```json
{
  "author": "David",
  "message": "Nice Explanation"
}
```

Request 4

```json
{
  "author": "Dilshan",
  "message": "Easy To Understand"
}
```

---

## Get All Comments

```http
GET /comments
```

---

## Get Comment By Id

```http
GET /comments/{id}
```

Example

```http
GET /comments/1
```

---

## Update Comment

```http
PUT /comments/{id}
```

Example

```json
{
  "commenterName": "Updated User",
  "message": "Updated Comment"
}
```

---

## Delete Comment

```http
DELETE /comments/{id}
```

Example

```http
DELETE /comments/1
```

## PostDetails API

URL

```http
POST /{postId}/details
```

Request 1

```json
{
  "author": "Arshaan",
  "title": "Spring JPA",
  "description": "Spring JPA Tutorial",
  "status": "ACTIVE",
  "postDetails": {
    "views": 100,
    "likes": 20,
    "publishedDate": "2026-11-26"
  }
}
```

Request 2

```json
{
  "author": "Dilshan",
  "title": "Spring Boot",
  "description": "Spring Boot Tutorial",
  "status": "ACTIVE",
  "postDetails": {
    "views": 250,
    "likes": 75,
    "publishedDate": "2026-11-25"
  }
}
```

Request 2

```json
{
  "author": "John",
  "title": "Microservices",
  "description": "Microservices Tutorial",
  "status": "INACTIVE",
  "postDetails": {
    "views": 500,
    "likes": 120,
    "publishedDate": "2026-11-20"
  }
}
```


# Create Post Details

## Request 1

URL

```http
POST /posts/1/details
```

Body

```json
{
  "views": 100,
  "likes": 20,
  "publishedDate": "2026-11-26"
}
```

---

## Request 2

URL

```http
POST /posts/2/details
```

Body

```json
{
  "views": 250,
  "likes": 50,
  "publishedDate": "2026-11-25"
}
```

---

## Request 3

URL

```http
POST /posts/3/details
```

Body

```json
{
  "views": 500,
  "likes": 120,
  "publishedDate": "2026-11-24"
}
```
