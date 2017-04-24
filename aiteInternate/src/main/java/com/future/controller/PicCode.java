package com.future.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.type.ImageType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月9日 下午2:44:37 
 * 类说明 
 */
@Controller
@Scope("prototype")
public class PicCode extends ActionSupport implements ServletResponseAware{
	HttpServletResponse arg12;
	private ByteArrayInputStream inputStream;
	
	
	
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
public String  execute() throws Exception {
	// TODO Auto-generated method stub
	BufferedImage image=new BufferedImage(68, 22,BufferedImage.TYPE_INT_RGB);
	Graphics gra=image.getGraphics();
	Color c=new Color(200, 150, 255);
	gra.setColor(c);
	gra.fillRect(0, 0, 68,22);
	char[] s="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
	Random ran=new Random();
	int len=s.length,index;
	StringBuffer strs=new StringBuffer();
	for (int i = 0; i <4; i++) {
	index=ran.nextInt(len);
		gra.setColor(new Color(ran.nextInt(88), ran.nextInt(188), ran.nextInt(255)));
		gra.drawString(s[index]+"", (i*15)+3, 18);
		strs.append(s[index]);
		
		
	}
	
	ActionContext.getContext().getSession().put("picCode",  strs);
	System.out.println(strs);
	System.out.println(ActionContext.getContext().getSession().get("picCode")+"dsds");
	ByteArrayInputStream input=null;   
	ByteArrayOutputStream output = new ByteArrayOutputStream();   
	try{   
	ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);   
	ImageIO.write(image, "JPEG", imageOut);   
	imageOut.close();   
	input = new ByteArrayInputStream(output.toByteArray());   
	}catch(Exception e){   
	System.out.println("验证码图片产生出现错误："+e.toString());   
	} 
 this.inputStream=input;
	
	
	return  SUCCESS;
}

@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	arg12=arg0;
}
	
}
