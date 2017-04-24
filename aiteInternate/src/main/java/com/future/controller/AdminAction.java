package com.future.controller;

 
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.base.BaseActions;
import com.future.domain.Admin;
import com.future.domain.Student;
import com.opensymphony.xwork2.ActionContext;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月15日 下午8:35:08 
 * 类说明 
 */
@Controller
@Scope("prototype")
public class AdminAction extends BaseActions<Object> implements SessionAware,ServletResponseAware,ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3318193481119098725L;
	private String name;
	private String number;
	private String password; 
	private String birth;
	//入学成绩
	private String examitation;
	//入学时间
	private String enterSchool;
	//学院
	private String collegeNo;
	//班级
	private String classNo;
	//专业
	private String major;
	//考生号
	private String exNumber;
	//身份证
	private String card;
	//联系电话
	private String numberPhone;
	private String newpassword;
	private String oldpassword;
	
	
	
	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}


	Student  student;
	 
 
	public String saveStudent() throws Exception {
		// TODO Auto-generated method stub
		Student students=new Student();
		 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	 	 SimpleDateFormat simple=new SimpleDateFormat("yyyyMMdd");
	 long  births= simple.parse(birth).getTime();
	 long  enter=  simple.parse(enterSchool).getTime();
	 System.out.println(births);
	 System.out.println(enter);
	 Date enters=new Date(enter);
	 Date birthss=new Date(births);
	 System.out.println(births); 
		students.setNumber(getNumber());
		  students.setBirth(birthss); 
		 students.setClassNo(getClassNo());
		 students.setCollegeNo(getCollegeNo());
		  students.setEnterSchool(enters ); 
		 students.setExamitation(getExamitation());
		 students.setExNumber(getExNumber());
		 students.setiD(getCard());
		 students.setMajor(getMajor());
		 students.setName(getName());
		 
		 students.setNumberPhone(getNumberPhone());
		 students.setPassword(DigestUtils.md5Hex(getPassword()) );
		/*System.out.println(student.getName()+student.getiD());*/
		 adminManager.addStudent(students);
		 
		 /*ActionContext.getContext().getValueStack().push("comple");*/
		
		return SUCCESS;
		 
	}
	
	//修改学生信息
	 public String modify( ) throws ParseException{
Student student=new Student();
		 
		 SimpleDateFormat simple=new SimpleDateFormat("yyyyMMdd");
	 long  births= simple.parse(birth).getTime();
	 long  enter=  simple.parse(enterSchool).getTime();
	 System.out.println(births);
	 System.out.println(enter);
	 Date enters=new Date(enter);
	 Date birthss=new Date(births);
	 System.out.println(births+"mmmmmm");
		student.setNumber(number);
		 student.setBirth(birthss);
		 student.setClassNo(classNo);
		 student.setCollegeNo(collegeNo);
		 student.setEnterSchool(enters );
		 student.setExamitation(examitation);
		 student.setExNumber(exNumber);
		 student.setiD(card);
		 student.setMajor(major);
		 student.setName(name);
		 student.setNumber(number);
		 student.setNumberPhone(numberPhone);
		 student.setPassword(DigestUtils.md5Hex(password) );
		System.out.println(student.getName()+student.getiD());
		 adminManager.modifyStudent(student); 
		 
		 return SUCCESS;
		 
	 }
	public String findStudent(){
		 SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("findd");
	   student=adminManager.findStu(number);
		System.out.println(student.toString());
		setName(student.getName());
		setNumber(student.getNumber());
	 
		setClassNo(student.getClassNo());
		setCollegeNo(student.getCollegeNo());
		setExamitation(student.getExamitation());
		setExNumber(student.getExNumber());
		setNumberPhone(student.getNumberPhone());
		
		  setBirth( simple.format(student.getBirth()) );
	 
		  
		  setEnterSchool( simple.format(student.getEnterSchool()) );
	 
		 setCard(student.getiD());
	 setMajor(student.getMajor());
 
		 
 
		 
		
		
		
		return "finbystudent";
		
	}
/*//查询学生分页
	public String findStudentBypages(){
		Student student=new Student();
		student.setNumber(getNumber());
		
		
		return "";
	}
	*/
	
	
	
	//修改密码
	public String changepassword(){
		System.out.println("CCCCC");
		Admin admin= (Admin) ActionContext.getContext().getSession().get("admin") ;
		System.out.println(DigestUtils.md5Hex(getOldpassword())+admin.getPassword());
		System.out.println(admin.getPassword().equals(DigestUtils.md5Hex(getOldpassword())));
		
		if(admin.getPassword().equals(DigestUtils.md5Hex(getOldpassword()))){
			
		adminManager.changepassword(DigestUtils.md5Hex(getNewpassword()));
		admin.setPassword(DigestUtils.md5Hex(getNewpassword()));
		 ActionContext.getContext().getSession().put("admin", admin) ;
		}else{
		ActionContext.getContext().put("yan", "密码不正确!");
		}
		return "changepassword";
	}
	
	
	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	 


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	 


	public String getExamitation() {
		return examitation;
	}


	public void setExamitation(String examitation) {
		this.examitation = examitation;
	}


	 


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getEnterSchool() {
		return enterSchool;
	}


	public void setEnterSchool(String enterSchool) {
		this.enterSchool = enterSchool;
	}


	public String getCollegeNo() {
		return collegeNo;
	}


	public void setCollegeNo(String collegeNo) {
		this.collegeNo = collegeNo;
	}


	public String getClassNo() {
		return classNo;
	}


	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


 

 

 


	 


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getExNumber() {
		return exNumber;
	}


	public void setExNumber(String exNumber) {
		this.exNumber = exNumber;
	}


	 


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public String getNumberPhone() {
		return numberPhone;
	}


	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}


 

	 

 
	
	
	
}
