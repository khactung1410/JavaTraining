package edu.java.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Article {
	private String href;
	private String title;
	
	
	
	public String getHref() {
		return href;
	}



	public void setHref(String href) {
		this.href = href;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(title).append("-").append(href);
		return builder.toString();
	}
}
