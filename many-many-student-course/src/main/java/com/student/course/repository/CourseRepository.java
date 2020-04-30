package com.student.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.course.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}
