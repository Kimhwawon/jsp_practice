<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 하단에 선언부를 선언해주신 다음, double을 선언하는 areaCircle 메서드를 정의해주세요
	이 메서드는 r 변수에 double타입으로 원주율을 입력받고
	r의 제곱 * Math.PI(원주율) 을 곱해 원 넓이를 리턴합니다. -->
	<%!
		double areaCircle(double r){
			return r * r * Math.PI;
		}
	%>
	
	<!-- scriptlet은 main method처럼 동작합니다. -->
	<%
		String name = "김철수";
		int age = 44;
		/*
		out.println("이름 : " + name + "<br/>");
		out.println("나이 : " + age + "세<br/>");
		out.println(areaCircle(5));
		*/
	%>
	이름 : <%= name %><br/>
	나이 : <%= age %>세<br/>
	반지름 5인 원넓이 : <%= areaCircle(5) %>cm^2
	
	
</body>
</html>