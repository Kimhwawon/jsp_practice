package kr.co.ict;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// DAO 코드 재활용하기.
	// 1. UserDAO에서 주석척리가 안된 부분만
	// getInstance() 메서드까지 가져옴
	
	// 2. ~~~~DAO로 되어있는 부분을 전부 현재 DAO클래스명으로 변경
	// 예) UserDAO -> BoardDAO로 전환중이므로 UserDAO라고 적힌 부분을 전부  BoardDAO로 변경
		private DataSource ds = null;

		private static BoardDAO dao = new BoardDAO();
		
		private BoardDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2. static 키워드를 이용해서 단 한번만 생성하고, 그 이후로는
		// 주소를 공유하는 getInstance() 메서드를 생성합니다. 
		public static BoardDAO getInstance(){
			if(dao == null) {
				dao = new BoardDAO();		
			}
			return dao;
		}

		// 3. 필요로 하는 로직과 유사한 메서드를 복사해옵니다. 
		// 게시판 글 전체 목록 가져오기 -> 회원 전체 목록 가져오기를 이용해수정
		// 회원 전체 목록을 가져오는 getAlluserList를 수정해 getAllBoardList()를 생성해보겠습니다. 
		
		// 3-1. UserVO는 userInfo테이블에 맞춰서 생성된 것이므로
		// boardTBL에 맞춰서 처리하기 위해 UserVO를 사용하는 부분을 전부 BoardVO로 수정해줍니다. 
		
		// 3-2. 쿼리문을 boardtbl 테이블에서 데이터를 가져오도록 수정합다. 
		
		// 3-3 while문 내부에서 Boardtbl 테이블에서 데이터를 가져오도록 수정합니다.
		// 페이징 처리를 위해 페이지 번호를 추가로 입력받습니다. 
		public List<BoardVO> getAllBoardList(int pageNum){

			
			// try 블럭 진입전에 Connection, PreparedStatement, ResultSet 선언
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// 페이징 처리시 페이지당 글 갯수
			final int BOARD_COUNT = 10;
			//try 블럭 진입 전에 ArrayList 선언
			List<BoardVO> boardList = new ArrayList<>();
			
			try {
			// Connection, PreparedStatement, ResultSet을 선언합니다.
				con = ds.getConnection();
				int limitNum = ((pageNum-1) * BOARD_COUNT);
			// SELECT * FROM boardtbl  실행 및  ResultSet에 저장
			// LIMIT 뒤쪽 숫자가 페이지당 보여줄 글 개수이므로  DTO의 상수와 함께 고쳐야 함. 
			String sql = "SELECT * FROM boardtbl ORDER BY board_num DESC limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, BOARD_COUNT);
			
		
			rs = pstmt.executeQuery();
			
			// BoardVO ArrayList에 rs에 든 모든 자료를 저장해주세요.
			while(rs.next()){
				// 7개 컬럼 값을 받아서 변수로 저장받으시고
				 int boardNum = rs.getInt("board_num");
				 String title = rs.getString("title");
				 String content = rs.getString("content");
				 String writer = rs.getString("writer");
				 Date bDate = rs.getDate("bdate");
				 Date mDate = rs.getDate("mdate");
				 int hit = rs.getInt("hit");
				 
				 // int board_num, String title, String content, String writer, Date bDate, Date mDate, int hit
				 BoardVO boardData = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
				 boardList.add(boardData);
			 }
				System.out.println(boardList);
			
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
			return boardList;
		}
		// insertBoard 내부 쿼리문 실행시 필요한 3개 요소인 글제목, 본문, 글쓴이를 입력해야만 실행할수 있게 설계합니다.
				public void insertBoard(String title, String content, String writer) {
					// DB 연결구문을 작성해서 보내주세요.
					// try블럭 진입 전 Connection, PreparedStatement 선언
					Connection con = null;
					PreparedStatement pstmt = null;
					try {
						// Connection, PreparedStatement, ResultSet을 선언합니다.
						con = ds.getConnection();
						
						// INSERT의 경우 두 가지 유형이 있음
						// 전체 컬럼 요소 다 넣기 - INSERT INTO boardTbl VALUES (null, ?, ?, ?, now(), now(), 0)
						// 일부요소만 넣기 - INSERT INTO boardTbl(title, content, writer) VALUES (?, ?, ?)
						String sql = "INSERT INTO boardTbl(title, content, writer) VALUES (?, ?, ?)";
						pstmt = con.prepareStatement(sql);
						// 실행 전 상단 쿼리문 ? 채워넣기
						pstmt.setString(1, title);
						pstmt.setString(2, content);
						pstmt.setString(3, writer);
						// 실행하기
						pstmt.executeUpdate();
					} catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
							con.close();
							pstmt.close();
						} catch(SQLException se) {
							se.printStackTrace();
						}
					}	
				}
					
					
				// 글 한개가 필요한 상황이므로 BoardVO하나면 처리가능
				// SELET * FROM boardTbl WHERE board_num = ?
				public BoardVO getBoardDetail(int board_num) {
					// DB연동 구문을 작성해보세요.
					//try구문 초입에 ds부분 까지만 하셔도 되는 데 만약 다작성 가능하면 다 작성해보세요.
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					BoardVO board = null;
					//upHit(board_num);// 조회수 올리는 로직을 실행한 다음 글정보 불러오게 처리
					try {
						con = ds.getConnection();
							
					String sql = "SELECT * FROM boardTbl WHERE board_num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, board_num);
				
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						int boardNum = rs.getInt("board_num");
						String title = rs.getString("title");
						String content = rs.getString("content");
						String writer = rs.getString("writer");
						Date bDate = rs.getDate("bdate");
						Date mDate = rs.getDate("mdate");
						int hit = rs.getInt("hit");
						
						board = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
						
					}
					
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
					return board;
				}
				// deleteBoard 메서드를 만들어서 삭제처리가 되게 만들어주시고
				// 서블릿에서 해당 메서드를 호출해 실제로 삭제버튼을 누르면 DB에서 해당 번호 글이 삭제되게 해주세요.
				// 비 SELECT 구문이므로 리턴자료형 void
				// DELETE FROM boardTbl WHERE board_num=?
				
				public void deleteBoard(int boardNum) {
					
					Connection con = null;
					PreparedStatement pstmt = null;
					
					try {
						con = ds.getConnection();
						
						String sql = "DELETE FROM boardTbl WHERE board_num=?"; // 탈퇴
						pstmt = con.prepareStatement(sql); // 퀴리문 세팅
						// 실행 전  상단 쿼리문? 채워놓기
						pstmt.setInt(1, boardNum);
	
						// 실행하기
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
						con.close();
						pstmt.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				
				}
					
				}
				
				// update도 select가 아니므로 void리턴 자료형을 가집니다. 
				public void boardUpdate(String title, String content, int bNum) {
					// db연결 구문
					// 진입전 connection,PreparedStatement 선언				
					Connection con = null;
					PreparedStatement pstmt = null;
					try {
						// 선언
						con = ds.getConnection();
						
				String sql = "UPDATE boardTbl SET title=?, content=?, mdate=now() WHERE board_num=?";
				
				pstmt = con.prepareStatement(sql);
				// 실행 전 상단 쿼리문? 채워넣기
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, bNum);

				// 실행하기
				pstmt.executeUpdate();
				
					}catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
						con.close();
						pstmt.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					
			}
					}

				// 서비스가 아닌 getBoardDetail 실행시 자동으로 같이 실행하도록 처리하겠습니다. 
				// 글 제목을 클릭할때마다 조회수를 상승시키는 메서드
				public void upHit(int bId) {
					Connection con = null;
					PreparedStatement pstmt = null;
					try {
						// 선언
						con = ds.getConnection();
					
					// update문에 맞는 접속로직을 작성해주세요 (try~catch,connection, pstmt 생성 등 까지만 해주세요.
					String sql = "UPDATE boardTbl SET hit = (hit +1) WHERE board_num=?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bId);
					

					pstmt.executeUpdate();
					
					}catch(Exception e) {
						e.printStackTrace();
					} finally {
						try {
						con.close();
						pstmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					
			}
					}
						
		// 페이징 처리를 위해 글 전체 개수를 구해오겠습니다. 
		// 하단에 public int getPageNum()을 작성해주세요. 
		// 쿼리문은 SELECT COUNT(*) FROM boardTbl; 입니다. 
		
				public int getPageNum() {
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					int pageNum=0;
					try {
						// 선언
					con = ds.getConnection();
					String sql = "SELECT count(*)FROM boardTbl";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						pageNum = rs.getInt(1);
						}
					
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
					return pageNum;
					 
				}
					
					
				}
				
				
				
				
				
				
				
				
		
	
	

				
				
				



