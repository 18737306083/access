package com.future.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.honoo.controll.Person;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��9��7�� ����3:50:42 
 * ��˵�� 
 */
public interface PersonMapper {
Person select_password(@Param(value="number") String number,@Param(value="password")String password);
void insertPersonByAll(Person person);
int updatePassword(@Param(value="password")String password,@Param(value="number")String number);
String selectExsistPhone(@Param(value="number") String number);
void updateUser(Person person);
void registerByChat(@Param(value="password1")String password1,@Param(value="number1") String number1,@Param(value="model")String model);


}
