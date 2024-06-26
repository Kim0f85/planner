package com.planiverse.event.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planiverse.event.repository.CalDAO;

@WebServlet("/calendar/sharedel.do")
public class CalShareDel extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		int result = 0;
		if (id != null) {
			
			CalDAO dao = new CalDAO();
			
			String temp = req.getParameter("calSeq");
			int calSeq = Integer.parseInt(temp);
			result = dao.delShareCal(id, calSeq);
			
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("{");
		writer.print("\"result\":\"" + result + "\"");
		writer.print("}");
		writer.close();

	}
	
}