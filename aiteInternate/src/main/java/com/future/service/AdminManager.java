package com.future.service;

import java.util.List;

import com.future.domain.Admin;
import com.future.domain.Classes;
import com.future.domain.Student;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月7日 上午10:09:44 
 * 类说明 
 */
public interface AdminManager {
	//管理员登录
		Admin loginAdmin(Admin admin);
//查看学生信息
		List<Student> findStudent(int init,int pageSize);
	//添加学生信息
  void addStudent(Student student);
  //查看教师信息
  List<Teacher> findTeacher(int first,int max,Teacher teacher);
  //添加教师
  void addTeacher(Teacher teacher);
  void modifyStudent(Student student);
	//查看指定学生
  Student findStu(String n);
  void changepassword(String i);
  //条件查找教师
  //查询记录条数
  int findbyTotal(Teacher teacher);
  void addClasses(Classes classes);
  Student fndStudentbyclass(Student student);
  //班级添加学生
  void classaddStudent(Classes classes, Student stdent);
  //根据班级查询学生
  List<Student> findstudentByClasses(Classes classes);
 void deleteTeacher(Teacher teacher) ;
}
