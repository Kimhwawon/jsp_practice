package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardDeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(strbNum);
				
				
				// 1. dao 생성
				BoardDAO dao = BoardDAO.getInstance();
				// 2.  삭제로직 실행
				dao.deleteBoard(bNum);
		
	}

}
