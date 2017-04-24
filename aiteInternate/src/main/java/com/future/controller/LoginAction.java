package com.future.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.base.BaseActions;
import com.future.dao.impl.AdminDaolmpl;
import com.future.domain.Admin;
 
import com.future.domain.Student;
import com.future.domain.Teacher;
import com.future.util.CookUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月7日 下午5:05:56 
 * 类说明 
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseActions<Object> implements SessionAware,ServletResponseAware,ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Boolean flag=false;
private String number;
private String password;
private String role;
private String yans;	
private String STU="student";
private String TEA="teacher";
private String MANA="manager";
private  Boolean juge=false;
//
CookUtils cookieUtils=new CookUtils();
private Boolean useCookie=false;
	public String getNumber() {
	return number;
}

	public String juge(){
		System.out.println(juge+role+"qwqwqwqw");
		//System.out.println(ActionContext.getContext().getSession().get("picCode")+"session");
	   Object picCode= ActionContext.getContext().getSession().get("picCode"); 
	   
	   System.out.println(picCode.toString()+yans+"sessionaaa");
		if(picCode.toString().equals(yans)){
			flag=true;
			
		}
		 
		if(flag&&role.equals(STU)){
			System.out.println("stu");
			Student student=new Student();
			student.setNumber( number);
			student.setPassword(DigestUtils.md5Hex(password));
			Student student1=loginService.loginByStudent(student);
			System.out.println(student1);
			 if(student1!=null){
			session.put("stu", student1);
				 juge=true;
			 }
			
		}
		
		else if(flag&&role.equals(TEA)){
			System.out.println(TEA);
			Teacher teacher=new Teacher();
			teacher.setNumber_teacher( number );
			teacher.setPasword_teacher(DigestUtils.md5Hex(password));
			Teacher teacher1=loginService.loginByTeacher(teacher);
			if(teacher1!=null){
				session.put("teacher", teacher1);
			juge=true;}
		}
       else if(flag&&role.equals(MANA)){
    	   System.out.println(MANA);
    	 
    	  Admin admin=new Admin();
    	  admin.setCount( number);
    	  admin.setPassword(DigestUtils.md5Hex(password));
    	  Admin admins=loginService.getloginByAdmin(admin);
    	  System.out.println(admins);
    	  if(admins!=null){
    		  session.put("admin", admins);
    		   juge=true;
    	  }
    	  
    	 
    	  
      
    
    	
		}
		
		
		if(!flag){
			 System.out.println("again111111111111111111111111111");
			 ActionContext.getContext().getValueStack().push("again");
			
		}
		else if(juge){
			System.out.println("again2222221");
			 ActionContext.getContext().getValueStack().push("correct");
		}
		else {
			
			 ActionContext.getContext().getValueStack().push("error");
		}
		return "info";
		
		
		
	}
	public String login() throws UnsupportedEncodingException{
		Cookie cookie=null;
		Student student=(Student) session.get("stu");
		Teacher teacher=(Teacher) session.get("teacher");
		Admin admin=(Admin) session.get("admin");
		//System.out.println(admin.getPassword()+"FDFDFDFDFD");
		if(student!=null){
		
         if(useCookie){
			cookie=cookieUtils.addCookie(student, STU);	
				
			}
     	
		}
		else if(teacher!=null)	{
			 if(useCookie){
					cookie=cookieUtils.addCookie(teacher, TEA);	
						
					}
			 
		}
		else if(admin!=null){
			 if(useCookie){
					cookie=cookieUtils.addCookie(admin, MANA);	
						
					}
			  
	}
	
		else {
		
			return "firstLogin";
		}
		
		if(cookie != null){
			reponse.addCookie(cookie);
			
		}
		
		
		System.out.println("login");
		return SUCCESS;
	}
	
	public String firstLogin() throws UnsupportedEncodingException{
		//是否存在cookie由前台来决定
		boolean juges=cookieUtils.getCookie(session, request, loginService);
		if(juges){
			return SUCCESS; 
			 
		}
		return SUCCESS;
	} 
	
	public String loginOut(){
		session.clear();
		return "login";
	}
	public Boolean getUseCookie() {
		return useCookie;
	}
	public void setUseCookie(Boolean useCookie) {
		this.useCookie = useCookie;
	}

	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getSTU() {
		return STU;
	}
	public void setSTU(String sTU) {
		STU = sTU;
	}
	public String getTEA() {
		return TEA;
	}
	public void setTEA(String tEA) {
		TEA = tEA;
	}
	public String getMANA() {
		return MANA;
	}
	public void setMANA(String mANA) {
		MANA = mANA;
	}
	public Boolean getJuge() {
		return juge;
	}
	public void setJuge(Boolean juge) {
		this.juge = juge;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getReponse() {
		return reponse;
	}
	public void setReponse(HttpServletResponse reponse) {
		this.reponse = reponse;
	}
	public Map<String, Object> getSession() {
		return session;
	}
public void setNumber(String number) {
	this.number = number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getYans() {
	return yans;
}
public void setYans(String yans) {
	this.yans = yans;
}


	private Map<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse reponse;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		reponse=arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
	}
	 

}
