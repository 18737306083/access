package com.future.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.future.domain.Admin;
 
import com.future.domain.Student;
import com.future.domain.Teacher;
import com.future.service.AdminManager;
import com.future.service.LoginService;
import com.future.service.StudentManager;
import com.future.service.TeacherManager;
 
 

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月13日 下午10:27:46 
 * 类说明 
 */
public class CookUtils {
private  String COOK="user.cook";
private String STU="student";
private String TEA="teacher";
private String MANA="manager";

//添加cook
public Cookie addCookie(Object ob,String id) throws UnsupportedEncodingException{
	String value=null;
	Cookie cookie=null;
	if(id.equals(STU)){
		Student student=(Student)ob;
		value=URLEncoder.encode(student.getNumber()+","+student.getPassword()+","+id, "utf-8");
	}
	else if(id.equals(TEA)){
		Teacher teacher=(Teacher)ob;
		value=URLEncoder.encode(teacher.getNumber_teacher()+","+teacher.getPasword_teacher()+id, "utf-8");
		
		
	}
	else if(id.equals(MANA)){
		Admin admin=(Admin)ob;
		value=URLEncoder.encode(admin.getCount()+","+admin.getPassword()+id,"utf-8");
		
	}
	 
	if(value!=null){
		cookie=new Cookie(COOK, value);
	}
	if(cookie!=null){
		cookie.setMaxAge(60*60*24*14);
		
	}
	
	
	return cookie;
	 
}
//获取cookie
public Boolean getCookie(Map<String, Object> session,HttpServletRequest request,LoginService login ) throws UnsupportedEncodingException{
	Cookie[] cookie=request.getCookies();
	if(cookie!=null){
		for (Cookie cookie2 : cookie) {
			//可以通过cookie.getName()得到cookie的名字
			if(COOK.equals(cookie2.getName())){
				String value=URLDecoder.decode(cookie2.getValue(),"utf-8");
				if(!value.equals("")){
					String[] info=value.split(",");
					String number=info[0];
					String password=info[1];
					String role=info[2];
				
					if(role.equals(STU)){
						Student student2=new Student();
						student2.setNumber(   number);;
						student2.setPassword(password);
						student2=login.loginByStudent(student2) ;
						if(student2!=null){
							session.put("stu", student2);
							return true;
						}
					}else if(role.equals(TEA)){
						Teacher teacher=new Teacher();
						teacher.setNumber_teacher( number );
						teacher.setPasword_teacher(password);
						
						Teacher teacher1=login.loginByTeacher(teacher);
						if(teacher!=null){
							session.put("teacher", teacher);
							return true;
						}
					}else if(role.equals(MANA)){
						Admin admin=new Admin();
						admin.setCount( number);
						admin.setPassword(password);
						
						
						Admin admin1=login.getloginByAdmin(admin);
						if(admin1!=null){
							session.put("admin", admin1);
							return true;
						}
					}
					
				}
			}
		}
		
		
	}
	
	
	
	
	return false;
}

//消除cookie
public Cookie delCookie(HttpServletRequest request){
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for (Cookie cookie:cookies) {
			if(COOK.equals(cookie.getName())){
				cookie.setValue("");
				cookie.setMaxAge(0);
				return cookie;
			}
			
		}
	}
	return null;
}



}
