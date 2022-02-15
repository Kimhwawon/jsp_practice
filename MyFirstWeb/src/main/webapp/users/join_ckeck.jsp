
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// 폼에서 날려준 데이터를 받아서 변수에 저장해주세요.
	String fid = request.getParameter("fid");
	String fpw = request.getParameter("fpw");
	String fname = request.getParameter("fname");
	String femail = request.getParameter("femail");

	
	// 위의 사용자가 입력한 데이터를 토대로
	// 스크립트릿 내부에서 DB연동을 한 다음 INSERT 구문을 실행하도록 만들면 회원가입 절차 구현 가능
	
	String dbType = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
	String dbId = "root";
	String dbPw = "mysql";
	
	try{
	// 1. DB 종류 지정 및 연결
	Class.forName(dbType);
	Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
	
	// 2. 쿼리문 작성 및 pstmt 생성
	String sql = "INSERT INTO userinfo VALUES(?, ?, ?, ?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	// 3. pstmt 실행으로 사용자가 보낸 폼 데이터 DB에 저장
	// ?에 값 세팅하고 쿼리문 실행
			
					// name id pw email
 	pstmt.setString(1, fname);
	pstmt.setString(2, fid);
	pstmt.setString(3, fpw);
	pstmt.setString(4, femail);
	
	pstmt.executeUpdate();
	
	con.close();
	pstmt.close();
	
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
	
	
	// 4. out.println("회원가입이 완료되었습니다. "); 띄워서 가입완료 알리기. 
	out.println("회원가입이 완료되었습니다. ");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<a href="login_form.jsp">로그인창으로 이동하기</a>
</head>
<body>

</body>
</html>