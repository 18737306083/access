package com.future.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月3日 上午8:22:24 
 * 类说明
 * 成绩表
 *  
 */
@Entity
@Table(name="scores_inf")
public class Scores {
//逻辑主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  numberScores;
//原始成绩
	private float oldScores;
//最终成绩
private float finalScores;
 
@OneToOne(targetEntity=Course.class,mappedBy="scores")
private Course course;


public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Integer getNumberScores() {
	return numberScores;
}
public void setNumberScores(Integer numberScores) {
	this.numberScores = numberScores;
}
public float getOldScores() {
	return oldScores;
}
public void setOldScores(float oldScores) {
	this.oldScores = oldScores;
}
public float getFinalScores() {
	return finalScores;
}
public void setFinalScores(float finalScores) {
	this.finalScores = finalScores;
}
	
	
	
}
