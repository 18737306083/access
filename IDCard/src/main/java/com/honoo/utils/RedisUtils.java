package com.honoo.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.honoo.controll.Person;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年9月8日 上午10:02:54 
 * 类说明 
 */
@Component
public class RedisUtils {
	@Autowired  
    private StringRedisTemplate redisTemplate;//redis操作模板  
	
	public void addRedis(){
		redisTemplate.boundValueOps("");
		redisTemplate.delete("name");
		System.out.println("删除age");
		
	}
	
	public String findPass(String number,String password){
		//如果有账号
		String allow;
		String password1;
		if(redisTemplate.hasKey(number)){
			
			    allow=(String) redisTemplate.opsForHash().get(number, "Allow");
            
			//判断是否允许登录
			if(allow.equals("1")){
				  password1=(String) redisTemplate.opsForHash().get(number, "Password");
				System.out.println("缓存中的密码"+password1+"密码2"+password);
			
				//判断密码是否正确
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
	 * @Description: 忘记密码
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
