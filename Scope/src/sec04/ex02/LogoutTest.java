package sec04.ex02;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	ServletContext context;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//user_list에서 삭제할 ID를 가져옵니
		String user_id = request.getParameter("user_id");
		// 로그아웃 시 세션을 소멸시킵니다.
		session.invalidate();
		//user_list에서 로그아웃한 접속자 ID를 삭제한 후 다시 user_list를 컨텍스트에 저장합니다.
		ArrayList user_list = (ArrayList) context.getAttribute("user_list");
		user_list.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list);
		out.println("<br>로그아웃했습니다.");
	}
	
}
