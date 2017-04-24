package com.future.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.base.BaseActions;
import com.future.domain.Student;
import com.future.domain.Teacher;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月19日 上午10:15:39 类说明 管理员对教师的管理
 */
@Controller
@Scope("prototype")
public class AdminTeacherManageAction extends BaseActions<Object> implements
		SessionAware, ServletResponseAware, ServletRequestAware {
	private String number_teacher;
	private String newberphone;
	private String department;
	private String title;
	private String sex;

	private String pasword_teacher;
	private String teachername;
	// 分页
	private Integer pageIndex;// 当前页
	private Integer total;// 总页数
	private Integer pagesize;
	List<Teacher>  teachers;
	List<Teacher>  y=new ArrayList<Teacher>();
	 
	// 添加教师

	public String addTeacher() {
		System.out.println("teacher");
		Teacher teacher = new Teacher();
		teacher.setNumber_teacher(getNumber_teacher());
		teacher.setNewberphone(getNewberphone());
		teacher.setDepartment(getDepartment());
		teacher.setTitle(getTitle());
		teacher.setSex(getSex());
		teacher.setPasword_teacher(getPasword_teacher());
		teacher.setTeachername(getTeachername());
		System.out.println(teacher.getDepartment() + teacher.getTeachername());
		adminManager.addTeacher(teacher);
		ActionContext.getContext().put("key", "success");
		System.out.println(teacher.getDepartment() + teacher.getTeachername());
		return "addteacherview";
	}

	// 修改教师信息
	public String modify() {

		return "modifyteacherinfo";
	}

	// 查找纪录
	public String findCount() {
		 
		  Teacher teacher2 =new Teacher(); 
		  teacher2.setSex(getSex());
		   teacher2.setTitle(getTitle()); 
		   teacher2.setDepartment(getDepartment());
		 System.out.println(getTitle()+""+getDepartment()+getSex());  
		   total=adminManager.findbyTotal(teacher2);
		  System.out.println(getTitle()+""+getDepartment()+getSex());
		   System.out.println(total+"total11111");
		  ActionContext.getContext().getValueStack().push(total);
		  

		return "findcount";
	}

	// 查看教师信息
	public String lookteacherinfo() {
		Teacher teacher = new Teacher();
		teacher.setSex(getSex());
		teacher.setTitle(getTitle());
		teacher.setDepartment(getDepartment());
		System.out.println(getTitle() + "" + getDepartment() + getSex());
	 
		System.out.println(getTitle() + "" + getDepartment() + getSex());
	 
		System.out.println(pageIndex);
  teachers=  adminManager.findTeacher(pageIndex, 5, teacher);
 System.out.println(teachers.get(1).getSex()+""+teachers.size());
 
 for (int i = 0; i < teachers.size(); i++) {
	 Teacher teacher1=new Teacher();
	 teacher1.setSex(teachers.get(i).getSex());
		teacher1.setTitle(teachers.get(i).getTitle());
		teacher1.setDepartment(teachers.get(i).getDepartment());
	 teacher1.setNumber_teacher(teachers.get(i).getNumber_teacher());
	 teacher1.setNewberphone(teachers.get(i).getNewberphone());
	 teacher1.setTeachername(teachers.get(i).getTeachername());
	 
	 System.out.println(teachers.get(i).getNewberphone());
	 
	y.add(teacher1);
}

 
    
/* ActionContext.getContext().getValueStack().push(teachers);*/
		return "lookteacherinfo";
	}

	 //删除教师
	public String deleteByTeacher(){
		Teacher teacher =new Teacher();
		System.out.println(number_teacher);
		teacher.setNumber_teacher(number_teacher);
		adminManager.deleteTeacher(teacher);
	 
		return "deleteteacher";
	}
	
	
	
	
	
	private static final long serialVersionUID = -5155365268236113747L;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public String getNumber_teacher() {
		return number_teacher;
	}

	public void setNumber_teacher(String number_teacher) {
		this.number_teacher = number_teacher;
	}

	public String getNewberphone() {
		return newberphone;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setNewberphone(String newberphone) {
		this.newberphone = newberphone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPasword_teacher() {
		return pasword_teacher;
	}

	public void setPasword_teacher(String pasword_teacher) {
		this.pasword_teacher = pasword_teacher;
	}

	public String getTeachername() {
		return teachername;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Teacher> getY() {
		return y;
	}

	public void setY(List<Teacher> y) {
		this.y = y;
	}

 
	 
 

}
