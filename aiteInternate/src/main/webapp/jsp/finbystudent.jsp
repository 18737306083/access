<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=basePath %>/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath %>/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/jquery/bootstrap.min.js"></script>
</head>
<body>
<a href="#">FDSFD</a>



 
  <table style="width: 1100px;" class="table table-striped table-bordered table-hover table-responsive">
				<h1 style="text-align: center;">学生信息</h1>
			 
				  <tbody>
					<tr>

						<th class="col-lg-1">姓名</th>
						<td style="width: 160px;"> <c:property value="name"/></td>
<th>专业</th>
<td> <c:property value="major"/></td>
					</tr>

					<tr>

						<th class="col-lg-1">学号</th>
						<td> <c:property value="number"/></td>
	  <th>联系方式</th>
 
		 
              <td> <c:property value="numberPhone"/></td>
					</tr>
					<tr>

					<th>入学时间</th>
						<td> <c:property value="enterSchool"/>   </td>
             <th>准考证号</th>
              <td> <c:property value="exNumber"/></td>

					</tr>
					<tr>

					
						<th>身份证</th>
						<td> <c:property value="card"/></td>
                      	<th>出生日期</th>	 

                   <td> <c:property value="birth"/></td>
					</tr>
					<tr>

						<th>行政班级</th>
						<td> <c:property value="classNo"/></td>
                    <th>学院</th>

                <td>  <c:property value="collegeNo"/>  </td>
					</tr>
						<tr>
               <th>入学成绩</th>
						<td> <c:property value="examitation"/>   </td>
						
						 
						
					</tr>
 

				</tbody>  
			</table>
			 
</body>
</html>