package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCpstmtDelete {

	public static void main(String[] args) {
		// DELETE 구문을 실행하는 코드를 작성해보세요.
		// 삭제의 기준은 uid가 일치하는 자료를 삭제합니다. 
		
		// 작성순서
		// 1. 스캐너로 삭제할 회원 uid 입력받기
		// 2. DB와 자바 연결
		// 3. 쿼리문에 ?를 포함해 작성한 후  preparedStatement 객체 생성
		// 4. 실행
		// * 접속 정보는 변수로 관리해주세요. 
		
		
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";

		try {
			// 1. 스캐너로 삭제할 회원uid 입력받기
			Scanner scan = new Scanner(System.in);
			System.out.println("삭제할 회원의 ID를 입력하세요. ");
			String uId = scan.nextLine();
			// 2. DB와 자바 연결
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPw);
			// 3. 쿼리문에 ? 를 포함해 작성한 후 PreparedStatement 객체생성
			String sql = "DELETE FROM userinfo WHERE uid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?에 넣어줄 자료 세팅
			pstmt.setString(1, uId);
			// 4.  실행
			pstmt.executeUpdate();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	}


