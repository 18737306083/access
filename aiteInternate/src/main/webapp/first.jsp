<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生登录</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="jquery/bootstrap.min.js"></script>
<style type="text/css">
a:link{
text-decoration:none;
}
</style>
</head>
<body>

  <div class="panel-group" id="accordion">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#person1">
					
					  <div style="width: 150px;">  个人信息  </div>	
				</a>
			</h4>
		</div>
		<div id="person1" class="panel-collapse collapse">
			<div class="panel-body">
			 <ul style="list-style-type:disc">
 <li><a href="jsp/person.jsp" target="frame">查看个人信息</a></li>
 
 
</ul> 
			</div>
		</div>
	</div>
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#password">
				
				 <div style="width: 150px;">修改密码 </div>	
				</a>
			</h4>
		</div>
		<div id="password" class="panel-collapse collapse">
			<div class="panel-body">
							 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/change.jsp" target="frame">修改个人密码</a></li>
 
 
</ul> 
			</div>
		</div>
	</div>
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  "  class="panel-title">
				<a data-toggle="collapse"    data-parent="#accordion" 
				   href="#class1">
				 <div style="width: 150px;"> 学籍查询 </div>	
				</a>
			</h4>
		</div>
		<div id="class1" class="panel-collapse collapse">
			<div class="panel-body">
				 			 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/findclass.jsp" target="frame">基本信息</a></li>
 
  <li><a  href="jsp/admin/manaclass.jsp" target="frame">注册信息</a></li>
</ul> 
			</div>
		</div>
	</div>
	
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#teacher">
				
				 <div style="width: 150px;">  培养方案</div>	
				</a>
			</h4>
		</div>
		<div id="teacher" class="panel-collapse collapse">
			<div class="panel-body">
			 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/findteacher.jsp" target="frame">专业培养方案</a></li>
				 
</ul> 
			
				
			</div>
		</div>
	</div>
	
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#course">
				    <div style="width: 150px;"> 网上选课</div>	
					
				</a>
			</h4>
		</div>
		<div id="course" class="panel-collapse collapse">
			<div class="panel-body">
						 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/findcourse.jsp" target="frame">正选</a></li>
				 <li><a  href="jsp/admin/manacourse.jsp" target="frame">正选结果</a></li>
</ul> 
				 
			</div>
		</div>
	</div>
	
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#study">
				    <div style="width: 150px;">  学生成绩</div>	
					
				</a>
			</h4>
		</div>
		<div id="study" class="panel-collapse collapse">
			<div class="panel-body">
									 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/study.jsp" target="frame">查看成绩</a></li>
</ul> 
				
			</div>
		</div>
	</div>
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#student">
				    <div style="width: 150px;">  学生管理  </div>	
					
				</a>
			</h4>
		</div>
		<div id="student" class="panel-collapse collapse">
			<div class="panel-body">
												 <ul style="list-style-type:disc">
 <li><a  href="jsp/admin/findstudent.jsp" target="frame">网上评教</a></li>
  <li><a  href="jsp/admin/manastudent.jsp" target="frame"> 提交教学评价</a></li>
</ul> 
				
			</div>
		</div>
	</div>
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 style=" text-align: center;  " class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#eva">
				    <div style="width: 150px;">  	评教 </div>	
				
				</a>
			</h4>
		</div>
		<div id="eva" class="panel-collapse collapse">
			<div class="panel-body">
															 <ul style="list-style-type:disc">
 <li><a href="jsp/admin/eva.jsp" target="frame" >评教管理</a></li>
</ul> 
			</div>
		</div>
		 
	</div>
	 
 
 	 


</body>
</html>