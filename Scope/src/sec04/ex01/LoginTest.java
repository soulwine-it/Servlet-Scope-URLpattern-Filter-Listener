package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginTest extends HttpServlet {
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			//이벤트 핸들러 생성한 후 세션에 저장합니다.
			LoginImpl loginUser=new LoginImpl(user_id, user_pw);
			if(session.isNew()) {
				//세션에 바인딩 시 LoginImpl의 valueBound()메서드를 호출합니다.
				session.setAttribute("loginUser", loginUser);
			}
			
			out.println("<head>");
			out.println("<script type='text/javascript'>");
			//자바스크립트의 setTimeout()함수를 이용해 5초마다 서블릿에 재요청하여 현재 접속자수를 표시합니다.
			out.println("setTimeout('history.go(0);', 5000");
			out.println("</script>");
			out.println("</head>");
			out.println("<html><body>");
			//접속자 수를 브라우저로 출력합니다.
			out.println("아이디는" + loginUser.user_id +"<br>");
			out.println("총 접속자 수는"+ LoginImpl.total_user +"<br>");
			out.println("</body></html>");
		}

}
