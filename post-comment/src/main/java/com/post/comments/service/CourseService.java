package com.post.comments.service;

import com.post.comments.entity.Course;
import com.post.comments.entity.Student;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long courseId);

}
