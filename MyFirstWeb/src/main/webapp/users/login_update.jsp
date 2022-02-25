<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 세션에서 아이디를 얻어와 변수에 저장합니다. 세션결과값이 널이면 login_form.jsp로 이동
	String sId=(String)session.getAttribute("session_id");
	if(sId == null){
	// 로그인 안 한 사람이 해당 주소를 얻어서 접속한 경우
		response.sendRedirect("login_form.jsp");
	}
	/*
	// 2. DB 연결
	String dbType = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
	String dbId = "root";
	String dbPw = "mysql";
	// 상위지역에서 미리 tName,tEmail을 선언 및 초기화해놔야
	// 표현식에서 저장된 값을 활용할 수 있다. 
	String tName = "";
	String tEmail= null;
	
	try {
		// 3. 로그인된 아이디의 전체 정보(SELECT * FROM...)를 얻어옵니다. 
		Class.forName(dbType);
		Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
		String sql = "SELECT * FROM userinfo WHERE uid=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,  sId);
		
		ResultSet rs = pstmt.executeQuery();
	// 4. ResultSet에서 얻어온 정보 중 name, email을 변수에 저장합니다.
	// 혹시나 데이터가 안들어왔을 상황을 대비해 rs.next()는 if문의 조건절에 넣어서
	// 실행하는것이 좋습니다. 
		if(rs.next()) {
		tName =	rs.getString("uname");
		tEmail = rs.getString("uemail");
		}
	// 접속끊기
	con.close();
	pstmt.close();
	
	// 5. 하단 form의 value에 해당 변수에 든 값이 들어가도록 설정합니다. 
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		
	}
	*/
	// DAO를 활용한 로직으로 전환
	// 1. DAO 생성
	UserDAO dao = UserDAO.getInstance();
	// 2. DAO내부에서 회원 1명의 정보만 가져오는 getUserData 호출
	UserVO user = dao.getUserData(sId); // sId는 이미 세션에서 얻어왔습니다. 
	// 3. 얻어온 user내용물 확인
	out.println(user + "<br/>"); // UserVO에서 toString메서드가 있어서 내용물이 출력됨.
	// 4. user 내용물을 아래쪽 표현식에 getter로 집어넣어주기
	
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- update의 경우는 update_check.jsp 로 자료를 보내야 하는데
	보통 정보 수정을 한느 경우는, 미리 회원정보가 form 기입되어 있는 경우가 많습니다. 
	먼저 폼 양식은, 아이디 없이 비밀번호는 비어있고, name, email은 DB에 있던 정보가
	채워진 상태로 창이 열리게 만들겠습니다. 폼만 완성시켜 보내주세요. 
	input 태그에서 value 속성을 이용하면 미리 채워질 값을 지정할 수 있습니다.  -->
	<h1><%=sId %>계정의 정보를 수정합니다 !</h1>
	<form action="update_check.jsp" method="post">
	<input type="password" name="fpw" placeholder="비밀번호"/><br/>
	<input type="text" name="fname" placeholder="이름" value="<%= user.getuName() %>" required/><br/>
	<input type="email" name="femail" placeholder="이메일" value="<%= user.getuEmail() %>" required/><br/>
	<input type="submit" value="수정하기"><br/>
	<input type="reset" value="초기화">
	</form>
</body>
</html>