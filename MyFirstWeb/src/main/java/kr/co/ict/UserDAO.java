package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO클래스는 DB연동을 전담하여 처리합니다.
public class UserDAO {

	//DB접속에 필요한 변수들을 아래에 선언합니다.
	private String dbType = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1";
	private String dbId = "root";
	private String dbPw = "mysql";

	// 생성자를 이용해 생성할 때 자동으로 Class.forName()을 실행하게 만듭니다.
	// 어떤 구문을 실행하더라도 동통적으로 활용하는 부분
	public UserDAO() {
		try {
			Class.forName(dbType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// user_list2.jsp의 코드 로직을 대체해보겠습니다.
	// user_list2.jsp에서 전체 유저 목록을 필요로 하기 때문에
	// 실행 결과로 <List(UserVO>를 리턴해줘야합니다.
	// 역시 SELECT구문을 실행할때에는 리턴 자료가 필요하고
	// INSERT, DELETE, UPDATE구문을 실행할때는 리턴자료가 void입니다.
	public List<UserVO> getAllUserList(){

		// try 블럭 진입전에 Connection, PreparedStatement, ResultSet 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//try 블럭 진입 전에 ArrayList 선언
		List<UserVO> userList = new ArrayList<>();
		
		try {
		// Connection, PreparedStatement, ResultSet을 선언합니다.
		con = DriverManager.getConnection(dbUrl, dbId, dbPw);
				
		// SELECT * FROM userinfo  실행 및  ResultSet에 저장
		String sql = "SELECT * FROM userinfo";
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		// UserVO ArrayList에 rs에 든 모든 자료를 저장해주세요.
		while(rs.next()){
			 // 1. ResultSet에서 데이터가져오기
			 String uName = rs.getString("uname");
			 String uId = rs.getString("uid");
			 String uPw = rs.getString("upw");
			 String uEmail = rs.getString("uemail");
			 UserVO userData = new UserVO(uName, uId, uPw, uEmail);
			 userList.add(userData);
		 }
			System.out.println(userList);
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
		return userList;
	}



	 // login_update.jsp의 경우 로그인한 유저 한 명의 데이터만 DB에서 얻어옵니다.
	 // 따라서, 그 한 명의 유저 데이터만을 이용해 SElECT구문을 써야합니다. 
	 // login_updaye.jsp상단의 sId 변수에 들어있는 유저명을 이용해 유저데이터를 얻어옵니다.
	
		public UserVO getUserData(String sId) {
		 // 접속로직은 getAllUserList()와 큰 차이가 없고 쿼리문만 좀 다릅니다. 

		 // 1. Connection, PreparedStatement, ResultSet 변수 선언만 해주세요.
		 // UserVO변수 선언
		 // try블럭 외부에서 써야하는(Connection, PreparedStatement, ResultSet은 finally블럭에서도 사용)
		 // (UserVO는 return구문에서 사용)것들은  try진입 전에 먼저 선언합니다. 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 UserVO user = null;
		 // 2. try블럭 내부에서 DB연결을 해주세요. 필요한 URL, ID, PW는 상단에 멤버변수로 이미 존재합니다.
		 try {
			 con = DriverManager.getConnection(dbUrl, dbId, dbPw);
			 
		 // 3.  쿼리문을 날려서 rs에 DB에서 가져온 정보를 받아주세요.
		 // 쿼리문 : SELECT * FROM userinfo WHERE uid=?
			 String sql = "SELECT * FROM userinfo WHERE uid=?";
			 
			pstmt = con.prepareStatement(sql); // 퀴리문 세팅
			pstmt.setString(1,  sId); // ?부분 채우기
			
			rs = pstmt.executeQuery(); // DB에 쿼리문 날리고 자료 받아오기
		 
		 // 4. UserVO 변수를 선언해주시고, rs에 저장된 데이터를 UserVO에 담습니다.
			if(rs.next()) {
				
				String uName = rs.getString("uname");
				String uId = rs.getString("uid");
				String uPw = rs.getString("upw");
				String uEmail = rs.getString("uemail");
				user = new UserVO(uName, uId, uPw, uEmail);
			}
			
		 // 5. catch, finally 블럭을 작성해주시고 finally에서 자원회수까지 마쳐주세요.
		 }catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// .close()는 무조건 try블럭에 이써야 하기 때문에 finally에서 추가로 try블럭 설정
					con.close();
					pstmt.close();
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			
			}
		 
		 
		 return user; // DB에서 UserVO에 데이터를 받아주신 다음 null대신 받아온 데이터를 리턴하세요. 
	 }
	
}






