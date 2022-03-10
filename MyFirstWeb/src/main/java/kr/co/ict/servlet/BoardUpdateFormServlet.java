package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardUpdateFormServlet
 */
@WebServlet("/boardUpdateForm")
public class BoardUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. boarddetail.jsp에 목저지를 현재 서블릿으로 하고 post방식 전달을 하는 form과 submit버튼 "수정하기"를 만들어주세요. 
		// 2. doPost에서 실제로 수정하기를 눌렀을때 반응이 있는지 체크해주세요. 
		// 3.  해당 글번호에 저장된 정보로 수정페이지를 채워야 하니 글 번호도 같이 넘겨지는지 체크해주세요. 
		String strbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(strbNum);
		
		
		// 수정 버튼을 눌렀을때 글제목, 글내용, 글쓴이 등이 기입된 상태로 수정창이 열려야 함
		// 기입된 상태가 되려면 먼저 입력된 글 번호에 해당하는 글 정보를 DB에서 자바로 가져와야 합니다.
		// 글 번호 입력시 해당 번호 글의 정보를 가져오는 로직은 BoardDAO의 getBoardDerail에 작성되어 있습니다. 
		
		// 1. DAO 생성
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardDAO의 getAllBoardList() 호출해 전체 게시글 정보 받아오
		BoardVO board= dao.getBoardDetail(bNum);
		System.out.println(board);
		// 3. 가져온 데이터 바인딩
		request.setAttribute("board", board);
		// 4. 목적지로 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardUpdateForm.jsp");
		dp.forward(request, response);
	}

}
