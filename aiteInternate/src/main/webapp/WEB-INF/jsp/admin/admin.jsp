<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%
	//得到url的根路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教务管理</title>
<link  href="<%=basePath %>/css/ad.css" rel="stylesheet" type="text/css">
<style type="text/css">
/* css路径为上个jsp路径请求转发 */
<%-- <%=basePath %> --%>

</style>
</head>
<body>
<div class="top"><jsp:include page="top.jsp"></jsp:include></div>
<div>
<div class="right"> <iframe src="html/welcome.html"  name="frame"  width="100%" height="460" frameborder="0"  >
</iframe> </div>


 
<div class="left">   <%-- <jsp:include page="admin_left.jsp"></jsp:include>   --%>
   <c:if test="#session.admin != null">   


<iframe src="admin_left.jsp"   width="200" height="460" frameborder="0"  >
</iframe>
    </c:if>    
   <c:elseif test="#session.stu != null">
<iframe src="first.jsp"   width="200" height="460" frameborder="0"  >
</iframe>
</c:elseif> 
 <c:elseif test="#session.teacher != null">
<iframe src="teacher.jsp"   width="200" height="460" frameborder="0"  >
</iframe>
</c:elseif> 
<%-- <c:else  > 
<iframe src="admin_left.jsp"   width="200" height="460" frameborder="0"  >
</iframe>  
  </c:else>  --%> 

</div>
</div>
<%-- <div class="bottom"><jsp:include page="bottom.jsp"></jsp:include>    </div> --%>
</body>
</html>