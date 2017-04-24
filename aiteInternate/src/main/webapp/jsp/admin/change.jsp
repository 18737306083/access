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
<title>修改密码</title>
<link href="<%=basePath %>/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath %>/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/jquery/bootstrap.min.js"></script>

<style type="text/css">
.chaxun{
 margin-left: 220px;
 margin-top: 85px;

}


</style>


</head>
<body>
<div class="chaxun">
<form class="form-horizontal" id="form"  role="form" action="<%=basePath %>/ad_changepassword" method="post">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">旧密码</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" id="firstname" name="oldpassword"  placeholder="请输入密码">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" id="lastname1" name="newpassword"  placeholder="请输入新密码">
    </div>
  </div>
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" id="lastname2" placeholder="请输入再次确认">
      <span id="tip">两次输入不一致</span>
     <span id="tip">${requestScope.yan }</span>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-4">
      <button type="button" id="sub" class="btn btn-primary col-sm-3"   >登录</button>
    </div>
  </div>
</form>


</div>


<script type="text/javascript">
/*   $("#tt").click(function(){
    alert("段落被点击了。");
});     */
 $("#sub").click(function()  { 
  	  
	 
var old= $("#oldpassword").val();
var news=$("#lastname1").val();
var second=$("#lastname2").val();
 
if(news==second){
$("#form").submit();
	
}
else{
	 $("#tip").show(); 
	$("#lastname1").val("");
$("#lastname2").val("");
	
}
 
    });    

$("#lastname1").focus(function(){
	alert("fdfd");
  $("#tip").hide();  
  
});
$(function(){

	 $("#tip").hide(); 
});

</script>
</body>
</html>