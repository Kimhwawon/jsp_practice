package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class JEBCUpdate {

	public static void main(String[] args) {
		// UPDATE구문도 처리해보세요.
		// UPDATE는 id는 변경하지 않습니다. 
		// 어떤 아이디의 pw, name, email을 변경할지 조회하기 위해
		// 먼저 id를 받고, 그 다음
		// pw, name, email을 받아서
		// UPDATE구문에서 조건절에 id를 넣어 타켓을 정하고
		// 나머지 항목만 수정되도록 처리해주세요.
		
		// JDBC 프로그래밍 순서
		// 1. DB종류 인식
		// 2. 연결하기(스키마주소, 아이디, 비밀번호)
		// 3. 쿼리문 발송 준비하기.
		// 4. 쿼리문 발송 전 콘솔에 찍어서 체크하기.
		// 5. 쿼리문 발송 후 변경내역이 DB에 반영되었는지 체크
		
		// 연결시 사용할 자료들 변수로 관리하기 
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		
		try {
			// 4.번에서 활용할 변수들 Scanner로 입력받기
			Scanner scan = new Scanner(System.in);
			// 바꿀 아이디 입력받기
			System.out.println("변경하고 싶은 계정의 아이디를 입력해주세요.");
			String uId = scan.nextLine();
			System.out.println("해당 아이디의 새로운 비밀번호를 입력해주세요.");
			String uPw = scan.nextLine();
			System.out.println("해당 아이디의 새로운 이름을 입력해주세요.");
			String uName = scan.nextLine();
			System.out.println("해당 아이디의 새로운 이메일을 입력해주세요.");
			String uEmail = scan.nextLine();
			
			// 1. 사용 DB 지정하기
			Class.forName(dbType);
			
			// 2. Java와 DB 연동하기
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			// 3. 쿼리문 발송 준비하기
			Statement stmt = con.createStatement();
			
			// 4. 쿼리문 실행 전 콘솔에 찍어보기. 
			System.out.println("UPDATE userinfo SET upw='" + uPw +
												"', uname='" + uName +
												"', uemail='" + uEmail +
												"' WHERE uid='" + uId + "'");
			// UPDATE userinfo SET upw='유저입력비번', uname='유저입력이름', uemail='유저입력이메일'
			//		 	WHERE uid='유저입력아이디';
	
			// 5. 쿼리문 발송 후 변경내역이 DB에 반영되었는지 체크
			stmt.executeUpdate("UPDATE userinfo SET upw='" + uPw +
												"', uname='" + uName +
												"', uemail='" + uEmail +
												"' WHERE uid='" + uId + "'");
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
