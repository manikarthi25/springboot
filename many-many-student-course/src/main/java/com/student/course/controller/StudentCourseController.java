package com.student.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.course.pojo.Course;
import com.student.course.pojo.Student;
import com.student.course.service.CourseService;
import com.student.course.service.StudentService;

@RestController
public class StudentCourseController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to Springboot - One to Many Relation Example";
	}

	@PostMapping("/addstudent")
	public List<Student> addStudentWithCourseDetails(@RequestBody Student student) {
		return studentService.addStudentWithCourseDetails(student);
	}

	@PostMapping("/addcourse")
	public List<Course> addCoursetWithStudentDetails(@RequestBody Course course) {
		return courseService.addCoursetWithStudentDetails(course);
	}

	@GetMapping("/searchstudent/{id}")
	public Student searchBySudentId(@PathVariable Integer id) {
		return studentService.searchBySudentId(id);
	}

	@GetMapping("/searchcourse/{id}")
	public Course searchByCourseId(@PathVariable Integer id) {
		return courseService.searchByCourseId(id);
	}

	@GetMapping("/searchstudent/all")
	public List<Student> getAllStudentsDetails() {
		return studentService.getAllStudentsDetails();
	}

	@GetMapping("/searchcourse/all")
	public List<Course> getAllCourseDetails() {
		return courseService.getAllCourseDetails();
	}

	@DeleteMapping("/deletestudent/{id}")
	public List<Student> deleteStudentById(@PathVariable Integer id) {
		return studentService.deleteStudentById(id);
	}

	@DeleteMapping("/deletecourse/{id}")
	public List<Course> deleteCourseById(@PathVariable Integer id) {
		return courseService.deleteCourseById(id);
	}

	@PutMapping("/updatestudent")
	public List<Student> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@PutMapping("/updatecourse")
	public List<Course> updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}

}
