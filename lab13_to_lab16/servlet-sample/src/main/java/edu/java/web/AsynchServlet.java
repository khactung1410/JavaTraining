package edu.java.web;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/synch", asyncSupported = true)
public class AsynchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		final AsyncContext ctx = request.startAsync();
		ctx.setTimeout(60*1000);
		ctx.start(new Runnable(){
			@Override
			public void run() {
				Writer writer;
				try {
					writer = ctx.getResponse().getWriter();
					writer.write("Hello Async");
					ctx.complete();	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
