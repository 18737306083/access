<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="../../jquery/bootstrap.min.js"></script>
<title>学生管理</title>
<style type="text/css">
.teaTop {
	margin-left: 650px;
	margin-top: 10px;
}

input {
	border: none;
}
input:focus{

 outline: none;
}
</style>
</head>
<body>
	<div class="teaTop">
		 
			 

			 
			<button type="button" class="btn btn-default  col-sm-offset-2" onclick="login();">添加学生</button>
			<button type="button" class="btn btn-default" onclick="modify()">提交修改</button>
		 


	</div>
	<div>
		<form class="form-inline" role="form">
			<table
				class="table table-striped table-bordered table-hover table-responsive">
				<h1 style="text-align: center;">学生信息</h1>
			 
				<tbody>
					<tr>

						<th class="col-lg-1">姓名</th>
						<td><input type="text" name="name" ></td>
<th>专业</th>
<td><input type="text" name="major"  ></td>
					</tr>

					<tr>

						<th class="col-lg-1">学号</th>
						<td><input type="text" name="number"  ></td>
	  <th>联系方式</th>
 
		 
              <td><input type="text" name="numberPhone"  ></td>
					</tr>
					<tr>

						<th>密码</th>
						<td><input type="text" name="password"></td>
             <th>准考证号</th>
              <td><input type="text" name="exNumber" ></td>

					</tr>
					<tr>

					
						<th>身份证</th>
						<td><input type="text" name="card"></td>
                      	<th>出生日期</th>	 

                   <td><input type="text" name="birth"   ></td>
					</tr>
					<tr>

						<th>行政班级</th>
						<td><input type="text" name="classNo"  ></td>
                    <th>学院</th>

                <td><input type="text" name="collegeNo"    ></td>
					</tr>
						<tr>
               <th>入学成绩</th>
						<td><input type="text" name="examitation"  ></td>
						<th>入学时间</th>
						<td><input type="text" name="enterSchool"  ></td>
						<!-- <td><div class="form-group">
    <label  for="inputfile">上传照片</label>
    <input type="file" id="inputfile">
  </div><img alt="查看" src="#"></td> -->
						
					</tr>
 

				</tbody>
			</table>
		</form>
	</div>
	<div> <a href="/aiteInternate/adminManager_inqueryPerson">AAAA</a></div>
<script type="text/javascript">

function modify(){
	   
	var birth=$("input[name='birth']").val();

	var classNoS=$("input[name='classNo']").val();
	var collegeNoS=$("input[name='collegeNo']").val();
	var enterSchoolS=$("input[name='enterSchool']").val();
	var examitationS=$("input[name='examitation']").val();
	var exNumberS=$("input[name='exNumber']").val();
	var cardS=$("input[name='card']").val();
	var majorS=$("input[name='major']").val();
	var nameS=$("input[name='name']").val();
	var numberS=$("input[name='number']").val();
	var numberPhoneS=$("input[name='numberPhone']").val();
	var passwordS=$("input[name='password']").val();
	var datas={
			enterSchool:enterSchoolS,
			examitation:examitationS,
			exNumber:exNumberS,
			major:majorS,
			name:nameS,
			number:numberS,
			numberPhone:numberPhoneS,
			password:passwordS,
			classNo:classNoS,
			collegeNo:collegeNoS,
			birth:birth,
			card:cardS
	}

	alert("qqqqQQQQQQ");
	$.ajax({
		url:"/aiteInternate/ad_modify",
		type:"post",
		data:datas,
		dataType:'json',
		success:function(msg){
			if(msg==="complete"){
				 
				alert("erro");
			} 
			 
		}
	});


	
}




function login(){
	var birth=$("input[name='birth']").val();

	var classNoS=$("input[name='classNo']").val();
	var collegeNoS=$("input[name='collegeNo']").val();
	var enterSchoolS=$("input[name='enterSchool']").val();
	var examitationS=$("input[name='examitation']").val();
	var exNumberS=$("input[name='exNumber']").val();
	var cardS=$("input[name='card']").val();
	var majorS=$("input[name='major']").val();
	var nameS=$("input[name='name']").val();
	var numberS=$("input[name='number']").val();
	var numberPhoneS=$("input[name='numberPhone']").val();
	var passwordS=$("input[name='password']").val();
	 
	 
		 
		var datas={
				enterSchool:enterSchoolS,
				examitation:examitationS,
				exNumber:exNumberS,
				major:majorS,
				name:nameS,
				number:numberS,
				numberPhone:numberPhoneS,
				password:passwordS,
				classNo:classNoS,
				collegeNo:collegeNoS,
				birth:birth,
				card:cardS
		}
		  
		/* alert(numberS+nameS+passwordS +enterSchool   +examitation+exNumber+iD+major+name+number+numberPhone+password+classNo+collegeNo  );  */
		  alert(nameS);  
		
 alert("qqqqQQQQQQ");
		$.ajax({
			url:"/aiteInternate/ad_saveStudent",
			type:"post",
			data:datas,
			dataType:'json',
			success:function(msg){
				if(msg==="complete"){
					 
					alert("erro");
				} 
				 
			}
		});

 
}

 </script>

</body>
</html>