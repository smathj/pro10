package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("init 메서드 호출");
		System.out.println("utf-8로 인코딩합니다");
		context = fConfig.getServletContext(); // 서블릿 컨텍스트 객체를 받는다

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		System.out.println("doFilter 메서드 호출");
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context  정보:" + context 
					+ "\n URI 정보 : " + pathinfo 
					+ "\n 물리적 경로:  " + realPath;
		
		
		System.out.println(mesg);

		long begin = System.currentTimeMillis();
		
		chain.doFilter(request, response);	// 다음 필터에게 request,response를 넘긴다
		
		long end = System.currentTimeMillis();
		System.out.println("작업 시간:" + (end - begin) + "ms");

	}

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
