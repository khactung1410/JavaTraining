package edu.java.jaxp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RSSParser {
	private static List<Article> extract(Document doc) {
		List articles = new ArrayList();
		NodeList channels = doc.getElementsByTagName("channel");
		for(int i=0;i<channels.getLength();i++) {
			Node chapter = channels.item(i);
			NodeList items = ((Document) chapter).getElementsByTagName("item");
			IntStream.range(0, items.getLength()).forEach(idx->{
				articles.add(createItemCode(items.item(idx)));
//				System.out.println(items.item(idx).getTextContent());
			});
		}
		return articles;
	}
	private static Article createItemCode(Node item) {
		Article article = new Article();
		for(int i=0;i<item.getChildNodes().getLength(); i++) {
			Node node = item.getChildNodes().item(i);
			switch(node.getNodeName()) {
			case "title":
				article.setTitle(node.getTextContent());
				break;
			case "link":
				article.setHref(node.getTextContent());
				break;
			}
		}
		return article;
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
		Document doc = dBuilder.parse("https://vnexpress.net/rss/kinh-doanh.rss");
		List articles = extract(doc);
		articles.forEach(e -> System.out.println(e));
	}
}
