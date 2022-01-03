package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Kadai6_4")
public class Kadai6_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = (int) (Math.random() * 10);
		if(index % 2 == 0) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/forwarded.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("/example/redirected.jsp");
		}
	}
}
