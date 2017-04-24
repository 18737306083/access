<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="/struts-tags" %>
    <%@taglib prefix="J" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="../../jquery/bootstrap.min.js"></script>
<style type="text/css">
.top_main{
margin-left: 260px;
margin-top: 10px;
}

</style>

</head>
<body>
 
<div class="top_main">
<form class="form-inline" role="form" action="/aiteInternate/ad_findStudent" method="post">
			<div class="form-group">
				<label for="firstname" style="margin-top: 5px;"
					class="col-sm-3 control-label">查找 :</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="firstname"
					name="number"	placeholder="请输入学号">
				</div>
			</div>

			<button type="submit" class="btn btn-default">确认</button>
			 
		</form>
</div>

<%-- <J:choose>
<J:when test="${requestCope.studentnum == null}">
<span>未查询学生信息</span>

</J:when>
<J:otherwise>
<table
				class="table table-striped table-bordered table-hover table-responsive">
				<h1 style="text-align: center;">学生信息</h1>
			 
				<tbody>
					<tr>

						<th class="col-lg-1">姓名</th>
						<td> <c:property value="#name"/></td>
<th>专业</th>
<td> <c:property value="#major"/></td>
					</tr>

					<tr>

						<th class="col-lg-1">学号</th>
						<td> <c:property value="number"/></td>
	  <th>联系方式</th>
 
		 
              <td> <c:property value="#numperPhone"/></td>
					</tr>
					<tr>

						<th>密码</th>
						<td> <c:property value="#password"/></td>
             <th>准考证号</th>
              <td> <c:property value="#exNumber"/></td>

					</tr>
					<tr>

					
						<th>身份证</th>
						<td> <c:property value="card"/></td>
                      	<th>出生日期</th>	 

                   <td> <c:property value="birth"/></td>
					</tr>
					<tr>

						<th>行政班级</th>
						<td> <c:property value="#classNo"/></td>
                    <th>学院</th>

                <td>  <c:property value="collegeNo"/>  </td>
					</tr>
						<tr>
               <th>入学成绩</th>
						<td> <c:property value="#examitation"/>   </td>
						<th>入学时间</th>
						<td> <c:property value="enterSchool"/>   </td>
						 
						
					</tr>
 

				</tbody>
			</table> 



</J:otherwise>


</J:choose>

 
 
 --%>
 

 


<div>

</div>

 
</body>
</html>