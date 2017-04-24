package com.future.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.future.dao.StudentDao;
import com.future.domain.Course;
import com.future.domain.Student;
import com.future.domain.TvEvaluation;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月5日 上午10:37:32 
 * 类说明 
 */
@Repository
public class StudentDaoImpl extends HibernateUtils implements StudentDao {

	@Override
	public Student login(Student student) {
		// TODO Auto-generated method stub
		String hql="From Student s where s.number = :number and s.password = :password";
		
		return (Student) geSession().createQuery(hql).setString("number", student.getNumber()).setString("password", student.getPassword()).uniqueResult();
	}

	@Override
	public List<Student> findStudentByAll(Student student) {
		// TODO Auto-generated method stub
		String hql="From ";
		
		return null;
	}
	 //查询个人成绩
	@Override
	public List findScores(Student student) {
		// TODO Auto-generated method stub
		String hql="from Student s join fetch s.course c join fetch c.scores where s.number=:number";
	 
		return geSession().createQuery(hql).setString("number", student.getNumber()).list();
	}
//选课
	@Override
	public void selectCourse(Student student, Course course) {
		// TODO Auto-generated method stub
	/*	student.getCourse().add(course);*/
		geSession().saveOrUpdate(course);
		
		
	}
//评教
	@Override
	public void evaLuation(Course course, TvEvaluation tv) {
		// TODO Auto-generated method stub
		tv.setCourse(course);
		geSession().saveOrUpdate(course);
		
	}

	 
	 

}
