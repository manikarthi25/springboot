package com.student.course.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.course.entity.CourseEntity;
import com.student.course.entity.StudentEntity;
import com.student.course.pojo.Course;
import com.student.course.pojo.Student;
import com.student.course.repository.CourseRepository;
import com.student.course.repository.StudentRepository;

@Repository
public class StudentDAO {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public List<Student> addStudentWithCourseDetails(Student student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentName(student.getStudentName());

		List<CourseEntity> courseEntityList = new ArrayList<>();
		for (Course course : student.getCourseList()) {
			CourseEntity courseEntity = new CourseEntity();
			courseEntity.setCourseName(course.getCourseName());
			courseEntity.setCourseDuration(course.getCourseDuration());
			courseRepository.save(courseEntity);
			courseEntityList.add(courseEntity);
		}

		studentEntity.setCourseEntities(courseEntityList);

		studentRepository.save(studentEntity);

		List<StudentEntity> studentEntityList = studentRepository.findAll();
		List<Student> studentList = new ArrayList<>();
		for (StudentEntity studentEnti : studentEntityList) {
			Student stu = getStudentsDetailsFromEntity(studentEnti);
			studentList.add(stu);
		}
		return studentList;
	}

	public Student searchBySudentId(Integer id) {
		Optional<StudentEntity> optLocalityEntity = studentRepository.findById(id);
		Student student = new Student();
		if (optLocalityEntity.isPresent()) {
			student = getStudentsDetailsFromEntity(optLocalityEntity.get());
		}
		return student;
	}

	public List<Student> getAllStudentsDetails() {
		return getAllStudentsDetail();
	}

	public List<Student> deleteStudentById(Integer id) {
		Optional<StudentEntity> optStudentEntity = studentRepository.findById(id);
		if (optStudentEntity.isPresent()) {
			studentRepository.deleteById(id);
		}
		return getAllStudentsDetail();
	}

	private Student getStudentsDetailsFromEntity(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setStudentName(studentEntity.getStudentName());
		List<Course> courseList = new ArrayList<>();
		for (CourseEntity courseEntity : studentEntity.getCourseEntities()) {
			Course course = new Course();
			course.setId(courseEntity.getId());
			course.setCourseName(courseEntity.getCourseName());
			course.setCourseDuration(courseEntity.getCourseDuration());
			courseList.add(course);
		}
		student.setCourseList(courseList);
		return student;
	}

	private List<Student> getAllStudentsDetail() {
		List<StudentEntity> studenEnttityList = studentRepository.findAll();
		List<Student> studetList = new ArrayList<>();
		for (StudentEntity studentEntity : studenEnttityList) {
			Student stu = getStudentsDetailsFromEntity(studentEntity);
			studetList.add(stu);
		}
		return studetList;
	}

	public List<Student> updateStudent(Student student) {
		Optional<StudentEntity> optStudentEntity = studentRepository.findById(student.getId());
		if (optStudentEntity.isPresent()) {
			StudentEntity studentEntity = optStudentEntity.get();
			studentEntity.setStudentName(student.getStudentName());

			List<CourseEntity> courseEntityList = new ArrayList<>();
			for (Course course : student.getCourseList()) {
				CourseEntity courseEntity = new CourseEntity();
				courseEntity.setCourseName(course.getCourseName());
				courseEntity.setCourseDuration(course.getCourseDuration());
				courseRepository.saveAndFlush(courseEntity);
				courseEntityList.add(courseEntity);
			}

			studentEntity.setCourseEntities(courseEntityList);

			studentRepository.saveAndFlush(studentEntity);
		}
		return getAllStudentsDetail();
	}
}
