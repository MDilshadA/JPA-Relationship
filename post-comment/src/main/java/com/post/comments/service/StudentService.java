package com.post.comments.service;

import com.post.comments.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents(Long courseId);

    Student getStudentById(Long studentId);


    Student addCourseToStudent(Long studentId, Long courseId);

}
