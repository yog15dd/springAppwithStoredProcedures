package com.sqlSpringRestAPI.sqlSpring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sqlSpringRestAPI.sqlSpring.dao.CoursesDao;
import com.sqlSpringRestAPI.sqlSpring.dao.CoursesDaoImpl;
import com.sqlSpringRestAPI.sqlSpring.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CoursesDao courseDao;
	
	@Autowired
	private CoursesDaoImpl courseDaoImpl;
	//private List<Course> list;
	
//	public CourseServiceImpl() {
////		list = new ArrayList<>();
////		list.add(new Course(142, "Angular Course", "A basic introduction in Angular"));
////		list.add(new Course(143, "Java Core Course", "A basic introduction in Java Programming"));
////		list.add(new Course(144, "React.js Course", "A complete course in React.js library"));
////		list.add(new Course(145, "Node.js Course", "A complete reference in Node.js"));
//	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course crs = null;
//		for(Course c: list) {
//			if(c.getId() == courseId) {
//				crs = c;
//				break;
//			}
//		}
//		return crs;
		
		return courseDao.findById(courseId);
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course);
	}

	@Override
	public String deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<>();
		list = courseDao.findAll();
		for(Course c: list) {
			if(c.getId() == courseId) {
//				list.remove(c);
				courseDao.delete(c);
				return "Deletion Succeded";
			}
		}
		
		return "Deletion can't occur";
		
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course crs = null;
		List<Course> list = new ArrayList<>();
		list = courseDao.findAll();
		for(Course c: list) {
			if(c.getId() == course.getId()) {
//				list.remove(c);
//				c.setCourseName(course.getCourseName());
//				c.setDescription(course.getDescription());
//				list.add(c);
				courseDao.save(course);
				crs = course;
				break;
			}
		}
		return crs;
		
	}

	@Override
	public List<Course> findCourseBySorting(String field) {
		// TODO Auto-generated method stub
		return courseDao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Course> findCourseByPagination(int offset, int pagesize) {
		// TODO Auto-generated method stub
		return courseDao.findAll(PageRequest.of(offset, pagesize));
	}

	@Override
	public Page<Course> findCourseByPaginationAndSorting(int offset, int pagesize, String field) {
		// TODO Auto-generated method stub
		return courseDao.findAll(PageRequest.of(offset, pagesize, Sort.by(Sort.Direction.ASC, field)));
	}

	@Override
	public Course getCourseById(long courseId) {
		// TODO Auto-generated method stub
		return courseDaoImpl.getCourseById(courseId);
	}
	
	

}
