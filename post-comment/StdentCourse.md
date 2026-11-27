# Student API

## Create Student 1

```json
{
  "name": "Dilshan",
  "email": "dilshan@gmail.com"
}
```

## Create Student 2

```json
{
  "name": "Arshaan",
  "email": "arshaan@gmail.com"
}
```

## Create Student 3

```json
{
  "name": "John",
  "email": "john@gmail.com"
}
```

---

# Course API

## Create Course 1

```json
{
  "courseName": "Java",
  "instructor": "Zeeshaan"
}
```

## Create Course 2

```json
{
  "courseName": "Spring Boot",
  "instructor": "Zeeshaan"
}
```

## Create Course 3

```json
{
  "courseName": "Docker",
  "instructor": "Zeeshaan"
}
```


## Create Course 4

```json
{
  "courseName": "Kafka",
  "instructor": "Shamerin"
}
```

---

# Associate Student with Course

## Student 1 -> Course 1

```http
POST /students/1/courses/1
```

## Student 1 -> Course 2

```http
POST /students/1/courses/2
```

## Student 2 -> Course 1

```http
POST /students/2/courses/1
```

## Student 2 -> Course 3

```http
POST /students/2/courses/3
```

## Student 3 -> Course 2

```http
POST /students/3/courses/2
```