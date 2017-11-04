package edu.java.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/redirect", name="redirect-servlet")
public class PageRedirect extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		String site = new String("http://www.vnexpress.net");
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location",site);
	}
}
