package com.future.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
 

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.future.dao.AdminDao;
import com.future.dao.DbUtils;
import com.future.domain.Admin;
import com.future.domain.Classes;
import com.future.domain.Student;
import com.future.domain.Teacher;
import com.future.service.AdminManager;
 

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月7日 上午10:26:42 
 * 类说明 
 */
@Service
@Transactional 
public class AdminServiceImpl implements AdminManager {
	@Resource
private AdminDao adminDaoImpl;
	@Resource
	private DbUtils dbUtils;
	
	
	public DbUtils getDbUtils() {
		return dbUtils;
	}



	public void setDbUtils(DbUtils dbUtils) {
		this.dbUtils = dbUtils;
	}



	public AdminDao getAdminDaoImpl() {
	return adminDaoImpl;
}



public void setAdminDaoImpl(AdminDao adminDaoImpl) {
	this.adminDaoImpl = adminDaoImpl;
}

//管理员登录

	@Override
	public  Admin  loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admin==null) return null;
		else return getAdminDaoImpl().getloginAdmin(admin);
		 
	}

//查找学生

	@Override
	public List<Student> findStudent(int init,int pageSize) {
		// TODO Auto-generated method stub
		
		
		
		
		return getAdminDaoImpl().findStudentByPages(0, 5);
	}


//添加学生
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		getAdminDaoImpl().addStudent(student);
	}


//查找教师
	@Override
	public List<Teacher> findTeacher(int first,int max,Teacher teacher) {
		// TODO Auto-generated method stub
		
		return getAdminDaoImpl().findTeacher(first, max,teacher);
	}

//添加教师

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getAdminDaoImpl().addTacher(teacher);
	}



	@Override
	public void modifyStudent(Student student) {
		// TODO Auto-generated method stub
		getAdminDaoImpl().updateStudent(student);
		
		
		
		
	}
//删除教师
	public void deleteTeacher(Teacher teacher) {
		getAdminDaoImpl().deleteTeacher(teacher);
		
	}

	@Override
	public Student findStu(String n) {
		// TODO Auto-generated method stub
		
		System.out.println("findService");
		
		return getAdminDaoImpl().findStudent(n);
	}



	@Override
	public void changepassword(String i) {
		// TODO Auto-generated method stub
	getAdminDaoImpl().changepassword(i);	
	}



	@Override
	public int findbyTotal(Teacher teacher) {
		// TODO Auto-generated method stub
	
		
		return 	dbUtils.findTotalBylimit(teacher);
	}



	@Override
	public void addClasses(Classes classes) {
		// 
		
		getAdminDaoImpl().addClasses(classes);
		
		
		
	}



	@Override
	public Student fndStudentbyclass(Student student) {
		// TODO Auto-generated method stub
		
		return getAdminDaoImpl().findStudentbyClass(student); 
	}



	@Override
	public void classaddStudent(Classes classes, Student stdent) {
		// TODO Auto-generated method stub
		getAdminDaoImpl().classaddStudent(classes, stdent);
		
		
		
	}



	@Override
	public List<Student> findstudentByClasses(Classes classes) {
		// TODO Auto-generated method stub
		
		return getAdminDaoImpl().findstudentByClasses(classes);
	}

	 

 

}
