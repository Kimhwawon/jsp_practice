<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 폼에서 보낸 아이디 비밀번호를 받아서 변수에 저장해주시고 콘솔에 확인도 해주세요. 
	String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	System.out.println("폼에서 날린 아이디 " + fId);
	System.out.println("폼에서 날린 비밀번호 " + fPw);
	/*
	// DB 연결을 위한 변수선언 
	
	try{
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		
		// 1. DB종류 선택 및 연결
		Class.forName(dbType);
		Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
		// 2. 쿼리문(사용자가 입력해준 fId 조회하기) 선언 및 PreparedStatement 객체 생성
		String sql = "SELECT * FROM userinfo WHERE uid= ?";
		//-> SELECT * FROM userinfo WHERE uid = " javajsp"로 바뀌는 이유는?
				
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,fId);
		
		
		// 3. 쿼리문 실행 결과 ResultSet에 받기
		ResultSet rs = pstmt.executeQuery();
		
		
		*/
		// 1~3번까지의 로직을 DAO getUserData를 사용해 수행하도록 변경해주세요. 
		// (login_update.jsp 에서 UserVO를 받아오는 부분을 참고하세요.)
		// DAO 생성하기
		UserDAO dao = UserDAO.getInstance();
		// UserVO 변수에 getUserData()결과 받기.
		UserVO user = dao.getUserData(fId);
		System.out.println("DB에서 받아온 정보 : " + user);
		 
		// 4. 사용자 입력 id를 기준으로 들어온 데이터가 있다면, (fid.equals(DB내에 저장된 ID)로 검사 가능)
		//		DB에 적재되어있던 비밀번호를 마저 사용자 입력 비밀번호와 비교해 둘 다 일치하면 세션 발급
		//		그렇지 않다면 로그인에 실패했습니다. 메세지가 뜨도록 처리
		
		// 아이디가 없다면 null이 들어옴.
		if(user != null){
			//String uId = rs.getString("uid"); // userinfo 테이블 내부의 아이디
			//String uPw = rs.getString("upw"); //  userinfo 테이블 내부의 비번
			String uId = user.getuId(); // hint * getter
			String uPw = user.getuPw(); 
			System.out.println("DB내 유저 아이디 " + uId);
			System.out.println("DB내 유저 비밀번호 " +  uPw);
			// 폼에서 받아온 아이디와 테이블 내부 아이디, 폼에서 받아온 비밀번호와 테이블 내부 비밀번호 체크 
			if(fId.equals(uId) && fPw.equals(uPw)){
				out.println("<h1>" + fId + "님 로그인에 성공하셨습니다.</h1> ");
				// 로그인인시 세션을 발급해줍니다. 로그인 성공해서 
				session.setAttribute("session_id", uId);
				session.setAttribute("session_pw", uPw);
				// 로그인 성공 후 웰컴페이지로 보내주기
				response.sendRedirect("login_welcome.jsp");
			}else {
			out.println("<h1>비밀번호가 틀렸습니다. 다시 확인해주세요 .</h1>");	
			}
			
		}else{
				out.println("<h1>아이디가 없습니다. 입력 아이디를 확인해주세요.</h1>");	
			}
		// 5. 만약 웰컴페이지도 만들 여력이 되신다면
		// 		가입 이후 리다이렉트로 넘겨서
		// 		이름(아이디) 님 로그인을 환영합니다 라는 문장이 뜨는 login_welcome.jsp까지 구현해주세요. 

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>