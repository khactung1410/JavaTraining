package edu.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value ="/j_security_check")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("j_username");
		String password = "123456";
		try {
		request.login(username, password);
		RequestDispatcher dispatcher  = request.getRequestDispatcher("hello.jsp");
		request.setAttribute("say", "Hi Ha Noi");
		dispatcher.forward(request, response);
		response.getWriter().write("login successful");
		}catch(Exception ex){
			response.getWriter().write("Sorry! Login failed!");
			ex.printStackTrace(response.getWriter());
		}
	}
}
