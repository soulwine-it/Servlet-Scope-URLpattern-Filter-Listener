package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.println("<html><head>><title>Test Servlet1</title></head>");
		out.println("<body bgcolor='green'>");
		out.println("<b>TestServlet2입니다.</b><br>");
		out.println("<b>컨텍스트 이름 :" + context + "</b><br>");
		out.println("<b>전체 경로:"+ url +"</b><br>");
		out.println("<b>매핑 이름 : " + mapping+ "</b><br>");
		out.println("<b>URI : " + uri + "<b>");
		out.println("</body></html>");
		out.close();
		
	}
}