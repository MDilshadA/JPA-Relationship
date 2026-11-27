package com.post.comments.controller;


import com.post.comments.entity.Student;
import com.post.comments.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) Long courseId) {
        return studentService.getAllStudents(courseId);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }


    //http://localhost:8080/students/1/courses/1
    @PostMapping("/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.addCourseToStudent(studentId, courseId);
    }
}
