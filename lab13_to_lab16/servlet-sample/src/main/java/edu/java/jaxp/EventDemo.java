package edu.java.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.events.EventTarget;
import org.xml.sax.SAXException;

public class EventDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File("book.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        NodeList elements = doc.getElementsByTagName("booktitle");
        EventTarget evTarget = (EventTarget) elements.item(0);
        evTarget.addEventListener("DOMNodeInserted", new EventListener() {
        	private void handle() {
        		System.out.println("insert new element ");//////////////??????????????
			}
        }, false);
        Text text = doc.createTextNode("hehe");
        elements.item(0).appendChild(text);
	}
}
