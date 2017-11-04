package edu.java.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns= {"/html"})
public class GzipFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("\n Destroy doFilter! \n");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		writer.println("======================== \n Filter intercepted! \n=================");
		writer.flush();
		
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("\n Destroy filter! \n");
	}
	
}
