package com.honoo.controll;
 
import java.io.BufferedReader;
 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
 
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.future.mybatis.mapper.PersonMapper;
import com.future.mybatis.service.RegistryService;
import com.honoo.utils.RedisUtils;
import com.honoo.utils.SMSUtils;
import com.sun.jdi.Method;
//处理Android客户端请求
/*
 * honoo
 * version1.0
 * 处理悦乐居客户端请求
 */
	@Controller
	@RequestMapping(value="text")
	public class RemoteControll {
		@Resource
		PersonMapper personMapper;
		@Resource
		RedisUtils redisUtils;
		@Resource 
	    RegistryService registry;
		Logger logger=Logger.getLogger(RemoteControll.class);
	 

	//接收客户端请求,注册信息
	@RequestMapping(value="/addPerson",method = RequestMethod.POST)
	public void addPerson(HttpServletRequest request,HttpServletResponse response){
		  StringBuilder receiver=null;
		  InputStream input=null;
		  BufferedReader reader;
		  char[] chars;
		  StringBuilder str;
		  JSONObject json;
		  OutputStream out;
		  String username;
		  String password;
		  String check;
		  String number;
		  String md5;
	
		  //解析json字符串,并且入库
	 	try {
                 input=request.getInputStream();
                 reader=new BufferedReader(new InputStreamReader(input, "utf-8"));
                 chars=new char[1024]; 
                 str=new StringBuilder();
                 
                while(reader.read(chars)>-1){
            	  System.out.println(chars);
                      	str.append(chars);
                     }
                
                 json=new JSONObject(str.toString());
                 Person person=new Person();
  		         person.setName(URLDecoder.decode(json.getString("username"),"utf-8"));
                  md5=DigestUtils.md5Hex(URLDecoder.decode(json.getString("password"),"utf-8"));
  	             person.setPassword(md5);
  		         person.setSex(URLDecoder.decode(json.getString("sex"),"utf-8"));
  		         person.setNumber(URLDecoder.decode(json.getString("number"),"utf-8")); 
          		  logger.info("开始添加数据!");
          		   redisUtils.addPerson(person);
                   registry.insertBycontroll(person);       
                  
                      
	} catch (Exception e) {
		// TODO Auto-generated catch block
		logger.error(e.getStackTrace());
		//出现异常返回给客户端
	try {
		//失败
		logger.info("返回数据！");
		out=response.getOutputStream();
		JSONObject jsons=new JSONObject();
		jsons.put("state", "faile");
		out.write(jsons.toString().getBytes());
		
		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				logger.error(e1.getMessage());
			}
	}
	try {
//成功添加，返回成功
		logger.info("返回数据！");
		 out=response.getOutputStream();
		JSONObject jsons=new JSONObject();
		jsons.put("state", "success");
		out.write(jsons.toString().getBytes());
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		logger.error(e.getMessage());
	}
	 
}

	// 客户端登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void loginValidByAndr(HttpServletRequest request,
			HttpServletResponse response) {
		// 解析客户端请求,进行登录验证
		StringBuilder receiver = null;
		InputStream input = null;
		BufferedReader reader;
		char[] chars;
		StringBuilder str;
		JSONObject json;
		OutputStream out = null;
		String md5Password;
		try {
			
			input = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
			chars = new char[1024];
			str = new StringBuilder();

			while (reader.read(chars) > 0) {
				str.append(chars);

			}
			json = new JSONObject(str.toString());
			md5Password=DigestUtils.md5Hex(URLDecoder.decode(json.getString("password"),"utf-8"));
			String number = URLDecoder
					.decode(json.getString("number"), "utf-8");
			String result1 = redisUtils.findPass(number,md5Password);
			
			if (result1 != null) {
			//缓存登录
				System.out.println("11");
				out = response.getOutputStream();
				JSONObject jsons = new JSONObject();
				if (result1.equals("success")) {
					logger.info("缓存登录!");
					jsons.put("state", "success");
					out.write(jsons.toString().getBytes());
					return;
				} /*else {
					logger.info("缓存登录失败!");
					jsons.put("state", "failer");
					out.write(jsons.toString().getBytes());
					System.out.println(jsons.toString());
				}*/
			} 
			
			 
				//数据库登录
				String result = registry.loginValidByAndro(number,md5Password);
				out = response.getOutputStream();
				JSONObject jsons = new JSONObject();
				//注册过
				if (result != null) {
					/*out = response.getOutputStream();
					JSONObject jsons = new JSONObject();*/
					//登录成功
						if (result.equals("success")) {
						jsons.put("state", "success");
						out.write(jsons.toString().getBytes());	
						logger.info("数据库登录!");

					} else {
                              //登录失败
						jsons.put("state", "faile");
						out.write(jsons.toString().getBytes());
						logger.info("密码错误，数据库登录失败!");


					}
				}
				else{
					//未注册登录失败
					jsons.put("state", "faile");
					out.write(jsons.toString().getBytes());
					logger.info("未注册,数据库登录失败!");
					
				} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 
 * @Description: 忘记密码
 *@param:   
 *@return: void
 *@throws
 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/newpassword", method = RequestMethod.POST)
public void newpassword(HttpServletRequest request,
		HttpServletResponse response){
	// 解析客户端请求,进行修改密码
	
			StringBuilder receiver = null;
			InputStream input = null;
			BufferedReader reader;
			char[] chars;
			StringBuilder str;
			JSONObject json;
			OutputStream out = null;
			
			try {
				
				input = request.getInputStream();
				reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
				chars = new char[1024];
				str = new StringBuilder();

				while (reader.read(chars) > 0) {
					str.append(chars);
				}
				json = new JSONObject(str.toString());
				String number = URLDecoder
						.decode(json.getString("number"), "utf-8");
				String newPassword= DigestUtils.md5Hex(URLDecoder
						.decode(json.getString("newpassword"), "utf-8"));
                System.out.println(number);
				String result1 = redisUtils.newpassword(number,newPassword);

				if (result1 != null) {
                 if(result1.equals("success")){
					out = response.getOutputStream();
					JSONObject jsons = new JSONObject();
					 jsons.put("state", "success");
					 out.write(jsons.toString().getBytes());
                      }
                 else {
                	 out = response.getOutputStream();
 					JSONObject jsons = new JSONObject();
 					 jsons.put("state", "faile");
 					 out.write(jsons.toString().getBytes());
				}
				} 
					int resultm=  registry.newpassword(number,newPassword);
					if (resultm ==1) {
						System.out.println("修改成功");
						out = response.getOutputStream();
						JSONObject jsons = new JSONObject();
						jsons.put("state","success");
						 out.write(jsons.toString().getBytes());
					
				}
					else{
						System.out.println("修改密码失败");
						out = response.getOutputStream();
						JSONObject jsons = new JSONObject();
						jsons.put("state","faile");
						 out.write(jsons.toString().getBytes());
						
						
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	
	
}
	
	
	
	//修改密码
		@SuppressWarnings("deprecation")
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public void modifyd(HttpServletRequest request,
			HttpServletResponse response){
		// 解析客户端请求,进行修改密码
		
				StringBuilder receiver = null;
				InputStream input = null;
				BufferedReader reader;
				char[] chars;
				StringBuilder str;
				JSONObject json;
				OutputStream out = null;
				String md5Password;
				try {
					
					input = request.getInputStream();
					reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
					chars = new char[1024];
					str = new StringBuilder();

					while (reader.read(chars) > 0) {
						str.append(chars);

					}
					json = new JSONObject(str.toString());
					
					System.out.println(URLDecoder.decode(json.getString("oldpassword")));
					md5Password=DigestUtils.md5Hex(URLDecoder.decode(json.getString("oldpassword"),"utf-8"));

					
					String number = URLDecoder
							.decode(json.getString("number"), "utf-8");
					String newPassword= DigestUtils.md5Hex(URLDecoder
							.decode(json.getString("newpassword"), "utf-8"));
	              System.out.println(number);
					String result1 = redisUtils.modifyPassword(number,md5Password,newPassword);
					/*if (result1 != null) {
	                 if(result1.equals("success")){
						out = response.getOutputStream();
						JSONObject jsons = new JSONObject();
						 jsons.put("state", "success");
						 out.write(jsons.toString().getBytes());
	                      }
	                 else {
	                	 out = response.getOutputStream();
	 					JSONObject jsons = new JSONObject();
	 					 jsons.put("state", "faile");
	 					 out.write(jsons.toString().getBytes());
					}
					} */
						int resultm=  registry.modifyPassword (md5Password,number,newPassword);
						if (resultm ==1 &&result1.equals("success")) {
							System.out.println("修改成功");
							out = response.getOutputStream();
							JSONObject jsons = new JSONObject();
							jsons.put("state","success");
							 out.write(jsons.toString().getBytes());
						
					}
						else{
							System.out.println("修改密码失败");
							out = response.getOutputStream();
							JSONObject jsons = new JSONObject();
							jsons.put("state","faile");
							 out.write(jsons.toString().getBytes());
							
							
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		
		
	}

/**
 * @throws IOException 
 * 
 * @Description: Android端请求验证码
 *@param:   
 *@return: void
 *@throws
 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "msm", method = RequestMethod.POST)
		public void sendSMS(HttpServletRequest request,
				HttpServletResponse response) throws IOException{
			
			String phone;
			String vertifi;
			InputStream input;
			 OutputStream out;
			 Random random; 
			int s ;
			SMSUtils sms = null; 
				 
				
			    input=request.getInputStream();
			    phone=parseJson(input);
			    out=response.getOutputStream();
			    random = new Random();
		         s = random.nextInt(10000)%(10000-1000+1) + 1000;
		         vertifi=String.valueOf(s);
		         System.out.println(phone+vertifi);
		         //发送之前判断是否已经注册,如果已经注册,
		        // sms.sendMsg(phone, vertifi); 
		         JSONObject state=new JSONObject();
		         state.put("code", s);
		         response.setContentType("application/json");
		         out=response.getOutputStream();
		         out.write(state.toString().getBytes());
		         out.flush();
		         out.close();
		         
		}
		/**
		 * @throws IOException 
		 * @Description: 获取手机号
		 *@param:   
		 *@return: void
		 *@throws
		 */
		public String parseJson(InputStream input) throws IOException{
			
			String phone = null;
			BufferedReader buffer;
			StringBuilder content;
			String[] names;
			
			buffer=new BufferedReader(new InputStreamReader(input, "utf-8"));
			content=new StringBuilder();
			char[] chars=new char[1024];
			while (buffer.read(chars) !=-1) {
			content.append(chars);	
			}
			JSONObject json=new JSONObject(content.toString());
			names=JSONObject.getNames(json);
			if(names.length>0){
				phone=json.getString(names[0]);
				
			}
			return phone;
		}
}
