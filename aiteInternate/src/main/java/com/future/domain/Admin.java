package com.future.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月3日 上午9:10:27 
 * 类说明
 * 
 *  管理员类
 *  
 */
@Entity
@Table(name="admin_inf")
public class Admin {
 

	@Id
	@GeneratedValue
	private Integer admin_id;
	
	//账号
private String count;
//密码
private String password;
 
public Integer getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(Integer admin_id) {
	this.admin_id = admin_id;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



	
}
