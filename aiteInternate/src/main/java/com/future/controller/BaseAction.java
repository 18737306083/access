package com.future.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.service.AdminManager;
import com.future.service.LoginService;
import com.future.service.StudentManager;
import com.future.service.TeacherManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

 
/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月7日 下午6:38:44 
 * 类说明 
 */
 @Controller
 @Scope("prototype")
public abstract class BaseAction<T> extends ActionSupport /*implements ModelDriven<T> ,Preparable */{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1981330186655206416L;
 public T model; 
@Autowired 
public AdminManager adminManager;
@Autowired
public StudentManager studentManager;
@Autowired
public TeacherManager teacherManager;
 @Autowired
public LoginService loginService; 
	  @SuppressWarnings("unchecked") 
	 public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

	
 
/*	@Override
	public void prepare() throws Exception {}

	@Override
	public  T getModel(){
		return model;
	};	
	  */
	
	
}
