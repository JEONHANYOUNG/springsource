<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>doB</h3>
<h4>age : <%=request.getParameter("age") %></h4>
<h4>name : ${name}</h4> <%-- ${} : request.setAttribute() or session.setAttribute() (session에 잠시 담아둔 것) --%>
<h4><a href="/doC">이동</a></h4> <%-- http://localhost:8080/doC --%>
</body>
</html>