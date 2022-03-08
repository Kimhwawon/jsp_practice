package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insertBoard")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기본적으로, SELECT를 제외한 쿼리문 호출은 POST로만 접근할 수 있게 합니다.
		
		// 1. DAO 생성
			BoardDAO dao = BoardDAO.getInstance();
			
		// 2. 폼에서 날아올때 사용하는 name은 title, content, writer입니다.
		// 폼에서 날려준 데이터를 자바 데이터로 저장해주세요. 
			request.setCharacterEncoding("utf-8");
			
			String title =  request.getParameter("title");
			String content = request.getParameter("content");
			String writer =  request.getParameter("writer");
		
		// 3. insert로직 호출 (필요 파라미터는 폼에서 날아온다고 가정하고 입력해주세요.)
			dao.insertBoard(title, content, writer); 

		// 4. 다 끝났다면, 리다이렉트 방식으로 서블릿 주소 boardlist로 이동시킵니다. 
		response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
	}

}
