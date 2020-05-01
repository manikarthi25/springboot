package com.student.course.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {

	@Id
	@Column(name = "course_id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_duration")
	private String courseDuration;
	
	@ManyToMany (mappedBy = "courseEntities")
	private List<StudentEntity> studentEntities;
	
}
