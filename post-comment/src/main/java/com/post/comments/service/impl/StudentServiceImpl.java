package com.post.comments.service.impl;

import com.post.comments.entity.Course;
import com.post.comments.entity.Student;
import com.post.comments.repository.CourseRepository;
import com.post.comments.repository.StudentRepository;
import com.post.comments.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(Long courseId) {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null) {
            student.getCourses().add(course);
            studentRepository.save(student);
            return student;
        }

        return null;
    }
}
