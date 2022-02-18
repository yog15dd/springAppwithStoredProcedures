/**
 * 
 */
package com.sqlSpringRestAPI.sqlSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sqlSpringRestAPI.sqlSpring.entities.Course;

/**
 * @author 33000005
 *
 */
@Repository
public class CoursesDaoImpl{

	/**
	 * 
	 */
	
    @Autowired
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public Course getCourseById(long id) {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = em.createStoredProcedureQuery("getAge", "Course")
				.registerStoredProcedureParameter("id", Long.class, ParameterMode.IN)
				.setParameter("id", id);
		query.execute();
		List<Course> list = query.getResultList();
		return list.get(0);
	}

}
