package com.future.dao;

import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月22日 下午4:02:20 
 * 类说明 
 */
public interface DbUtils {
//查询记录条数教师
int findTotal(Teacher teacher);
int findTotalBylimit(Teacher teacher);
	
	
}
