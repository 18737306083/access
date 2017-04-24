<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师管理</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/jquery/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery.pagination.js"></script>
<link href="<%=basePath%>/css/pagination.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
.btn-default {
	background-color: #B1FF9A;
}

.form-inline {
	margin-top: 10px;
}
</style>

</head>
<body>
	<form class="form-inline" id="form1" role="form" method="post"
		action="/aiteInternate/adminteacher_lookteacherinfo"
		style="margin-left: 10px;">
		 
		<div class="form-group" style="margin-left: 10px;">
			<label for="department">院系</label> <select class="form-control"
				name="department" id="department">
				<option value="信息工程学院">信息工程学院</option>
				<option value="机电学院">机电学院</option>
				<option value="经济管理学院">经济管理学院</option>
				<option value="文法学院">文法学院</option>

			</select>

		</div>
		<div class="form-group" style="margin-left: 10px;">
			<label for="title">职称</label> <select class="form-control"
				name="title" id="title">

				<option value="初级">初级</option>
				<option value="中级">中级</option>
				<option value="高级">高级</option>

			</select>

		</div>
		<div class="form-group" style="margin-left: 10px;">
			<label for="sex">性别</label> <select class="form-control" name="sex"
				id="sex">

				<option value="男">男</option>
				<option value="女">女</option>

			</select>

		</div>


		<button id="sub" type="button" style="margin-left: 40px;"
			class="btn btn-default">搜索</button>
		<button type="button" id="100" style="margin-left: 10px;"
			class="btn  btn-default">打印</button>
<button type="button" id="add" style="margin-left: 10px;"
			class="btn btn-default">添加</button>
	 
	</form>
 

	<div class="table ">
		<table class="table table-responsive table-hover table-bordered ">
			<center>
				<h4>教师信息</h4>
			</center>
			<thead>
				<tr>
					<th>教师编号</th>
					<th>教师名称</th>
					<th>教师性别</th>
					<th>教师职称</th>
					<th>联系方式</th>
					<th>院系</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody id="tt">
				
			</tbody>
		</table>
	</div>

	<div style="text-align: center;" id="newPagination"></div>




	<script type="text/javascript">

	var totals;
<%-- $("#sub").click(function(){
	var department= $("#department").val();
	var sex=$("#sex").val();
	var title=$("#title").val();
var datas={department:department,sex:sex,title:title};

	
	$.ajax(
			{
			url:"<%=basePath%>/adminteacher_lookteacherinfo ",
			dataType:"json",
			type:"post",
			data:datas,
			success:function(result){

alert(result);
				
			}});


	
});

 --%>




$("#add").click(function(){
	/*  window.open(url, windowName, windowFeatures, optionalArg4) */
	 window.open("/aiteInternate/jsp/admin/addteacher.jsp",
	"_blank","toolbar=yes, location=no, status=no,left=350,top=10, menubar=no, scrollbars=yes, copyhistory=yes, width=550, height=600");



		
});






//分页查询
 $("#sub").click(function(){
	  shuju(0);

	 });
 




$(function(){
	
	  
 var department= $("#department").val();
var sex=$("#sex").val();
var title=$("#title").val();
 var datas={department:department,sex:sex,title:title};
	 	
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

	var department= $("#department").val();
	var sex=$("#sex").val();
	var title=$("#title").val();
var datas={department:department,sex:sex,title:title,pageIndex:new_page_index};

	
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
    // This selects 20 elements from a content array
     <%--  $("#form1").attr("action","<%=basePath%>/adminteacher_lookteacherinfo?pageNum="+(new_page_index+1));   --%>
    

 	 
     
           shuju(new_page_index);
           
   return false;
}



</script>









</body>
</html>