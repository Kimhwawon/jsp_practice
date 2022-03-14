package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandPatternServelt
 */
@WebServlet("*.test")
public class CommandPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandPatternServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.test 패턴으로 접속 감지됨");
		// .test 앞에 들어오는 문자가 뭔지 감지해야 사용자의 요청을 파악할 수 있음.
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.equals("/MyFirstWeb/main.test")) {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/");
		}else if(uri.equals("/MyFirstWeb/board.test")) {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
		}else if(uri.equals("/MyFirstWeb/login.test")) {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/users/login_form.jsp");
		}else {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/");
	}
}
	//boardlist.test
	//접속시 boardlist로 리다이렉트

	//login.test
//	접속시 loginform. 으로 리다이렉트

//	main.test접속시
	//그냥 메인으로 리다이렉트

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}