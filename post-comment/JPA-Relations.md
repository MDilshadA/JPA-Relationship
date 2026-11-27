# JPA Relationship Notes

---

# 1. One-To-One

## Example

```text
Post <-------> PostDetails
```

```text
Post 1 -------- PostDetails 1
Post 2 -------- PostDetails 2
Post 3 -------- PostDetails 3
```

## Annotations

### Post

```java
@OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
private PostDetails postDetails;
```

### PostDetails

```java
@OneToOne
@JoinColumn(name = "postId", nullable = false)
@JsonIgnore
private Post post;
```

## Why @JoinColumn Here?

```java
@JoinColumn(name = "postId")
```

means foreign key is stored in:

```text
post_details table
```

```text
post_details

id
views
likes
postId
```

The entity containing `@JoinColumn` owns the relationship.

---

## Why mappedBy?

```java
mappedBy = "post"
```

means:

```text
Relationship is already managed by PostDetails.post
Do not create another foreign key.
```

---

## Why CascadeType.ALL?

```java
cascade = CascadeType.ALL
```

means:

```java
postRepository.save(post);
```

will automatically save:

```java
postDetails
```

also.

---

## Why @JsonIgnore?

```java
@JsonIgnore
private Post post;
```

prevents infinite recursion.

Without it:

```text
Post
 -> PostDetails
      -> Post
           -> PostDetails
                -> Post
```

Infinite Loop.

---

## Why nullable = false?

```java
@JoinColumn(name = "postId", nullable = false)
```

means:

```text
Every PostDetails must belong to a Post.
```

Database will not allow:

```text
postId = null
```

---

# 2. One-To-Many / Many-To-One

## Example

```text
Post <-------> Comment
```

```text
Post 1
 |
 |---- Comment 1
 |---- Comment 2
 |---- Comment 3
```

## Annotations

### Post

```java
@OneToMany(
        mappedBy = "post",
        cascade = CascadeType.ALL
)
private List<Comment> comments;
```

### Comment

```java
@ManyToOne
@JoinColumn(name = "post_id", nullable = false)
@JsonIgnore
private Post post;
```

---

## Why @ManyToOne in Comment?

```text
Many Comments belong to One Post.
```

```text
Comment -> Post
```

---

## Why @OneToMany in Post?

```text
One Post has Many Comments.
```

```text
Post -> List<Comment>
```

---

## Why @JoinColumn in Comment?

```java
@JoinColumn(name = "post_id")
```

creates:

```text
comments

id
message
post_id
```

Foreign key exists in child table.

Therefore:

```java
Comment
```

owns the relationship.

---

## Why mappedBy = "post"?

```java
mappedBy = "post"
```

points to:

```java
private Post post;
```

inside Comment.

Meaning:

```text
Comment already manages the relationship.
```

---

## Why @JsonIgnore in Comment?

Without it:

```text
Post
 -> Comments
      -> Post
           -> Comments
```

Infinite recursion.

Therefore:

```java
@JsonIgnore
private Post post;
```

---

# 3. Many-To-Many

## Example

```text
Student <-------> Course
```

```text
Student 1 ---- Java
Student 1 ---- Spring Boot

Student 2 ---- Java
Student 2 ---- Docker

Student 3 ---- Spring Boot
```

or

```text
                Java
               /    \
Student 1 ----        ---- Student 2

          Spring Boot
           /        \
Student 1            Student 3

              Docker
                |
            Student 2
```

---

## Annotations

### Student

```java
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```

### Course

```java
@ManyToMany(mappedBy = "courses")
@JsonIgnore
private List<Student> students;
```

---

## Why @JoinTable?

Many-To-Many cannot be represented using a single foreign key.

JPA automatically creates:

```text
student_courses
```

```text
student_id | course_id
----------------------
1          | 1
1          | 2
2          | 1
2          | 3
```

This table stores relationships.

---

## Why joinColumns?

```java
joinColumns = @JoinColumn(name = "student_id")
```

represents the current entity.

```text
Student
```

---

## Why inverseJoinColumns?

```java
inverseJoinColumns = @JoinColumn(name = "course_id")
```

represents the opposite entity.

```text
Course
```

---

## Why mappedBy = "courses"?

Points to:

```java
private List<Course> courses;
```

inside Student.

Meaning:

```text
Student owns relationship.
Course only references it.
```

---

## Why @JsonIgnore?

Without it:

```text
Student
   -> Courses
       -> Students
            -> Courses
```

Infinite recursion.

---

# Quick Revision

## One-To-One

```java
@OneToOne
@JoinColumn(...)
```

Foreign key in child table.

Example:

```text
Post -> PostDetails
```

---

## One-To-Many

```java
@OneToMany(mappedBy = ...)
```

Parent side.

Example:

```text
Post -> Comments
```

---

## Many-To-One

```java
@ManyToOne
@JoinColumn(...)
```

Child side.

Example:

```text
Comment -> Post
```

---

## Many-To-Many

```java
@ManyToMany
@JoinTable(...)
```

Creates third table.

Example:

```text
Student <-> Course
```

---

# Easiest Memory Trick

```text
@JoinColumn
=
Foreign Key Column

mappedBy
=
Relationship is managed by another entity

cascade = ALL
=
Save/Update/Delete child automatically

@JsonIgnore
=
Hide field from JSON and prevent recursion

nullable = false
=
Foreign key cannot be null

@JoinTable
=
Create third table for Many-To-Many
```