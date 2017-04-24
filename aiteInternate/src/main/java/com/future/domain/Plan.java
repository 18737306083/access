package com.future.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月3日 上午8:56:55 
 * 类说明
 * 
 *  教学计划
 */
@Entity
@Table(name="plan_inf")
public class Plan {
//逻辑主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
//计划编号
private String plan_no;
//计划内容
@Lob
private char[] content;
//教学计划
@OneToOne(targetEntity=Teacher.class)
@JoinColumn(name="number_teacher",referencedColumnName="number_teacher",unique=true)
private Teacher teacher;




public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public char[] getContent() {
	return content;
}
public void setContent(char[] content) {
	this.content = content;
}
public String getPlan_no() {
	return plan_no;
}
public void setPlan_no(String plan_no) {
	this.plan_no = plan_no;
}
	
	
	
	
	
	
}
