<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	bmi지수 계산공식 = [체중(Kg) / 신장(m) * 신장(m)]
	즉, 175cm라면 실제 신장에 들어가야 하는 값은 1.75m
	* bmi지수가 23을 초과한다면 "체중조절을 고려해보세요." 출력
	18.5 미만이라면 "당신은 저체중입니다." 출력
	나머지인 경우 "당신은 정상 체중입니다."를 출력하되
	스크립트릿에 if문을 넣어서 선택적으로 결과가 나오게 해 보세요.
	
	* 폼에서 전달되는 데이터는 무조건 문자열로 전달됩니다. 
	따라서 정수나 실수로 변환해야 하는데
	String -> int, double
	Integer.parseInt("문자열") ==> 문자열을 정수로
	Double.parseDouble("문자열") ==> 문자열을 실수로
 --%>
 <%
	String strCm = request.getParameter("height");
	String strKg = request.getParameter("weight");
	
	double cm = Double.parseDouble(strCm);
	double kg = Double.parseDouble(strKg);
	
	//BMI 지수 계산공식 [체중 / 신장(m) * 신장(m)]
	double bmi = kg / (cm/100 * cm/100);
%>   

	<h2>BMI 계산 웹어플리케이션</h2>
	<hr>
	<p>
		- 신장 : <%= strCm %>cm<br/>
		- 체중 : <%= strKg %>kg<br/>
	</p>
	<p>
		BMI 지수 : <b><%= bmi %></b><br/>
		
		<%if(bmi > 23) { %>
		<b>체중조절을 고려해보세요.</b>
		<%}else if(bmi < 18.5) { %>
		<b>당신은 저체중입니다.</b>
		<%}else{ %>
		<b>당신은 정상 체중입니다.</b>
		<%} %>
	</p>

</body>
</html>