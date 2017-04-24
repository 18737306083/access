package com.future.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月5日 下午7:57:30 
 * 类说明 
 */
@Repository
public class HibernateUtils {
	 @Autowired
private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	 public Session geSession(){
			
		 return sessionFactory.getCurrentSession();
		 
		 
	 };




	
	
}
