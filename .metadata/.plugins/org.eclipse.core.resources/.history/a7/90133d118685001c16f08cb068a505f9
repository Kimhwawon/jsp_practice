<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언부는 아래와같이 스크립트릿에 !를 하나 더 붙여서 작성합니다.
	선언부 내부에 변수나 메서드를 정의해뒀다 사용할 수 있습니다. -->
	<%!
		public int i = 10;
		public String str = "안녕하세요";
		int add(int n1, int n2){
			return n1 + n2;
		}
	%>

	<%
		int result = add(10, 5);
		out.println("10 + 5 = " + result + "<br/>");
		out.println("16 + 14 = " + add(16, 14) + "<br/>");
		out.println(result);
	%>


</body>
</html>