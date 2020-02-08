package com.rjdb.rjdbauth.service;

import java.util.List;

import com.rjdb.rjdbauth.model.Course;

public interface CourseService {

	List<Course> getAllCourses();

	Course getCourse(String id);

	void addCourse(Course course);

	void updateCourse(String id, Course course);

	void deleteCourse(String id);

}