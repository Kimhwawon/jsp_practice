package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardUpdateFormService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strbNum = request.getParameter("board_num");
		int bNum = 0;
		if(strbNum != null) {
			bNum = Integer.parseInt(strbNum);
		}
		
		
		// 수정버튼을 눌렀을때 글제목, 글내용, 글쓴이 등이 기입된 상태로 수정창이 열려야 함
		// 기입된 상태가 되려면 먼저 입력된 글 번호에 해당하는 글 정보를 DB에서 자바로 가져와야 합니다. 
		// 글 번호 입력시 해당 번호 글의 정보를 가져오는 로직은 BoardDAO의 getBoardDetail()에 작성되어 있습니다.
		
		
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardVO가져오기
		BoardVO board= dao.getBoardDetail(bNum);
		System.out.println(board); //디버깅ㅈ
		// 3. 가져온 데이터 바인딩
		request.setAttribute("board", board);
		
	}

}
