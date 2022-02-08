<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session은 폼은 안 쓰고도 다른 페이지로 데이터를 전송해줄 수 있는 하나의 수단입니다. 
	String id = (String)session.getAttribute("session_id");
	String pw = (String)session.getAttribute("session_pw");
	String nickName = (String)session.getAttribute("session_nickname");
	
	// 로그인 안한 
	if(id == null){
		response.sendRedirect("session_login.jsp");
	}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=nickName %> (<%=id %>)님 로그인을 환영합니다. </h1>
<a href = "session_logout.jsp">로그아웃 하기</a>
</body>
</html>