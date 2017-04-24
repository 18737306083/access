package com.future.dao;

 
import java.util.List;
import java.util.Map;

import com.future.domain.Course;
import com.future.domain.Student;
import com.future.domain.TvEvaluation;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月4日 下午3:43:42 
 * 类说明 
 */
public interface StudentDao {
//学生登录
	Student login(Student student); 
//学生查询个人信息
  List<Student> findStudentByAll(Student student);
 //查询个人成绩
   List findScores(Student student);      
//学生选课
  void selectCourse(Student student,Course course);
  //学生评教
  void evaLuation(Course course,TvEvaluation tv);
  
  
  
}
