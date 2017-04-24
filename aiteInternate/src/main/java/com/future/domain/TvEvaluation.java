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
 * @version 创建时间：2017年3月2日 上午8:56:46 
 * 类说明
 * 
 *  评教类
 *  
 */

@Entity
@Table(name="eva_inf")
public class TvEvaluation {
//课程号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer courseNo;
//评级
private String eva;
//评价日期
private Date date;
//课程
@OneToOne(targetEntity=Course.class)
@JoinColumn(name="courseNo",referencedColumnName="courseNo",unique=true)

private Course course;



public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Integer getCourseNo() {
	return courseNo;
}
public void setCourseNo(Integer courseNo) {
	this.courseNo = courseNo;
}
public String getEva() {
	return eva;
}
public void setEva(String eva) {
	this.eva = eva;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
	
	
	
}
