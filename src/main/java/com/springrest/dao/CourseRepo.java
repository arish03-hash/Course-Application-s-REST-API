package com.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{
	
	public Course findById(long id);
}
