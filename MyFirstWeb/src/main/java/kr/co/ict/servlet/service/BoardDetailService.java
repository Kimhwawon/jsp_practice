package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardDetailService implements IBoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	// BoardDetailServlet에서 바인딩까지 복사
		String sbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(sbNum);
		//System.out.println(bNum);
		
		// dao생성
		BoardDAO dao = BoardDAO.getInstance();
		// 조회수 올리기
		dao.upHit(bNum);	
		// dao에서 해당 글번호에 대한 정보를 가져오고
		BoardVO board = dao.getBoardDetail(bNum);
		// 정qh가 제대로 들어왔는지 디버깅 해보겠습니다.
		//System.out.println(board);
		//데이터 바인딩
		request.setAttribute("board", board);
	}

		
	}


