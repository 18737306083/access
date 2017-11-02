package com.honoo.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.honoo.controll.Person;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��9��8�� ����10:02:54 
 * ��˵�� 
 */
@Component
public class RedisUtils {
	@Autowired  
    private StringRedisTemplate redisTemplate;//redis����ģ��  
	
	public void addRedis(){
		redisTemplate.boundValueOps("");
		redisTemplate.delete("name");
		System.out.println("ɾ��age");
		
	}
	
	public String findPass(String number,String password){
		//������˺�
		String allow;
		String password1;
		if(redisTemplate.hasKey(number)){
			
			    allow=(String) redisTemplate.opsForHash().get(number, "Allow");
            
			//�ж��Ƿ������¼
			if(allow.equals("1")){
				  password1=(String) redisTemplate.opsForHash().get(number, "Password");
				System.out.println("�����е�����"+password1+"����2"+password);
			
				//�ж������Ƿ���ȷ
				if(password1.equals(password)){
				          return "success";	
				}
				else{
					     return "fails";
				}
            	 
            	 
            	 
             }
			else{
			     return "fails";
		}
		}
		return null;
	}
	public void addPerson(Person person){
		
		redisTemplate.boundHashOps(person.getNumber()).put("Name",person.getName());
		redisTemplate.boundHashOps(person.getNumber()).put("Password",person.getPassword());
		redisTemplate.boundHashOps(person.getNumber()).put("Number", person.getNumber());
		redisTemplate.boundHashOps(person.getNumber()).put("Sex",person.getSex());
		redisTemplate.boundHashOps(person.getNumber()).put("Allow","1");
		//redisTemplate.boundHashOps("person").expire(10,TimeUnit.SECONDS);
	
	
	}
	public String modifyPassword(String number,String oldPassword,String newPassword){
		
		if(redisTemplate.hasKey(number)){	
		String password=(String) redisTemplate.boundHashOps(number).get("Password");	
		System.out.println(password);
		System.out.println(oldPassword);
		if(password.equals(oldPassword)){
				redisTemplate.boundHashOps(number).put("Password", newPassword);
				System.out.println("true");
				return "success";
			}	
		}
	
		return "faile";	
	}
	/**
	 * 
	 * @Description: ��������
	 *@param:   
	 *@return: String
	 *@throws
	 */
	public String newpassword(String number,String newPassword){
		
		if(redisTemplate.hasKey(number)){

				redisTemplate.boundHashOps(number).put("Password", newPassword);
				System.out.println("true");
				return "success";
			
		}
		
		return "faile";
		
	}
}
