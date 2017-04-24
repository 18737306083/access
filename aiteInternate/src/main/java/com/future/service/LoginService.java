package com.future.service;

import com.future.domain.Admin;
import com.future.domain.Student;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月13日 上午10:51:58 
 * 类说明 
 */
public interface LoginService {

 Student loginByStudent(Student student);
Teacher loginByTeacher(Teacher teacher);
Admin getloginByAdmin(Admin admin);
void insert(Admin admin);
	
}
