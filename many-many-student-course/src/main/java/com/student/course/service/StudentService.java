package com.student.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.course.dao.StudentDAO;
import com.student.course.pojo.Course;
import com.student.course.pojo.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public List<Student> addStudentWithCourseDetails(Student student) {
		return studentDAO.addStudentWithCourseDetails(student);
	}

	public Student searchBySudentId(Integer id) {
		return studentDAO.searchBySudentId(id);
	}

	public List<Student> getAllStudentsDetails() {
		return studentDAO.getAllStudentsDetails();
	}

	public List<Student> deleteStudentById(Integer id) {
		return studentDAO.deleteStudentById(id);
	}

	public List<Student> updateStudent(Student student) {
		return studentDAO.updateStudent(student);
	}

}
