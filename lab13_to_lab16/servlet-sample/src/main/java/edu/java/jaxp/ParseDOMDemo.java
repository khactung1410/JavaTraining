
package edu.java.jaxp;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseDOMDemo {

   public static void main(String[] args) {

      try {
         File inputFile = new File("book.xml");
         DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList list = doc.getElementsByTagName("book");
         System.out.println("----------------------------");
         
         for (int i = 0; i < list.getLength(); i++) {
            Node nNode = list.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("page : " 
                  + eElement.getAttribute("page"));
               System.out.println("booktitle : " 
                  + eElement
                  .getElementsByTagName("booktitle")
                  .item(0)
                  .getTextContent());
               System.out.println("author : " 
                  + eElement
                  .getElementsByTagName("author")
                  .item(0)
                  .getTextContent());
               System.out.println("price : " 
                  + eElement
                  .getElementsByTagName("price")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}