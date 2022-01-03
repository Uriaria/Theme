package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kadai5_6")
public class Kadai5_6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String qtype = request.getParameter("qtype");
		String errorMsg = "";
		String msg = "";
		
		if(name == null || name.length() == 0) {
			errorMsg = "名前が入力されていません<br>";
		}
		if(qtype == null || qtype.length() ==0) {
			errorMsg = "お問い合わせ内容が入力されていません<br>";
		}
		else  {
			switch (qtype){
				case "company":
					msg = "スッキリ会社";
					break;
				case "product":
					msg = "スッキリ書籍";
					break;
				case "support":
					msg = "課金してください";
					break;
			}
		}
		if(errorMsg.length() != 0) {
			msg = errorMsg;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>お問い合わせ内容表示</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + name + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
