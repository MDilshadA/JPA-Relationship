package com.post.comments.service.impl;

import com.post.comments.entity.Course;
import com.post.comments.entity.Student;
import com.post.comments.repository.CourseRepository;
import com.post.comments.repository.StudentRepository;
import com.post.comments.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    
    private final StudentRepository studentRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
}
