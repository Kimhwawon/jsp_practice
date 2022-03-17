<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기에 세션아이디랑 글쓴이 아이디를 비교해서 일치하지 않으면 boardList.do로 리다이렉트 시키는 로직을 작성해주세요.  --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<c:if test="${sessionScope.session_id ne board.writer }">
		<% response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList.do");%>
	</c:if>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${board}
	
<form action="http://localhost:8181/MyFirstWeb/boardUpdate.do" method="post">
		<!-- 폼은 디테일 페이지 샹식을 가져오면 됩니다.  -->
			<input type ="hidden" name="board_num" value="${board.board_num }">
			글제목 : <input type="text" name="title" value="${board.title }" >
			글쓴이 : <input type="text" value="${board.writer }" readonly>
			조회수 : ${board.hit }<br/>
			쓴날짜 : <input type="text" value="${board.bDate }" readonly>
			마지막 수정 날짜 : ${board.mDate }<br/>
			본문 : <textarea name="content" rows="15" cols="50">${board.content }</textarea><br/>
	<input type = "submit" value="수정완료"><input type = "reset" value="초기화">
	
	</form>
</body>
</html>