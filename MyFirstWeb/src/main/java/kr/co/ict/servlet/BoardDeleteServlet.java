package kr.co.ict.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(strbNum);
				
				
				// 1. dao 생성
				BoardDAO dao = BoardDAO.getInstance();
				// 2.  삭제로직 실행
				dao.deleteBoard(bNum);
				// 3. 삭제후 boardList로 리다이렉트
				response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
	}

}
