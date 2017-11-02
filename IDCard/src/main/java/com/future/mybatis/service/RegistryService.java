package com.future.mybatis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.mybatis.mapper.PersonMapper;
import com.honoo.controll.Person;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年9月20日 下午2:22:14 
 * 类说明 
 */
@Service
@Transactional
public class RegistryService {
@Resource
PersonMapper personMapper;
	public void insertBycontroll(Person person){
		String id=null;
		System.out.println("插入");
		//数据库查询是否存在
		try {
			 id=personMapper.selectExsistPhone(person.getNumber());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("1111"+id);
		if(id ==null){
			System.out.println("未注册");
			personMapper.insertPersonByAll(person);	 
		}
		else{
			//更新
			personMapper.updateUser(person);
			
		}
		
		
		
	}
//修改密码
	public int modifyPassword(String password,String number,String newPassword){
		try {
			Person person=null;
            person=personMapper.select_password(number, password);
           if(person!=null){
       if(person.getPassword().equals(password)){
	        System.out.println("数据库开始更新");
			 int i= personMapper.updatePassword(newPassword,number);
			System.out.println("updateresult"+i);
			return i;
 }
 }else{
 	return 0;
	
 }
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	
		            
					return 0;
	}
	
	//登录
	public String loginValidByAndro(String number,String password){
		String allow;
		Person person;
	                  person=personMapper.select_password(number, password);
		     if(person!=null){
		    	 //判断是否可以登录
		        allow= person.getAllow();
			if(allow.equals("1")){
				//判断密码是否正确!
				if(password.equals(person.getPassword())){
					
					return "success";
				}
				else{
					
					return "faile";
				}
				
			}else{
				return "faile";
				
			}
			 
			 
			
			
		}
		     else{
		    	 return null;
		     }
		
	}
	/**
	 * 
	 * 
	 * @Description:忘记密码
	 *@param:   
	 *@return: int
	 *@throws
	 */
		public int newpassword(String number,String newPassword){
			 
				 
	         
	  
		  System.out.println("数据库开始更新");
		int i=   personMapper.updatePassword(newPassword, number);
		System.out.println("updateresult"+i);
		return i;
	  
	           
						 
		}
		
		/**
		 * 
		 * @Description: 判断手机号是否已经注册
		 *@param: 手机号  
		 *@return: void
		 *@throws
		 */
	
	 
}
