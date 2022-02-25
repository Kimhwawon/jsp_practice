<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 목적지가 "el_obj_ok.jsp"인 폼을 만들어주세요
	이름과 별명을 넘겨주면 됩니다. 
	제출버튼을 눌러 넘어가게 해주세요.  -->
	<form action = "el_obj_ok.jsp" method = "post">
	이름 : <input type = "text" name = "name"> <br/>
	별명 : <input type = "text" name = "nick"><br/>
	<input type = submit value = "제출"><br/>
	
	
	</form>
	<!-- del_obj_ok.jsp에는 폼에서 보낸 데이터를 받아서 
	body태그 내에 표현식< %= % >을 이용해
	el_obj.jsp에서 보낸 자료를 표출해주세요-->
	
</body>
</html>