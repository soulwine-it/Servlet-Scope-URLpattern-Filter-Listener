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

//@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	ServletContext ctx = getServletContext();
	HttpSession sess = request.getSession();
	
	//각 서블릿 API에 바인딩된 속성의 값을 가져 옵니다.
	String ctxMesg = (String)ctx.getAttribute("context");
	String sesMesg = (String)sess.getAttribute("session");
	String reqMesg = (String)request.getAttribute("request");
	
	out.print("context값:" + ctxMesg + "<br>");
	out.print("session값 :" + sesMesg + "<br>");
	out.print("request값 :" + reqMesg + "<br>");
	}
}
