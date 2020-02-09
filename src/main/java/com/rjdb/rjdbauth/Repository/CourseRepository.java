package com.rjdb.rjdbauth.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rjdb.rjdbauth.model.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
//	public Course findByCourseName(String name);
}
