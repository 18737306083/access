<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师管理</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/jquery/bootstrap.min.js"></script>
<style type="text/css">
.btn-default{
background-color: #B1FF9A;


}
.form-inline{
  
margin-top: 10px;


}

</style>

</head>
<body>
<form class="form-inline" role="form" action="/aiteInternate/adminClass_findbyclasses" style="margin-left: 10px;" >
   
 
  <div class="form-group">
    <label for="name">班级</label>
    <input type="text" class="form-control" id="name" name="class_name" autocomplete="off"  placeholder="请输入班级">
  </div>
   
   
  
   
  <button type="submit" id="sub" style="margin-left: 40px;"   class="btn btn-default">搜索</button>
<button type="button"  style="margin-left: 10px;" class="btn  btn-default">编辑</button>
<button type="button"  style="margin-left: 10px;" id="addstudent" class="btn  btn-default">添加学生</button>
 <button type="button"  style="margin-left: 10px;" id="addclasses" class="btn  btn-default">添加班级</button>
 
</form>
 
<div class="table ">
  <table class="table table-responsive table-hover table-bordered ">
<center><h4> 班级信息</h4></center>  
    <thead>
      <tr>
        <th>教师编号</th>
        <th> 教师名称</th>
        <th>教师性别</th>
         <th>教师职称</th>
        <th>联系方式</th>
        <th>院系</th>
        <th>编辑</th>
        </tr>
    </thead>
    <tbody>
      <tr>
         <td>sss</td>
          <td>sss</td>
          <td>sss</td>
          <td>sss</td>
          <td>sss</td>
           <td>sss</td>
            <td>sss</td>
      </tr>
    </tbody>
  </table>
</div>

 



<script type="text/javascript">
$("#addclasses").click(function(){
	window.open("/aiteInternate/jsp/admin/addClasses.jsp","_blank","toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes,left=340,top=10, width=500, height=560")

	
});

$("#addstudent").click(function(){

	window.open("/aiteInternate/jsp/admin/classestudent.jsp","_blank","toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes,left=340,top=10, width=500, height=560")

	
});
 /*  var class_name=$("#name").val(); */
/* var datas={class_name:class_name}; */

  
/* $("#sub").click(function(){
$.ajax({
	url: "/aiteInternate/adminClass_",
	data: datas,
	dataType:json,
	success:function(result){
      alert("chengg");

		}
});

	
}); */


</script>









</body>
</html>