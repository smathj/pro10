package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
/* @WebServlet("/first/*") */
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 다음은 디버깅으로 충분히 확인하자
		String context = request.getContextPath();			// 컨텍스트 이름만 가져온다!, 			/pro10
		String url = request.getRequestURL().toString();	// 전체 URL을 가져온다!				http://localhost:8080/pro10/first/test
		String mapping = request.getServletPath();			// 서블릿 매핑 이름만 가져온다!		/first/test
		String uri = request.getRequestURI();				// URI를 가져온다					/pro10/first/test
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet2</title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("<b>TestServlet2입니다.</b><br>");
		out.println("<b>컨텍스트 이름 : "+ context + "</b><br>");
		out.println("<b>전체 경로 : "+ url +"<b><br>");
		out.println("<b>매핑 이름 : "+mapping+"<b><br>");
		out.println("<b>URI : " + uri + "<b>");	
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
