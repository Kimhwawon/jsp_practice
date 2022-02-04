<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<html>
<% if(id.equals("abcd") && pw.equals("1234")) {%>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
</head>
<body>
	<b><%= id %></b>님 환영합니다.
</body>
<%}else{ %>
<head>
<meta charset="UTF-8">
<title>로그인 실패!</title>
</head>
<body>
	<b>로그인에 실패하셨습니다</b><br/>
	<a href="req_login_form.jsp"><b>로그인창으로 돌아가기</b></a>
</body>
<%} %>
</html>




