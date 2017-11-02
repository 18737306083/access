package com.future.mybatis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.mybatis.mapper.PersonMapper;
import com.honoo.controll.Person;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��9��20�� ����2:22:14 
 * ��˵�� 
 */
@Service
@Transactional
public class RegistryService {
@Resource
PersonMapper personMapper;
	public void insertBycontroll(Person person){
		String id=null;
		System.out.println("����");
		//���ݿ��ѯ�Ƿ����
		try {
			 id=personMapper.selectExsistPhone(person.getNumber());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("1111"+id);
		if(id ==null){
			System.out.println("δע��");
			personMapper.insertPersonByAll(person);	 
		}
		else{
			//����
			personMapper.updateUser(person);
			
		}
		
		
		
	}
//�޸�����
	public int modifyPassword(String password,String number,String newPassword){
		try {
			Person person=null;
            person=personMapper.select_password(number, password);
           if(person!=null){
       if(person.getPassword().equals(password)){
	        System.out.println("���ݿ⿪ʼ����");
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
	
	//��¼
	public String loginValidByAndro(String number,String password){
		String allow;
		Person person;
	                  person=personMapper.select_password(number, password);
		     if(person!=null){
		    	 //�ж��Ƿ���Ե�¼
		        allow= person.getAllow();
			if(allow.equals("1")){
				//�ж������Ƿ���ȷ!
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
	 * @Description:��������
	 *@param:   
	 *@return: int
	 *@throws
	 */
		public int newpassword(String number,String newPassword){
			 
				 
	         
	  
		  System.out.println("���ݿ⿪ʼ����");
		int i=   personMapper.updatePassword(newPassword, number);
		System.out.println("updateresult"+i);
		return i;
	  
	           
						 
		}
		
		/**
		 * 
		 * @Description: �ж��ֻ����Ƿ��Ѿ�ע��
		 *@param: �ֻ���  
		 *@return: void
		 *@throws
		 */
	
	 
}
