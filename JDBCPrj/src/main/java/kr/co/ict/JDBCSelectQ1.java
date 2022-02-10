package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCSelectQ1 {

	public static void main(String[] args) {
		// Scanner를 이용해 uid를 입력받은 다음
		// 방금한 SELECT 구문을 응용해서
		// WHERE uid = 입력받은 아이디
		// 형식으로 내가 조회한 아이디의 정보만
		// 콘솔에 찍히도록 로직을 작성해주세요.
		
		// WHERE uid = '아이디명' 이므로
		// 아이디명 앞뒤로 작은따옴표가 들어갈 수 있도록
		// 전달 쿼리문을 신경써서 작성해주세요.
		// 힌트 : uid='" + 변수명 + "'"

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("조회할 유저의 아이디를 입력해주세요.");
			String uId = scan.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1",//접속url
														"root",//mysql 아이디
														"mysql");//mysql 비밀번호
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo WHERE uid='" + uId + "'");


			// while문을 이용해서 select구문의 전체 결과를 
			// 콘솔에 찍어주세요.
			// 1, 4번 컬럼은 컬럼명으로 출력, 2, 3번컬럼은 인덱스로 출력
			if(rs.next()) {	
			System.out.println(rs.getString("uname"));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString("uemail"));
			System.out.println("--------------------");
			
			}
		
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
		
	
