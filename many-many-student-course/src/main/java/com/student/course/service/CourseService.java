package com.student.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.course.dao.CourseDAO;
import com.student.course.pojo.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDAO;

	public List<Course> addCoursetWithStudentDetails(Course course) {
		return courseDAO.addCoursetWithStudentDetails(course);
	}

	public Course searchByCourseId(Integer id) {
		return courseDAO.searchByCourseId(id);
	}

	public List<Course> getAllCourseDetails() {
		return courseDAO.getAllCourseDetails();
	}

	public List<Course> deleteCourseById(Integer id) {
		return courseDAO.deleteCourseById(id);
	}

	public List<Course> updateCourse(Course course) {
		return courseDAO.updateCourse(course);
	}

}
