package com.future.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.dao.DbUtils;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月22日 下午4:06:18 
 * 类说明 
 */
@Repository
public class DbDaoImpl extends HibernateUtils  implements DbUtils{

	@Override
	public int findTotal(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findTotalBylimit(Teacher teacher) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Teacher t where t.department = :department and t.title = :title and sex = :sex";
		System.out.println("shuchu1");

		Number s=(Number) geSession().createQuery(hql).setString("department", teacher.getDepartment()).setString("title", teacher.getTitle()).setString("sex", teacher.getSex()).uniqueResult();
		System.out.println(s.intValue()+"3333");
		System.out.println("shuchu2");
		return s.intValue();	
		
	}

}
