<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	- 세션은 쿠키와 마찬가지로 http통신 데이터를 우지하기 위한 수단으로 사용합니다. 
	
	- 세션에 데이터를 저장할 때는 JSP 내장객체 session이 지원하는 setAttribute()메서드를 사용합니다. 
	
	- 해당 메서드의 첫 번째 매개값으로 세션의 이름을 정해주고,
	  두 번째 매개값으로 세션에 저장할 데이터를 정해줍니다. 
	*/
	session.setAttribute("id_session", "abc1234");
	session.setAttribute("name_session", "김말이");
	session.setAttribute("JSP", "SPRING_FRAMEWORK");
	// 세션 시간 1시간으로 설정
	session.setMaxInactiveInterval(3600);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="session_check.jsp">세션 확인하기</a>
</body>
</html>