package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. BoardDAO에 updateBoard()메서드를 생성해주세요. 
		
		// 2. 1의 메서드에 들어갈 쿼리문은 아래와같습니다.
		// UPDATE FROM boardTbl SET title=?, content=? WHERE board_num=?
		// 해당 쿼리문을 이용해서 1의 updateBoard() 의 메서드가 받아야 하는 파라미터를 설정해주세요.
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String strbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(strbNum);
		
		// 3. 현재 doPost내부에서는 먼저 boardUpdate.jsp에서 form으로 전달된 데이터를 받아 변수로 저장합니다.
		request.setAttribute("title", title);
		request.setAttribute("writer", writer);
		request.setAttribute("board_num", strbNum);
		// 4.  저장한 변수를 이용해 updateBoard() 메서드를 호출해줍니다. 

		// 5. boarddetail?board_num=글번호 로 리다이렉트 해서 수정이 완료되면 수정글을 확인할수 있게 만들어줍니다. 


		
	}

}
