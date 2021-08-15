package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttribute
 */
@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");	// 브라우저에게 컨텐츠타입 알림
		PrintWriter out = response.getWriter();				// 출력 스트림
		
		String ctxMesg = "context에 바인딩됩니다.";
		String sesMesg = "session에 바인딩됩니다.";
		String reqMesg = "request에 바인딩됩니다.";

		ServletContext ctx = getServletContext();			//ServletContext 객체 얻기
		HttpSession session = request.getSession();			//Session 객체 얻기
		
		
		ctx.setAttribute("context", ctxMesg);				// 애플리 케이션 스코프
		session.setAttribute("session", sesMesg);			// 세션 스코프
		request.setAttribute("request", reqMesg);			// 리퀘스트 스코프
		
		
		out.print("바인딩을 수행합니다.");

	}

}
