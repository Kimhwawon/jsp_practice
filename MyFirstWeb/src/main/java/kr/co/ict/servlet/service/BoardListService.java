package kr.co.ict.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

// BoardListSErvice는 boardList 젖ㅂ속시 사용하는 로직을 관리합니다. 
public class BoardListService implements IBoardService {
	
		// BoardListServlet에서 바인딩까지 복사해오면 됩니다. 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 접속시 BoardDAO생성
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardDAO의 getAllBoardList() 호출해 전체 게시글 정보 받아오기
		List<BoardVO> boardList = dao.getAllBoardList();
		// 3. request.setAttribute로 바인딩하기
		// List<boardVO> boardList를 바로 바인딩할수도 있습니다. 
		request.setAttribute("boardList", boardList);
		
	}
}