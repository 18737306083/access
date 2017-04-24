package com.future.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月3日 上午8:11:20 
 * 类说明
 * 
 * 课程表
 */
@Entity
@Table(name="course_inf")
public class Course {

//课程号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer course_id;
	
	
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	private Integer courseNo;
//课程名
	@Column(nullable=false,unique=true)
	private String courseName;
//	学生
	@ManyToMany(targetEntity=Student.class)
	@JoinTable(name="student_course",joinColumns=@JoinColumn(name="course_id",referencedColumnName="course_id"),
	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id"))
  private Set<Student> student=new HashSet<>();
	//成绩表关联
	@OneToOne(targetEntity=Scores.class)
	@JoinColumn(name="scores_id",referencedColumnName="numberScores",unique=true)
	private Scores scores;
	//教师关联
	 @ManyToOne(targetEntity=Teacher.class)
	 @JoinColumn(name="teacher",referencedColumnName="number_teacher",nullable=false)
	 private Teacher teacher;
	 //班级
	 
	 @ManyToMany(targetEntity=Classes.class)
	 @JoinTable(name="classes_course",joinColumns=@JoinColumn(name="courseNo",referencedColumnName="courseNo"),
	 inverseJoinColumns=@JoinColumn(name="class_num",referencedColumnName="class_num"))
	 private Set<Classes> classes=new HashSet<>();

	//课本
	@OneToOne(targetEntity=Books.class,mappedBy="course")
private Books books;
	
	
	//上课时间、
	private String time;
	//上课节
	private String jie;
	//上课地点
	private String position;
	
	
	
	
	 public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getJie() {
		return jie;
	}
	public void setJie(String jie) {
		this.jie = jie;
	}
 
	 
	
	 
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Scores getScores() {
		return scores;
	}
	public void setScores(Scores scores) {
		this.scores = scores;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public Integer getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Set<Classes> getClasses() {
		return classes;
	}
	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((courseNo == null) ? 0 : courseNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseNo == null) {
			if (other.courseNo != null)
				return false;
		} else if (!courseNo.equals(other.courseNo))
			return false;
		return true;
	}
	
	
	
}
