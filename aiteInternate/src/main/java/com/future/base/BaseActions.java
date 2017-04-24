package com.future.base;

import java.lang.reflect.ParameterizedType;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.service.AdminByarrayService;
import com.future.service.AdminManager;
import com.future.service.LoginService;
import com.future.service.StudentManager;
import com.future.service.TeacherManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
 

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月13日 下午1:47:29 
 * 类说明 
 */
 
public abstract class BaseActions<T> extends ActionSupport implements ModelDriven<T>,Preparable  {
	protected T model;  
	 @Autowired
	 public LoginService loginService;  
	 @Autowired 
	 public AdminManager adminManager;
	 @Autowired
	 public AdminByarrayService adminByarrayService;
/*	 @Autowired
	 public StudentManager studentManager;
	 @Autowired
	 public TeacherManager teacherManager;*/
	public BaseActions() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void prepare() throws Exception {}

	@Override
	public  T getModel(){
		return model;
	};	
	
	 
}
