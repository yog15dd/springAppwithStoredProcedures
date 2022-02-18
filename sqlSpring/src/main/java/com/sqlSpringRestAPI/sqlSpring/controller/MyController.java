package com.sqlSpringRestAPI.sqlSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqlSpringRestAPI.sqlSpring.entities.Course;
import com.sqlSpringRestAPI.sqlSpring.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String getHome()
	{
		return "Welcome to Spring boot";
	}
	
	// get courses
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//  get one course
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
//  get one course
	@GetMapping("/courses-1/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return this.courseService.getCourseById(Long.parseLong(courseId));
	}
	
	// get courses by sorting via any attribute
	@GetMapping("/courses/sort/{field}")
	public List<Course> findBySorting(@PathVariable String field) {
		return this.courseService.findCourseBySorting(field);
	}
	
	// get courses by pagination
	@GetMapping("/courses/pagination/{offset}/{pagesize}")
	public Page<Course> findByPagination(@PathVariable int offset, @PathVariable int pagesize) {
		return this.courseService.findCourseByPagination(offset, pagesize);
	}
	
	// get courses by pagination and sorting both
	@GetMapping("/courses/paginationandsort/{offset}/{pagesize}/{field}")
	public Page<Course> findByPaginationAndSort(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
		return this.courseService.findCourseByPaginationAndSorting(offset, pagesize, field);
	}
	
	// add a course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		this.courseService.addCourse(course);
		return course;
	}
	
	// delete a course
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Long.parseLong(courseId));
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
}
