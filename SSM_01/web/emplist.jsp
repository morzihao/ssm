<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎您${us.rname}</h1>
	 <table border="1" cellspacing="0" width="800" >
		<tr>
			<td>姓名</td>
			<td>职位</td>
			<td>上司</td>
			<td>入职日期</td>
			<td>工资</td>
			<td>奖金</td>
			<th>部门</th>
		</tr>
		<c:forEach items="${list }" var="e" >
			<tr>
				<td>${e.ename }</td>
				<td>${e.job }</td>
				<td>${e.mgr }</td>
				<td><fmt:formatDate value="${e.hiredate }"/></td>
				<td>${e.sal }</td>
				<td>${e.comm }</td>
				<td>${e.dept.dname }</td>
			
			</tr>
		</c:forEach> 
	</table> 
</body>
</html>