package edu.java.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class SimpleServletListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("\n\n ServletContextListener destroyed\n\n");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("\n\n ServletContextListener started\n\n");
	}
	
}
