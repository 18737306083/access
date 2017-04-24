package com.future.service;

import java.util.List;

import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月7日 上午10:10:44 
 * 类说明 
 */
public interface TeacherManager {
	//老是登陆
List<Teacher> loginTeacher(Teacher teacher);
}
