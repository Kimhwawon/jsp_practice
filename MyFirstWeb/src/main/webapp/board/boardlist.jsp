<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${boardList }
	<hr/>
	<!-- 출력방법 : 인덱싱이나 c:forEach를 이용해서 하나하나 꺼내준 다음
	.변수명 을 적으면 출력됩니다.   -->
	전체 데이터 : ${boardList[0] }<br/>
	글번호 : ${boardList[0].board_num }<br/>
	글제목 : ${boardList[0].title }
</body>
</html>