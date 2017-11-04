package edu.java.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.ranges.DocumentRange;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.traversal.DocumentTraversal;
import org.xml.sax.SAXException;

public class RangeDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File("book.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        Range range = ((DocumentRange)doc).createRange();
        NodeList authorElements = doc.getElementsByTagName("book");  
        range.setStartBefore(authorElements.item(0));
        range.setEndAfter(authorElements.item(authorElements.getLength()-1));
        System.out.println(" =======> " +range.extractContents().getTextContent());
	}
}
