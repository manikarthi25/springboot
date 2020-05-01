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
public class CourseDAO {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> addCoursetWithStudentDetails(Course course) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseName(course.getCourseName());
		courseEntity.setCourseDuration(course.getCourseDuration());

		List<StudentEntity> studentEntityList = new ArrayList<>();
		for (Student student : course.getStudentList()) {
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setStudentName(student.getStudentName());
			studentRepository.save(studentEntity);
			studentEntityList.add(studentEntity);
		}

		courseEntity.setStudentEntities(studentEntityList);
		courseRepository.save(courseEntity);

		List<CourseEntity> courseEntityList = courseRepository.findAll();
		List<Course> courseList = new ArrayList<>();
		for (CourseEntity courseEnti : courseEntityList) {
			Course cou = getCourseDetailsFromEntity(courseEnti);
			courseList.add(cou);
		}
		return courseList;
	}

	public Course searchByCourseId(Integer id) {
		Optional<CourseEntity> optCourseEntity = courseRepository.findById(id);
		Course course = new Course();
		if (optCourseEntity.isPresent()) {
			course = getCourseDetailsFromEntity(optCourseEntity.get());
		}
		return course;
	}

	public List<Course> getAllCourseDetails() {
		return getAllCourseDetail();
	}

	public List<Course> deleteCourseById(Integer id) {
		Optional<CourseEntity> optCourseEntity = courseRepository.findById(id);
		if (optCourseEntity.isPresent()) {
			courseRepository.deleteById(id);
		}
		return getAllCourseDetails();
	}

	private Course getCourseDetailsFromEntity(CourseEntity courseEntity) {
		Course course = new Course();
		course.setId(courseEntity.getId());
		course.setCourseName(courseEntity.getCourseName());
		course.setCourseDuration(courseEntity.getCourseDuration());
		List<StudentEntity> studentEntityList = courseEntity.getStudentEntities();

		List<Student> studentList = new ArrayList<>();
		for (StudentEntity studentEntity : studentEntityList) {
			Student student = new Student();
			student.setId(studentEntity.getId());
			student.setStudentName(studentEntity.getStudentName());
			studentList.add(student);
		}
		course.setStudentList(studentList);
		return course;
	}

	private List<Course> getAllCourseDetail() {
		List<CourseEntity> courseEnttityList = courseRepository.findAll();
		List<Course> courseList = new ArrayList<>();
		for (CourseEntity courseEntity : courseEnttityList) {
			Course cou = getCourseDetailsFromEntity(courseEntity);
			courseList.add(cou);
		}
		return courseList;
	}

	public List<Course> updateCourse(Course course) {
		Optional<CourseEntity> optCourseEntity = courseRepository.findById(course.getId());
		if (optCourseEntity.isPresent()) {
			CourseEntity coursestudentEntity = optCourseEntity.get();
			coursestudentEntity.setCourseName(course.getCourseName());
			coursestudentEntity.setCourseDuration(course.getCourseDuration());

			List<StudentEntity> studentEntityList = new ArrayList<>();
			for (Student student : course.getStudentList()) {
				StudentEntity studentEntity = new StudentEntity();
				studentEntity.setStudentName(student.getStudentName());
				studentRepository.saveAndFlush(studentEntity);
				studentEntityList.add(studentEntity);
			}

			coursestudentEntity.setStudentEntities(studentEntityList);

			courseRepository.saveAndFlush(coursestudentEntity);
		}
		return getAllCourseDetails();
	}

}
