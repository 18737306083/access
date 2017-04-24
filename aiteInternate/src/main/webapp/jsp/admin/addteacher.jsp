<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/jquery/bootstrap.min.js"></script>



<title>添加新的教师</title>
<style type="text/css">
.btn-default {
	background-color: #B1FF9A;
}

.form-inline {
	margin-top: 10px;
}

.form-control {
	border: none;
}

.form-control:focus {
	outline: none;
}
</style>
</head>
<body>
	<form class="form-inline" role="form"
		action="/aiteInternate/adminteacher_addTeacher"
		style="margin-left: 10px;">





		<button type="submit" id="sub" style="margin-left: 290px;"
			class="btn btn-default">提交</button>
		<button type="button" style="margin-left: 10px;"
			class="btn  btn-default">重置</button>

		<div class="table ">
			<table class="table table-responsive table-hover table-bordered ">

				<center>
					<h2>教师信息</h2>
				</center>

				<tr>
					<th style="width: 150px; text-align: center; height: 40px;">教师编号</th>

					<td><input type="text" name="number_teacher" class="form-control"></td>




				</tr>

				<tbody>
					<tr>
						<th
							style="width: 150px; text-align: center; height: 40px; vertical-align: middle;">
							教师名称</th>
						<td><input type="text" name="teachername"
							class="form-control"></td>

					</tr>
					<tr>
						<th
							style="width: 150px; text-align: center; height: 40px; vertical-align: middle;">密码</th>
						<td><input type="text" name="pasword_teacher"
							class="form-control"></td>
					</tr>
					<tr>
						<th
							style="width: 150px; text-align: center; height: 40px; vertical-align: middle;">教师性别</th>
						<td><input type="text" name="sex" class="form-control"></td>

					</tr>
					<tr>
						<th
							style="width: 150px; text-align: center; vertical-align: middle; height: 40px;">教师职称</th>

						<td><input type="text" name="title" class="form-control"></td>


					</tr>
					<tr>
						<th
							style="width: 150px; text-align: center; vertical-align: middle; height: 40px;">联系方式</th>
						<td><input type="text" name="newberphone"
							class="form-control"></td>
					</tr>
					<tr>
						<th
							style="width: 150px; text-align: center; height: 40px; vertical-align: middle;">院系</th>
						<td><input type="text" name="department" class="form-control"></td>
					</tr>



				</tbody>
			</table>
		</div>

	</form>
<div><c:if test="#request.key != null"> <center> <h4> 添加成功  </h4> </center></c:if>   </div>

</body>
</html>