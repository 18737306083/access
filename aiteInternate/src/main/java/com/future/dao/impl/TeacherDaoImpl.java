package com.future.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.dao.TeacherDao;
import com.future.domain.Admin;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月15日 上午9:41:27 
 * 类说明 
 */
@Repository
public class TeacherDaoImpl extends HibernateUtils implements TeacherDao {

	@Override
	public Teacher loginTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println(teacher+"sdao");
		String hql="From Teacher t where t.number_teacher = :count and t.pasword_teacher = :password";
		return (Teacher)geSession().createQuery(hql).setString("count", teacher.getNumber_teacher()).setString("password", teacher.getPasword_teacher()).uniqueResult();
   }

}
