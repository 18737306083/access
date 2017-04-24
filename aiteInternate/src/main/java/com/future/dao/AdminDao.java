package com.future.dao;

import java.util.List;

import com.future.domain.Admin;
import com.future.domain.Classes;
import com.future.domain.Student;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月6日 下午9:12:53 
 * 类说明 
 */
public interface AdminDao {
	//管理员登录
	Admin getloginAdmin(Admin admin);
//添加学生
	void addStudent(Student student);
//删除学生
	void deleteStudent(Student student);

//添加教师
	void addTacher(Teacher teacher);
	//删除教师
	void deleteTeacher(Teacher teacher);
//修改教师资料
	void updateTeacher(Teacher teacher);
	//修改学生资料
	void updateStudent(Student student);
//分页查看学生资料	
	List<Student> findStudentByPages(int firstResults,int maxResults );
//分页查看教师资料
	List<Teacher> findTeacher(int firstResults,int maxResults,Teacher teacher);
	Student findStudent(String n);
	void insert(Admin ad);
	//
//修改密码
void changepassword(String i);
	//添加班级
 void addClasses(Classes classes);
	//在班级中查找学生
	Student findStudentbyClass(Student student);
	//将学生添加到指定班级
	void classaddStudent(Classes classes,Student stdent);
	//查询
//根据班级查询学生
	List<Student> findstudentByClasses(Classes classes);
	
	
	
	
	
}
