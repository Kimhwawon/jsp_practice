package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardUpdateService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbNum = request.getParameter("board_num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bNum = Integer.parseInt(sbNum);
		
		// 4. 저장한 변수를 이용해 updateBoard() 메서드를 호출해 줍니다.
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardUpdate(title, content, bNum);
		
	}

}
