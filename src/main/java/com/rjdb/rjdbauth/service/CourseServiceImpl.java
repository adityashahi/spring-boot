package com.rjdb.rjdbauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjdb.rjdbauth.Repository.CourseRepository;
import com.rjdb.rjdbauth.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	

	@Override
	public List<Course> getAllCourses(){		
		return (List<Course>) courseRepository.findAll();
	}
	
	

	@Override
	public Course getCourse(String id) {
		 return courseRepository.findById(id).get();
	}
	
//	@Override
//	public Course getCourseByName(String name) {
//		 return courseRepository.findByCourseName(name);
//	}


	@Override
	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}



	@Override
	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}


	@Override
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
}