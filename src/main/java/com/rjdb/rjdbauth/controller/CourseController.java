package com.rjdb.rjdbauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rjdb.rjdbauth.model.Course;
import com.rjdb.rjdbauth.model.Topic;
import com.rjdb.rjdbauth.service.CourseService;
import com.rjdb.rjdbauth.service.TopicServiceImpl;

@RestController
@RequestMapping("/v1")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/course")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
		}
	
	@RequestMapping("/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}
	
//	@PostMapping("/topics")
	@RequestMapping(method=RequestMethod.POST, value="/course")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id) {
		courseService.updateCourse(id, course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
