package com.honoo.controll;

import org.springframework.stereotype.Component;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年9月6日 下午2:43:13 类说明
 */
@Component
public class Person {
	
	private String number;
	private String name;
	private String password;
	private String sex;
    private String allow;
    private String model;
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	
}
