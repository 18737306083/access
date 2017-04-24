<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.cai{
  position:relative;
 
  left: 790px;
 
}
    
.biaoti1{
float:left;
  
 margin-left:90px;
font-weight:190;
font-size: 32px;
font-family: "宋体",sans-serif;
text-shadow: 2px 2px 5px #0000A0;
color: #FFFFFF;
}
.biaoti2{
float:left;
 margin-left:90px;
 clear:left;
 height:34px;
font-size: 26px;
color: #DED7FF;
}
 .time{
 
 text-indent:20px;
clear:both;
vertical-align:middle;
 margin-top:23px;
  height:30px;
 width:100%px;
 background-color:#80D0FF;
color: #0080FF;
 
}
 

</style>
</head>
<body  >
<div class="top11">
<div class="pic">
 
<span class="biaoti1" >教务管理系统</span><br/>
<span class="biaoti2">Education Info Management</span>
</div>
 
<div class="cai">
<a href="#">个人信息 |</a>
<a href="#">修改密码 |</a>
<a href="admin_loginOut">退出系统</a>

</div>
 
 

 <div>
 <div class="time">
 <p id="time11"></p>
 
 <div >
 
 </div>
 <div >
  
 </div>
 </div>
 
 </div>

 
</div>
  <script type="text/javascript">

function startTime(){
	var date=new Date();
var y=date.getFullYear();
var month=date.getMonth();
var day=date.getDate();
var hour=date.getHours();
var minute=date.getMinutes();
var second=date.getSeconds()
 
document.getElementById("time11").innerHTML="今天是:  "+y+"年"+month+"月"+day+"日       "+hour+"时"+minute+"分"+second+"秒";
 
 


	
}

setInterval(function(){startTime()},1000);

</script>  
</body>
</html>