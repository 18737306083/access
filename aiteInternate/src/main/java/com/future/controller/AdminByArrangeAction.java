package com.future.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.base.BaseActions;
import com.future.domain.Classes;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年4月20日 下午6:46:18 
 * 类说明  教学管理类 
 */
@Controller
@Scope("prototype")
public class AdminByArrangeAction extends BaseActions<Object> implements
SessionAware, ServletResponseAware, ServletRequestAware {
private String class1;


//查询班级中课程数量
public String courseNum(){
     Classes classes=new Classes();
     classes.setClass_name(class1);
	
	
	return "";
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

}
