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
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.CourseService#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses(){		
		return (List<Course>) courseRepository.findAll();
	}
	
	
	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.CourseService#getCourse(java.lang.String)
	 */
	@Override
	public Course getCourse(String id) {
		 return courseRepository.findById(id).get();
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.CourseService#addCourse(com.rjdb.rjdbauth.model.Course)
	 */
	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.CourseService#updateCourse(java.lang.String, com.rjdb.rjdbauth.model.Course)
	 */
	@Override
	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}


	/* (non-Javadoc)
	 * @see com.rjdb.rjdbauth.service.CourseService#deleteCourse(java.lang.String)
	 */
	@Override
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
