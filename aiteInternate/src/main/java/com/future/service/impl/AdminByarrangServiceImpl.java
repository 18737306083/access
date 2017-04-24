package com.future.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.future.dao.AdminByarrayDao;
import com.future.domain.Classes;
import com.future.domain.Course;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年4月20日 下午8:25:50 
 * 类说明 
 */
@Service
@Transactional
public class AdminByarrangServiceImpl implements AdminByarrayDao {
@Resource
AdminByarrayDao adminByarrayDao;
	
	
	
	@Override
	public List<Course> findByCourse(Classes classes) {
		// TODO Auto-generated method stub
		return null;
	}

}
