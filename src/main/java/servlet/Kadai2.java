package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Character;

@WebServlet("/Kadai2")
public class Kadai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Kadai2() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Character[] ch = new Character[100];
		Character ch2 = new Character();
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = new Character();
		}
		ch2.setName(ch, "minato", 0);
		ch2.setHp(ch, 10, 0);
		ch2.setMp(ch, 8, 0);
		ch2.setNo(ch, 1, 0);
		
		ch2.setName(ch, "asaka", 1);
		ch2.setHp(ch, 5, 1);
		ch2.setMp(ch, 15, 1);
		ch2.setNo(ch, 2, 1);
		
		//新規登録を行ったデータを取得
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String mp = request.getParameter("mp");
		
		//String型の数値をint型に変換
		int hp1 = Integer.parseInt(hp);
		int mp1 = Integer.parseInt(mp);
		
		//登録されていないNoに登録内容をセット
		if(name != null || hp1 != 0 || mp1 != 0) {
			for(int i = 0; ch2.getName(ch, i) == null; i++) {
				ch2.setNo(ch, i+1, i);
				ch2.setName(ch, name, i);
				ch2.setHp(ch, hp1, i);
				ch2.setMp(ch, mp1, i);
			}
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>宿題2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\" style=\"width:400\">");
		out.println("<table align=\"right\">");
		out.println("<tr bgcolor=\"blue\">");
		out.println("<th><a href=kadai2.jsp class=btn>新規登録</th>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<b>一覧</b>");
		out.println("<table border=\\\"1\\\" style=\\\"width:400\\\">");
		out.println("<tr bgcolor=\"blue\">");
		out.println("<th>No</th><th>名前</th><th>HP</th><th>MP</th>");
		out.println("</tr>");
		
		//登録されている内容をNo1から表示
		for(int i = 0; ch2.getName(ch,i) != null; i++) {
			out.println("<tr>");
			out.println("<th>" + ch2.getNo(ch,i) + "</th><th>" + ch2.getName(ch,i) + "</th><th>"
					+ ch2.getHp(ch, i) + "</th><th>" + ch2.getMp(ch,i) + "</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
	}
}
