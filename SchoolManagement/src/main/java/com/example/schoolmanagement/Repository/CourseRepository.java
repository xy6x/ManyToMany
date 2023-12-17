package com.example.schoolmanagement.Repository;

import com.example.schoolmanagement.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}
