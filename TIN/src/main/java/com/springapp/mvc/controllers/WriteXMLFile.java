package com.springapp.mvc.controllers;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.springapp.mvc.grains.Record;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WriteXMLFile {

	public static String create(Record r){
		try {
			String filename = r.isMA()? "/master.xml" : "/bachelor.xml";
            Resource rsrc = new ClassPathResource(filename);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(rsrc.getFile().getAbsolutePath());

			//Edit Title
			Node editNode = doc.getElementsByTagName("titlePL").item(0);
			editNode.setTextContent(r.getTitlePL());
			editNode = doc.getElementsByTagName("titleEN").item(0);
			editNode.setTextContent(r.getTitleEN());
			//edit abstract
			editNode= doc.getElementsByTagName("abstractPL").item(0);
			editNode.setTextContent(r.getAbstractPL());
			editNode = doc.getElementsByTagName("abstractEN").item(0);
			editNode.setTextContent(r.getAbstractEN());
			//Edit Keywords
			editNode= doc.getElementsByTagName("keywordsPL").item(0);
			editNode.setTextContent(r.getKeyWordsPL());
			editNode = doc.getElementsByTagName("keywordsEN").item(0);
			editNode.setTextContent(r.getKeyWordsEN());
			editNode = doc.getElementsByTagName("issueDate").item(0);
			editNode.setTextContent(r.getIssueDate());
			// fill in author children
			Node author = doc.getElementsByTagName("author").item(0);
			NodeList list = author.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("name".equals(node.getNodeName())) {
					node.setTextContent(r.getNameStudent());
				}
				if ("surname".equals(node.getNodeName())) {
					node.setTextContent(r.getSurnameStudent());
				}
				if ("email".equals(node.getNodeName())) {
					node.setTextContent(r.getMailStudent());
				}
			}
			// fill in promoter children
			Node promoter = doc.getElementsByTagName("supervisor").item(0);
			if(promoter==null)
				return "no supervisor tag found";
			list = promoter.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("name".equals(node.getNodeName())) {
					node.setTextContent(r.getNamePromoter());
				}
				if ("surname".equals(node.getNodeName())) {
					node.setTextContent(r.getSurnamePromoter());
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}

		return "FAILED";}

}
