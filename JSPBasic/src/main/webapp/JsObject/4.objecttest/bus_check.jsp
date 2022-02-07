<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strAge = request.getParameter("age");
	int Age = Integer.parseInt(strAge);
	
	if (Age < 19){
		response.sendRedirect("bus_junior.jsp");
	} else if (Age < 60){
		response.sendRedirect("bus_adult.jsp");
	} else{
		response.sendRedirect("bus_senior.jsp");
	}
	
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