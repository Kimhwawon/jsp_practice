<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 폼을 만들어주세요. 폼의 목적지는 join_check.jsp입니다. 
	userinfo 테이블에 작성된대로 아이디, 비밀번호, 이름, 이메일을 가입요소로 받습니다.
	name속성까지 맞춰주시고, submit버튼까지 함께 작성해주세요.   -->
	<h1>회원 가입 페이지</h1>
	<form action="join_ckeck.jsp" method="post">
	아이디 : <input type ="text" name="fid" placeholder="아이디" required><br/>
	비밀번호 : <input type ="password" name="fpw" placeholder="비밀번호" required><br/> 
	이름 : <input type = "text" name= "fname" placeholder="이름" required><br/>
	이메일 : <input type = "text" name= "femail" placeholder="이메일" required><br/>
	<input type = "submit" value="회원가입" /> <input type = "reset" value="초기화">
	
	</form>
</body>
</html>