<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// # 쿠키 생성 방법.
	// 1. 쿠키 객체를 생성 - 생성자의 매개값으로 추키의
	//    이름과 저장할 데이터를 입력
	Cookie apple = new Cookie("apple_cookie", "사과맛");
	Cookie peanut = new Cookie("peanut_cookie", "땅콩맛");
	
	// 2. 쿠키클래스의 setter 메서드로 쿠키의 속성들을 설정하기.
	apple.setMaxAge(60 * 60); // 60초 * 60 = 1시간
	peanut.setMaxAge(20); // 초단위로 설정 -> 20초
	
	// 3. 사용자에게 http 응답시 response객체에 생성된 쿠키를 탑재하여서
	//    발급까지 마치기
	response.addCookie(apple);
	response.addCookie(peanut);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="cookie_check.jsp">쿠키 확인하러 가기</a>
</body>
</html>