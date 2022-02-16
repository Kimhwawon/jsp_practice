<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 저장된 정보를 확인해
	// ID님 접속을 환영합니다. 하고 안내해주는 화면을 만들어보겠습니다. 
	// 추후 여기에는 탈퇴하기, 로그아웃, 정보수정하기 버튼이 추가될 예정입니다. 
	String sId = (String)session.getAttribute("session_id");
	// 로그인 안 된 사용자가 여기로 접근하면 로그인페이지로 보내주세요. 
	if (sId == null){
		response.sendRedirect("login_form.jsp");
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=sId%>님 접속을 환영합니다. </h1>
	<a href="login_update.jsp">정보수정하기</a><br/>
	<a href="logout.jsp">로그아웃하기</a><br/> <!-- 세션 파기 후 login_form.jsp로 보내주세요
	login_form.jsp도 만약 로그인한 사용자가 접근하면 welcome페이지로 보내도록 로직을 살짝 수정해주세요.  -->
	<a href="member_out.jsp">회원탈퇴하기</a><br/><!-- 회원 탈퇴를 위해 member_out.jsp를 만들어보겠습니다. -->
	<a href="user_list2.jsp">유저목록보기</a><!--  회원목록보기 링크를 만들어주세요 -->
</body>
</html>