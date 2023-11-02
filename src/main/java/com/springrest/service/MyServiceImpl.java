package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseRepo;
import com.springrest.model.Course;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public List<Course> getCourses() {
		List<Course> courses = (List)courseRepo.findAll();
		return courses;
	}

	@Override
	public Course getCourse(long courseId) {
		Course course = null;
		try {
			course = courseRepo.findById(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public Course addCourse(Course course) {
		courseRepo.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course, long courseId) {
		course.setId(courseId);
		courseRepo.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		courseRepo.deleteById(courseId);
	}

}
