package com.honoo.utils;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;




public class SMSUtils {
	public static void sendMsg(String number,String vertifi) {
	    String host = "http://sms.market.alicloudapi.com";
	    String path = "/singleSendSms";
	    String method = "GET";
	    String appcode = "78d95ae818484d7a907b60b68be27694";
	    Map<String, String> headers = new HashMap<String, String>();
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("ParamString", "{'no':'"+vertifi+"'}");
	    querys.put("RecNum", number);
	    querys.put("SignName", "»ªÙ¼Êµ´´»¶Ó­Äã");
	    querys.put("TemplateCode", "SMS_100775061");


	    try {
	    	
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println("result"+response.toString());
	    	
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
