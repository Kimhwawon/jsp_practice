package kr.co.ict;

import java.sql.*;
import java.util.Scanner;

public class JDBCSelectQ1 {

	public static void main(String[] args) {
		
	
		// Scanner를 이용해 uid를 입력받은 다음
		// 방금한 SELECT 구문을 응용해서
		// WHERE uid = 입력받은 아이디
		// 형식으로 내가 조회한 아이디의 정보만
		// 콘설에 찍히도록 로직을 작성해주세요. 
		
		// WHERE uid = '아이디명' 이므로
		// 아이디명 앞뒤로 작은따옴표가 들어갈 수 있도록
		// 전달 쿼리문을 신경써서 작성해주세요. 
		// 힌트 : uid='" + 변수명 + "'"
		Scanner scan = new Scanner(System.in);
		System.out.println("조회할 유저의 아이디를 입력해주세요.");
		String uid = scan.next();
		where uid = '" + kkk1234+ "'"
		
	}

}
