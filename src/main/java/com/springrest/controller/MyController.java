package com.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Course;
import com.springrest.service.MyService;

@RestController
@CrossOrigin
public class MyController {

	@Autowired
	private MyService myService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> list = myService.getCourses();
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/courses/{course_id}")
	public ResponseEntity<Course> getCourse(@PathVariable("course_id") String courseId) {
			Course course= myService.getCourse(Long.parseLong(courseId));
			if(course==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.of(Optional.of(course));
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		try {
			this.myService.addCourse(course);
			return ResponseEntity.status(HttpStatus.CREATED).body(course);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/courses/{course_id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable("course_id") int courseId) {
		try {
			myService.updateCourse(course, courseId);
			return ResponseEntity.ok().body(course);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/courses/{course_id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("course_id") String courseId){
		try {
			this.myService.deleteCourse(Long.parseLong(courseId));
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
