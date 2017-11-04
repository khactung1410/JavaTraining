package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/TheSecondHello2", name="hello-servlet")
public class HelloServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Hello Ha Noi Java Clazz");
		writer.println("Hello " + req.getParameter("user"));
	}
//	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//		PrintWriter writer = resp.getWriter();
//		writer.println("Hello " + req.getParameter("user"));
//	}
}
