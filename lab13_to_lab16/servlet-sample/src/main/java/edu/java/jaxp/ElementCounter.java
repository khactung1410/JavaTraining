package edu.java.jaxp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.Attributes;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class ElementCounter extends DefaultHandler{
	boolean booktitle = false;
	boolean author = false;
	boolean price = false;
	private int counter =0;
	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {
//		System.out.println("start element--------" + qName);
		if (qName.equalsIgnoreCase("book")) {
	         String page = attributes.getValue("page");
	         System.out.println("page : " + page);
	      } else if (qName.equalsIgnoreCase("booktitle")) {
	         booktitle = true;
	      } else if (qName.equalsIgnoreCase("author")) {
	         author = true;
	      } else if (qName.equalsIgnoreCase("price")) {
	         price = true;
	      }
		if("book".equals(qName)) counter ++;
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Found "+counter+" book elements int the document!");
	}
//	@Override
//	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("end element---"+qName);
//	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (booktitle) {
	         System.out.println("book title: " 
	            + new String(ch, start, length));
	         booktitle = false;
	      } else if (author) {
	         System.out.println("author: " + new String(ch, start, length));
	         author = false;
	      } else if (price) {
	         System.out.println("price: " + new String(ch, start, length));
	         price = false;
	      }
	}
	public static void main(String[] args) throws SAXException, IOException {
		XMLReader parser = XMLReaderFactory.createXMLReader();
		ElementCounter handler = new ElementCounter();
		parser.setContentHandler(handler);
		InputStream stream = ElementCounter.class.getResource("book.xml").openStream();
		parser.parse(new InputSource(stream));
		
		System.out.println("done");
	}
}
