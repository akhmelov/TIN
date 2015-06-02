//package com.springapp.mvc.model;
//
//import java.io.File;
//import java.io.IOException;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NamedNodeMap;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//public class WriteXMLFile {
//
//	public static void create(Record r,String fname) {
// 	   if
//	   try {
//		String filepath = r.isMa()?'resources\master.xml':'resources\bachelor.xml';
//		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//		Document doc = docBuilder.parse(filepath);
//
//		//Edit Title
//		Node editNode = doc.getElementsByTagName("titlePL");
//		editNode.setTextContent(r.getTitlePL());
//		editNode = doc.getElementsByTagName("titleEN");
//		editNode.setTextContent(r.getTitleEN());
//		//edit abstract
//		editNode= doc.getElementsByTagName("abstractPL");
//		editNode.setTextContent(r.getAbstractPL());
//		editNode = doc.getElementsByTagName("abstractEN");
//		editNode.setTextContent(r.getAbstractEN());
//		//Edit Keywords
//		editNode= doc.getElementsByTagName("keywordsPL");
//		editNode.setTextContent(r.getKeyWordsPL());
//		editNode = doc.getElementsByTagName("keywordsEN");
//		editNode.setTextContent(r.getKeyWordsEN());
//		editNode = doc.getElementsByTagName("issueDate");
//		editNode.setTextContent(r.getIssueDate()));
//		// fill in author children
//		Node author = doc.getElementsByTagName("author").item(0);
//		NodeList list = author.getChildNodes();
//		for (int i = 0; i < list.getLength(); i++) {
//			Node node = list.item(i);
//			if ("name".equals(node.getNodeName())) {
//				node.setTextContent(r.getNameStudent());
//			}
//			if ("surname".equals(node.getNodeName())) {
//				node.setTextContent(r.getSurnameStudent());
//			}
//			if ("email".equals(node.getNodeName())) {
//				node.setTextContent(r.getMailStudent());
//			}
//		}
//		// fill in promoter children
//		Node promoter = doc.getElementsByTagName("promoter").item(0);
//		list = promoter.getChildNodes();
//		for (int i = 0; i < list.getLength(); i++) {
//			Node node = list.item(i);
//			if ("name".equals(node.getNodeName())) {
//				node.setTextContent(r.getNameStudent());
//			}
//			if ("surname".equals(node.getNodeName())) {
//				node.setTextContent(r.getSurnamePromoter());
//			}
//		}
//
//		// write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//		StreamResult result = new StreamResult(new File(r.isMa()?'resources\Mdownload.xml':'resources\Bdownload.xml'));
//		transformer.transform(source, result);
//
//		System.out.println("Done");
//
//	   } catch (ParserConfigurationException pce) {
//		pce.printStackTrace();
//	   } catch (TransformerException tfe) {
//		tfe.printStackTrace();
//	   } catch (IOException ioe) {
//		ioe.printStackTrace();
//	   } catch (SAXException sae) {
//		sae.printStackTrace();
//	   }
//	}
//}