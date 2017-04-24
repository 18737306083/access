package com.future.dao;

import java.util.List;

import com.future.domain.Classes;
import com.future.domain.Course;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年4月20日 下午8:17:15 
 * 类说明 
 */
public interface AdminByarrayDao {
//查询班级必修课程
List<Course> findByCourse(Classes classes);

}
