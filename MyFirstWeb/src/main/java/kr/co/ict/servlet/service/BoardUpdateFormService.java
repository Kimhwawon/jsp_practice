package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardUpdateFormService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(strbNum);
		
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardVO가져오기
		BoardVO board= dao.getBoardDetail(bNum);
		System.out.println(board); //디버깅ㅈ
		// 3. 가져온 데이터 바인딩
		request.setAttribute("board", board);
		
	}

}
