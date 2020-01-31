package com.rjdb.rjdbauth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjdb.rjdbauth.Repository.CourseRepository;
import com.rjdb.rjdbauth.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){		
		return (List<Course>) courseRepository.findAll();
	}
	
	
	public Course getCourse(String id) {
		 return courseRepository.findById(id).get();
	}


	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}


	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
