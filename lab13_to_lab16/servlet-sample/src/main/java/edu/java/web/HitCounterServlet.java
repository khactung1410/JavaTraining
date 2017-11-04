package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/count", name="displayHitCount")
public class HitCounterServlet extends HttpServlet{
	private int hitCount;
	public void init() {
		hitCount = 0;
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		hitCount++;
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("HitCount = "+hitCount);
		writer.println("</html>");
	}
}
