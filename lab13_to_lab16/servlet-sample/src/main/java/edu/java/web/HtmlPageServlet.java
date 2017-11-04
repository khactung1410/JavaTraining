package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(
		@HttpConstraint(
			transportGuarantee = TransportGuarantee.CONFIDENTIAL,
			rolesAllowed="read"
		)
)
@WebServlet(value="/TheSecondPage", name="html-page")
public class HtmlPageServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		doGet(req,resp);
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html><head><title> Welcome to our website!</title></head>");
		writer.println("<body><h1>Student"
				+ "<br>"
				+ "<table border=\"1px\" cellpadding=\"5\" cellspacing=\"3\">\r\n" + 
				"	<tr bgcolor=\"gray\">\r\n" + 
				"		<th>#</th>\r\n" + 
				"		<th>Name</th>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr bgcolor=\"green\">\r\n" + 
				"		<td>1</td>\r\n" + 
				"		<td>Nguyen Van A</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr bgcolor=\"red\">\r\n" + 
				"		<td>2</td>\r\n" + 
				"		<td>Tran Thi B</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr bgcolor=\"violet\">\r\n" + 
				"		<td>3</td>\r\n" + 
				"		<td>Le Van C</td>\r\n" + 
				"	</tr>\r\n" + 
				"</table>"
				+ "</h1></body>");
		writer.println("</html>");
		
	}
}
