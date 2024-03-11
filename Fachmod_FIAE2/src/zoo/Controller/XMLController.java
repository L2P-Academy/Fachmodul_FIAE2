package zoo.Controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import zoo.Model.Ticket;

public class XMLController {
	
	private Ticket ticket;
	private String datei = "/data/TicketList.xml";
	
	
	public void xmlRead() {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(datei);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//TODO: Nodes einlesen
	}
	
	public void xmlWrite() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		// ticket = new Ticket();
		try {
			// Dokument erstellen
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			//TODO: Logic um Nodes zu schreiben
			//Erstellen des Root-Elements
			Element rootElement = document.createElement("Tickets");
			
			//Anhängen der einzelnen Tickets 
			document.appendChild(rootElement);
			Element ticketElement = document.createElement("Ticket");
			
			Element ticketIDElement = document.createElement("TicketID");
			
			ticketIDElement.appendChild(document.createTextNode(String.valueOf(ticket.getTicketID())));
			ticketElement.appendChild(ticketIDElement);
			
			Element typeElement = document.createElement("Type");
			typeElement.appendChild(document.createTextNode(ticket.getType()));
			ticketElement.appendChild(typeElement);
						
			Element priceElement = document.createElement("Price");
			priceElement.appendChild(document.createTextNode(String.valueOf(ticket.getPrice())));
			ticketElement.appendChild(priceElement);
			
			Element dateElement = document.createElement("Date");
			dateElement.appendChild(document.createTextNode(String.valueOf(ticket.getDate())));
			ticketElement.appendChild(dateElement);
			
			rootElement.appendChild(ticketElement);
			
			
			
			
			// Dokument in XML transfomieren und speichern
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(datei);
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
		
	
		
	}

}
