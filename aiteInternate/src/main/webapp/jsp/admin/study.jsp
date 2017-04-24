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



<title>教学管理</title>
<style type="text/css">
.btn-default {
	background-color: #B1FF9A;
}

 
</style>
</head>
<body>
	<form class="form-inline" role="form"
		action="/aiteInternate/adminteacher_addTeacher"
		style="margin-left: 10px;">




<form class="form-inline" id="form1" role="form" method="post"
		action="#"
		style="margin-left: 10px;">
		<div class="form-group" style="margin-left: 50px;margin-top: 4px;">
			<label for="class1">班级 :</label> <input type="text" class="form-control"
				id="class1" name="class1" placeholder="请输入班级">
				<button type="button" id="sub" style="margin-left: 10px;"
			class="btn  btn-default">搜索</button>
 
		</div>
		</form>
		 
		
		<div class="table ">
			<table class="table table-responsive table-hover table-bordered ">

				<center>
					<h2>教学安排</h2>
				</center>

				 <tbody id="tt"></tbody>
           
            
				 
					 
			</table>
		</div>

	</form>
 
<script type="text/javascript">

	var totals;
 
//分页查询
 $("#sub").click(function(){
	  shuju(0);

	 });
 




$(function(){
 
var class1=$("#class1").val();
 var datas={class1:class1};
	 	
	 	$.ajax(
	 			{
	 			url:"<%=basePath%>/adminteacher_findCount",
	 			dataType:"json",
	 			type:"post",
	 			data:datas,
	 			success:function(result){
	 				 
	 				 
	 				 totals=result;
	 				 $("#newPagination").pagination(  totals, 

	 						 {
	 							 
	 							 num_display_entries:3,
	 								items_per_page:5, 
	 								   
	 								next_text:"下一页",
	 								prev_text:"上一页",
	 						         num_edge_entries:2,
	 								callback:handles
	 							});	
	 							
	 						 $("sex").val("${sex}");
	 			}});
			 
	
	 
});



function shuju(new_page_index){

	var class1=$("#class1").val();
	 var datas={class1:class1};
	$.ajax(
			{
			url:"<%=basePath%>/adminteacher_lookteacherinfo ",
			dataType:"json",
			type:"post",
			data:datas,
			success:function(result){
		 
				  var s = "";  
				 for (var idx = 0; idx < result.length; idx++) {  
                  
				s+="<tr><td>"+ result[idx].number_teacher+"</td><td>"+result[idx].teachername +"</td><td>"+ result[idx].sex +"</td><td>"+result[idx].title +"</td><td>"+result[idx].newberphone +"</td><td>"+ result[idx].department 
				+"</td><td>  <button type='button'  id="+result[idx].number_teacher+" class='btn btn-default'>删除</button></td> </tr>" 
				 
                 }      

				    
				 
				  
				  
				  $("#tt").html(s); 
				  $("#1 ").css("color","red"); 
				 
				//删除数据
			    $("button[type='button']").click(function(){
				   
				  	  var number_teacher= $(this).attr("id"); 
				  	 var datas={number_teacher:number_teacher};
					 	
					   $.ajax(
					 			{
					 			url:"<%=basePath%>/adminteacher_deleteByTeacher",
					 			dataType:"json",
					 			type:"post",
					 			data:datas,
					 			success:function(result){
					 				 //删除成功
					 				  alert("success"); 
					 				 
					 				 
				  	  
				}  });    
			    });
				 

					}});
 
	
};

function handles(new_page_index, pagination_container) {

	   shuju(new_page_index);
           
   return false;
}



</script>



</body>
</html>