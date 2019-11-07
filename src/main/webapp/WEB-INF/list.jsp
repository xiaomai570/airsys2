<%@ page language="java" contentType="text/html; charset=utf8"
    import="util.Pager,entity.Account,java.util.List"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>列出账号</title>
<link rel="stylesheet" type="text/css" href="/airsys2/assets/css/user.css">

</head>
<body>
	<h3 align="center">账号信息</h3>
	<hr color="red">
	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>余额</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${acts}" var="act">
				<tr>
					<td>${act.id}</td>
					<td>${act.name}</td>
					<td>${act.balance}</td>
					<td>
					   <a href="user/${act.id}">查看</a>
					   <a href="#" onclick="updateUser(${act.id })">修改</a>
					    <a href="#" onclick="deleteUser(${act.id })">删除</a>
					
					</td>
				</tr>
			</c:forEach>
		</table>	
		<script type="text/javascript"  src="/airsys2/assets/js/user.js"></script>
	</center>
</body>
</html>

<%-- 
	<%@指令名字  perperty1=value1  perperty2=value2 ... %>  ---- JSP指令 
	<%@page %> 页面指令，可以导入包  <%@taglib %> 可以引入标签库
	${acts}   <==> List<Account> acts = request.getAttribute("acts");
	${act.id}  <==>  act.getId();
	引入标签库的步骤：
	     1.  pom.xml 中引入相应的jstl.jar  :  jsp standard tag library
	     2.  在jsp页面中利用标签指令引入相应的标签
	         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	     3.  使用相应的标签
	     	 <c:forEach></c:forEach>   <c:if></c:if> 	
	实现前一页，后一页 
	
	spring mvc不是一个好东西，他的原因照成，
	DispacherServlet 拦截一切“/”
	让他不要拦截js,css,jpg...
	修改配置
--%>