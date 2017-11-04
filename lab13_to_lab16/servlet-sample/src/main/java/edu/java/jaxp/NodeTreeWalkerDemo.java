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
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;

public class NodeTreeWalkerDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File("book.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        NodeList elements = doc.getElementsByTagName("book");  
        	DocumentTraversal dt = (DocumentTraversal)doc;
        	TreeWalker walker = dt.createTreeWalker(doc, NodeFilter.SHOW_TEXT, null, true);
            Node n = walker.firstChild();
            while(true) {
            	n=walker.nextNode();
            	if(n == null) {
            		break;
            	}else {
            		System.out.println("Text Value: '" + n.getNodeValue() + "'");
            	}
            }
	}
}
