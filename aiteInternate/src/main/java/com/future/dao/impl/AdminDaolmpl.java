package com.future.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.future.dao.AdminDao;
import com.future.domain.Admin;
 
import com.future.domain.Classes;
import com.future.domain.Course;
import com.future.domain.Student;
import com.future.domain.Teacher;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年3月6日 下午9:29:52 
 * 类说明 
 */
@Repository
public class AdminDaolmpl extends HibernateUtils implements AdminDao {

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
	 System.out.println(student.getExamitation()+""+student.getName());
      geSession().save(student);
       
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
geSession().delete(student);
	}

	@Override
	public void addTacher(Teacher teacher) {
		// TODO Auto-generated method stub
		geSession().save(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String hql="from Teacher t where t.number_teacher = :number_teacher";
	Teacher tt=	(Teacher) geSession().createQuery(hql).setString("number_teacher", teacher.getNumber_teacher()).uniqueResult();
geSession().delete(tt);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
geSession().update("Teacher", teacher.getNumber_teacher());
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
	/*	geSession().saveOrUpdate(student);*/
		geSession().update(student);
		 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentByPages(int firstResults, int maxResults) {
		// TODO Auto-generated method stub
		String hql="select s from Student s";
		geSession().createQuery(hql).setFirstResult((firstResults-1)*maxResults).setMaxResults(maxResults).list();
		
		return geSession().createQuery(hql).setFirstResult((firstResults-1)*maxResults).setMaxResults(maxResults).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findTeacher(int firstResults, int maxResults,Teacher teacher) {
		String hql="from Teacher t where t.department = :department and t.title = :title and sex = :sex";
		
		
		return geSession().createQuery(hql).setString("department", teacher.getDepartment()).setString("title", teacher.getTitle()).setString("sex", teacher.getSex()).setFirstResult(firstResults*maxResults).setMaxResults(maxResults).list();
	}

	@Override
	public Admin getloginAdmin(Admin admin) {
		// TODO Auto-generated method stub
String hql="From Admin a where a.count = :count and a.password = :password";
 System.out.println(hql);
System.out.println(admin.getPassword()+admin.getCount());
	 Admin ad=(Admin) geSession().createQuery(hql).setString("count", admin.getCount()).setString("password", admin.getPassword()).uniqueResult();
		System.out.println(ad+"1234567890");
		return ad;
		 	}

	
	//添加管理员
	public void insert(Admin ad){
		System.out.println(ad.getPassword()+ad.getCount());
 	 	geSession().saveOrUpdate(ad);
		
		
	}
 

@Override
public Student findStudent(String n) {
	// TODO Auto-generated method stub
String	hql="From Student s where s.number = :numbers";
System.out.println(hql);
	return (Student) geSession().createQuery(hql).setString("numbers", n).uniqueResult();
}

@Override
public void changepassword(String i) {
	// TODO Auto-generated method stub
	String hql="From Admin";
	Admin admin=(Admin) geSession().createQuery(hql).uniqueResult();
	admin.setPassword(i);
	geSession().saveOrUpdate(admin);
}

@Override
public void addClasses(Classes classes) {
	// TODO Auto-generated method stub
	System.out.println("classes.....");
	geSession().save(classes);
	
	
	
}

@Override
public Student findStudentbyClass(Student student) {
	// 班级添加学生
	String	hql="From Student s where s.number = :numbers and s.name = :name";
	System.out.println("findstudent............");
		return (Student) geSession().createQuery(hql).setString("numbers",student.getNumber()).setString("name", student.getName()).uniqueResult();
	}

@Override
public void classaddStudent(Classes classes, Student stdent) {
	// TODO Auto-generated method stub
	String	hql="From Classes c where  c.class_name= :name";
	System.out.println("fclassaddstudent............");
Classes	classe=(Classes) geSession().createQuery(hql).setString("name", classes.getClass_name()).uniqueResult();
Set<Student> students=new HashSet<>();
students.add(stdent);
	/*classe.setStudent(students);*/
	geSession().saveOrUpdate(classe);
	
}

@SuppressWarnings("unchecked")
@Override
public List<Student> findstudentByClasses(Classes classes) {
	String hql="select s From Student s where s.classes.class_name = :name";
	
	System.out.println("liststudent..........");
	return (List<Student>)geSession().createQuery(hql).setString("name", classes.getClass_name()).list();
}
 
	
}
