<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 0. 한글 깨지는 문제 해결
	request.setCharacterEncoding("utf-8");

	// 1. form에서 보낸 비번, 이름, 이메일 변수로 저장해주세요.
	String fName = request.getParameter("fname");
	String fPw = request.getParameter("fpw");
	String fEmail = request.getParameter("femail");

	// 2. session에 저장된 아이디를 변수로 저장해주세요. 
	String sId = (String) session.getAttribute("session_id");
	
	/*
	// 3. DB접속정보 변수로 관리
	String dbType = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
	String dbId = "root";
	String dbPw = "mysql";

	
	// 4. 연결
	try {
		Class.forName(dbType);
		
		Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
	
	// 5. pstmt생성 및 ?에 값 세팅
	// 쿼리문 :UPDATE userinfo SET upw=?, uname=?, uemail=? WHERE uid=?
		String sql="UPDATE userinfo SET upw=?, uname=?, uemail=? WHERE uid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
	
		pstmt.setString(1, fPw);// ? 가 네 개입니다.
		pstmt.setString(2, fName);
		pstmt.setString(3, fEmail);
		pstmt.setString(4, sId);
		
		
		// 6. pstmt 실행 및 자원 회수
		pstmt.executeUpdate(); // 조회구문(SELECT)이 아니면 executeUpdate()
	
		con.close();
		pstmt.close();
	
			
	}catch(Exception e) {
		e.printStackTrace();
	} finally {
	}
	*/
	// 위쪽 3~6코드를 DAO로 대체해서 처리해주세요.
	// DAO 생성
	UserDAO dao = new UserDAO();
	// update로직 호출
	dao.updateCheck(sId, fPw, fName, fEmail);// void

	// 7. body태그에 XXX 회원의 정보가 수정되었습니다. 라고 안내해주고
	// 웰컴페이지로 들어갈 수 있는 링크 넣어주기
	
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=sId %>회원의 정보가 수정되었습니다. </h1>
	<a href="login_welcome.jsp"> 웰컴페이지로 돌아가기. </a>
</body>
</html> 

	