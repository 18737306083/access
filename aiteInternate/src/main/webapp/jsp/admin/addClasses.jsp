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



<title>添加新的班级</title>
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
		action="/aiteInternate/adminClass_add"
		style="margin-left: 10px;">





		<button type="submit" id="sub" style="margin-left: 290px;"
			class="btn btn-default">提交</button>
		<button type="button" style="margin-left: 10px;"
			class="btn  btn-default">重置</button>

		<div class="table ">
			<table class="table table-responsive table-hover table-bordered ">

				<center>
					<h2>添加班级</h2>
				</center>

				<tr>
					<th style="width: 150px; text-align: center; height: 40px;">班级编号</th>

					<td><input type="text" name="class_num" class="form-control"></td>




				</tr>
 <tr>
					<th style="width: 150px; text-align: center; height: 40px;">班级名称</th>

					<td><input type="text" name="class_name" class="form-control"></td>




				</tr>
				<tr>
					<th style="width: 150px; text-align: center; height: 40px;">班级性质 </th>

					<td><input type="text" name="class_propertity" class="form-control"></td>




				</tr>
			</table>
		</div>

	</form>
 

</body>
</html>l>