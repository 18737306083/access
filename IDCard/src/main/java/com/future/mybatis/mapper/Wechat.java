package com.future.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

/** 
 * @author 
 * @version 
 *  
 */
public interface Wechat {
	void registerByWeChat(@Param(value="password")String password,@Param(value="number") String number);
}
