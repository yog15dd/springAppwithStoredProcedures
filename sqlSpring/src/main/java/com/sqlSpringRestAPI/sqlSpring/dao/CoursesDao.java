/**
 * 
 */
package com.sqlSpringRestAPI.sqlSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sqlSpringRestAPI.sqlSpring.entities.Course;


/**
 * @author Training
 *
 */
public interface CoursesDao extends JpaRepository<Course, Long>{
}