package edu.java.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class NodeIteratorDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File("book.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        NodeList elements = doc.getElementsByTagName("book");  
        for(int i=0 ;i<elements.getLength();i++) {
        	DocumentTraversal dt = (DocumentTraversal)doc;
        	NodeIterator iterator = dt.createNodeIterator(elements.item(i), NodeFilter.SHOW_TEXT, null, true);
            Node n = null;
            while((n=iterator.nextNode()) != null) {
            	if(n.getNodeType() == Node.ELEMENT_NODE) {
            		System.out.println("Element Name: '" + n.getNodeName() + "'");
            	}else if(n.getNodeType() == Node.TEXT_NODE) {
            		System.out.println("Text Value: '" + n.getNodeValue() + "'");
            	}
            }
        }
        
	}
}
