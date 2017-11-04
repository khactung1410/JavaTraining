package edu.java.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet {
	Connection connection ;
	Statement statement;
	
	public void init(ServletConfig config) throws ServletException, ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connection = DriverManager.getConnection("jdbc:derby:C:/Temp/userdb;create = true");
        statement = connection.createStatement();
        
        DatabaseMetaData dmd = connection.getMetaData();
        ResultSet rs = dmd.getTables(null, null, null, new String[] {"TABLE"});
        
        if(rs.next() && "hanoi_user" == rs.getString("TABLE_NAME")) return;
        statement.execute("create table hanoi_user(username varchar(500),password varchar(500), email varchar(1000)");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sql = "insert into hanoi_user"
				+ "(username,password,email) values"
				+ "('"+user+"','"+password+"','"+email+"')";
		try {
			statement.execute(sql);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view-user.jsp");
			dispatcher.forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace(response.getWriter());
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		if("del" == request.getParameter("action")) {
			String sql = "delete from hanoi_user where username=\'" + request.getParameter("user") +"\'";
			statement.execute(sql);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view-user.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void destroy() throws SQLException {
		connection = DriverManager.getConnection("jdbc:derby:C:/Temp/userdb;shutdown = true");
		
	}
}
