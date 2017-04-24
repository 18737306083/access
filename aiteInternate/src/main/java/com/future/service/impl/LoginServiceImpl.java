package com.future.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.future.dao.AdminDao;
import com.future.dao.StudentDao;
import com.future.dao.TeacherDao;
import com.future.dao.impl.AdminDaolmpl;
import com.future.domain.Admin;
import com.future.domain.Student;
import com.future.domain.Teacher;
import com.future.service.LoginService;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月13日 上午10:55:43 
 * 类说明 
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource
	AdminDao adminDao;
	@Resource
	StudentDao studentDao;
	@Resource
	TeacherDao teacherDao;
	
	@Override
	public Student loginByStudent(Student student) {
		// TODO Auto-generated method stub
		Student student1=studentDao.login(student);
		
		return student1;
	}

	@Override
	public Teacher loginByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println(teacher+"service");
		Teacher teacher1=teacherDao.loginTeacher(teacher);
		
		
		return teacher1;
	}

	@Override
	public Admin getloginByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admin==null) return null;
		else {
			System.out.println("service11");
			 
		Admin admin1=adminDao.getloginAdmin(admin);
		System.out.println(admin1);
		return admin1;
			
		}
		
		 
	
	}

	@Override
	public void insert(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.insert(admin);
	}

	 

}
