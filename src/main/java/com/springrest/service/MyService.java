package com.springrest.service;

import java.util.List;

import com.springrest.model.Course;

public interface MyService {
	
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course, long courseId);
	
	public void deleteCourse(long courseId);
	
}
