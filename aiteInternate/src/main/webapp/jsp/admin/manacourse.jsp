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
<form class="form-inline" role="form" action="/aiteInternate/adminteacher_addTeacher" style="margin-left: 10px;" >
   
  <div class="form-group" style="margin-left: 10px;" > 
    <label for="department">学期</label>
    <select class="form-control" name="department">
      <option value="20172">2017第二学期</option>
      <option value="20171">2017第一学期</option>
     <option value="20162">2016第二学期</option>
      <option value="20161">2016第一学期</option>
        <option value="20152">2015第二学期</option>
      <option value="20151">2015第一学期</option> 
       <option value="20142">2014第二学期</option>
      <option value="20141">2014第一学期</option>
    </select>
    
  </div>
  <div class="form-group">
    <label for="name">班级</label>
    <input type="text" class="form-control" id="name" name="teachername" autocomplete="off"  placeholder="请输入班级">
  </div>
   
   
  
   
  <button type="submit" id="sub" style="margin-left: 40px;"  class="btn btn-default">搜索</button>
<button type="button"  style="margin-left: 10px;" class="btn  btn-default">打印</button>
<button type="button"  style="margin-left: 10px;" class="btn  btn-default">修改学期</button>
<button type="button"  style="margin-left: 10px;" class="btn  btn-default">课表修改</button>
 
</form>
 
<div class="table ">
  <table class="table table-responsive table-hover table-bordered ">
<center><h4> 课表信息</h4></center>  
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
 
</script>









</body>
</html>