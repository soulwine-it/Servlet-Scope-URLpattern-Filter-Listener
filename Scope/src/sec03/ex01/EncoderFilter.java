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

@WebFilter("/*") //WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 합니다.
public class EncoderFilter implements Filter { // 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 합니다.
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩..........");
		context = fConfig.getServletContext();
	}
	
	// doFilter() 안에서 실제 필터 기능을 구현합니다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8"); //한글 인코딩 설정 작업을 합니다.
		String context = ((HttpServletRequest)request).getContextPath(); // 웹 어플리케이션의 컨텍스트 이름을 가져옵니다.
		String pathinfo = ((HttpServletRequest)request).getRequestURI(); //웹 브라우저에서 요청한 요청 URI를 가져옵니다.
		String realPath = request.getRealPath(pathinfo); // 요청 URI의 실제 경로를 가져옵니다.
		
		String mesg ="Context 정보:" + context +"\n URI정보:" + pathinfo + "\n 물리적 경로: " + realPath;
		System.out.println(mesg);
		chain.doFilter(request, response); //다음 필터로 넘기는 작업을 수행합니다.
	}

	
	public void destroy() {
		System.out.println("destroy 호출");
	}
}
