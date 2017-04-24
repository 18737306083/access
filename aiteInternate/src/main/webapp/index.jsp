<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教务管理系统</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="jquery/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>


</script>
<style type="text/css">


</style>
</head>
<body>
 
<div class="left">
<div class="name11"><span>河南科技学院</span> </div>
<div class="name22"><span>教务网络管理系统</span> </div>
 
 </div>
 
<div class="right">
<div class="form-div">


<form class="form-horizontal" id="form1" role="form" action="admin_login" method="post">
 <div class="form-group" style="margin-top: 80px;">
    <label class="col-sm-2 control-label" for="select">身份:</label>
    <div  class="col-sm-7" style="padding-left: 5px;">
    <select id="select" name="select" class="form-control">
      <option value="student" >学生</option>
      <option value="teacher">教师</option>
      <option value="manager">管理员</option>
       
    </select>
    </div>
  </div>
  <div class="form-group">
    <label for="number" class="col-sm-2 control-label">帐号:</label>
    <div class="col-sm-7" style="padding-left: 5px;">
      <input type="text" required name="number" class="form-control" id="number" placeholder="请输入学号">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密码:</label>
    <div class="col-sm-7" style="padding-left: 5px;">
      <input type="password" minlength="2" class="form-control"  name="password" id="password" placeholder="请输入密码">
    </div>
  </div>
   <div style="padding-left: 9px;" class="form-group">
    <label for="yan" class="col-sm-2 control-label">验证码:</label>
    <div class="col-sm-2" style="padding-left: 1px;">
      <input type="text" class="form-control" name="yan" id="yan" required >
     
    </div>
  
    <div style="height: 30px;"  >     <img alt="验证码" id="y" src="/aiteInternate/picaode"/>    
     <a style="padding-left: 8px;display: inline-block; height:29px; text-decoration:none;  margin-left:9px; background-color: blue" id="yanzheng"   href="javascript:yan();">获取验证码</a></div>
  </div>
  <div class="form-group" style="margin-top: 20px;">
    <div class="col-sm-offset-1 col-sm-3">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="remember">请记住我
        </label>
      </div>
    </div>
    <div class="col-sm-offset-3 col-sm-3">
      <button type="button" class="btn btn-default" onclick="login()" >登录</button>
    </div>
  </div>
 
  
     
</form>
 <p class="text-center text-danger" id="prompt">账号密码错误</p>
</div>


</div>
<div class="bottom">
<div>
<address style="text-align: center; color:#D7CDFF;padding-top: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;河南科技学院
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;艾特网开发</address>
</div>


</div>

 <script type="text/javascript">
    function yan(){/* 
        alert("dsds"); */
        var d=new Date().getSeconds();
       document.getElementById("y").src="/aiteInternate/picaode?q="+d; 
        


	 }
    /* $.validator.setDefaults({
        submitHandler: function() {
          alert("提交事件!");
        }
    }); */
    $(function(){
   	 
		$("#prompt").hide();
		
		
	});
function login(){
	 
	 
	 var num=$("input[name='number']").val(); 
		var password=$("input[name='password']").val();
		
		var role=$("select").get(0).value;
		
		var yan=$("input[name='yan']").val();
	 
	 
	 
	 
 
 
 
 
		
		var datas={
				number:num,
				password:password,
				role:role,
				yans:yan
		}
		 alert("登录");
		$.ajax({
			url:"/aiteInternate/admin_juge",
			type:"post",
			data:datas,
			dataType:'json',
			success:function(msg){
				if(msg==="erro"){
					$("#prompt").show();
					alert("erro");
				}else if(msg==="correct"){
					$("#prompt").hide();
					alert("CORRECT");
					$($("#form1").get(0)).submit();
				}
				else if(msg="again"){
                         alert("agin");
					}
			}
		});

 
}

 </script>
  <a href="/aiteInternate/admin_juge">aaaaaaaaaaa</a>
</body>
</html>