package com.future.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月3日 上午8:46:21 
 * 类说明
 * 教材信息
 *  
 */
@Entity
@Table(name="book_inf")
public class Books {
//逻辑主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer number;
	//图书逻辑编号
private String book_no;
	
//教材名
private String name;
//出版社
private String publish;
//价格
private float price;
//购买日期
private Date date;
@OneToOne(targetEntity=Course.class)
@JoinColumn(name="courseNo",referencedColumnName="courseNo",unique=true)
private Course course;


public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPublish() {
	return publish;
}
public void setPublish(String publish) {
	this.publish = publish;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getBook_no() {
	return book_no;
}
public void setBook_no(String book_no) {
	this.book_no = book_no;
}
	
	
	
	
}
