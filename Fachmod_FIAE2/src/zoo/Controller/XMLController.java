package zoo.Controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import zoo.Model.Ticket;
import zoo.Model.Ticketsystem;

public class XMLController {
	
	private Ticket ticket;
	private String dateiPfad = "res/xml/TicketList.xml";
	File fileExists = new File(dateiPfad);
	private Ticketsystem ticketsystem;
	
	public XMLController (Ticketsystem ticketsystem) {
		this.ticketsystem = ticketsystem;
	}
	
	public void xmlRead() {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(dateiPfad);
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
	
	public void xmlWrite(int dauer) {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
	    
	    try {
	        // Dokument erstellen
	        builder = factory.newDocumentBuilder();
	        Document document;
	        Element rootElement;
	        
	        // Überprüfen ob bereits eine XML-Datei besteht
	        if (fileExists.exists()) {
	        	document = builder.parse(fileExists);
				rootElement = document.getDocumentElement();
			} else {
				
				document = builder.newDocument();
		        // Erstellen des Root-Elements
		        rootElement = document.createElement("Tickets");
		        
		        // Anhängen der einzelnen Tickets 
		        document.appendChild(rootElement);
			}

	        
	        // Zugriff auf das zuletzt erstellte Ticket im Ticketsystem
	        ticket = ticketsystem.getNewTicket();
	        
	        // Erstellen des Ticket-Elements
	        Element ticketElement = document.createElement("Ticket");
	        
	        // Erstellen und Hinzufügen des TicketID-Elements
	        Element ticketIDElement = document.createElement("TicketID");
	        ticketIDElement.appendChild(document.createTextNode(String.valueOf(ticket.getTicketID())));
	        ticketElement.appendChild(ticketIDElement);
	        
	        // Erstellen und Hinzufügen des Type-Elements
	        Element typeElement = document.createElement("Type");
	        typeElement.appendChild(document.createTextNode(ticket.getType()));
	        ticketElement.appendChild(typeElement);
	        
	        // Erstellen und Hinzufügen des Price-Elements
	        Element priceElement = document.createElement("Price");
	        priceElement.appendChild(document.createTextNode(String.valueOf(ticket.getPrice())));
	        ticketElement.appendChild(priceElement);
	        
	        // Erstellen und Hinzufügen des Date-Elements
	        Element dateElement = document.createElement("Date");
	        dateElement.appendChild(document.createTextNode(String.valueOf(ticket.getDate())));
	        ticketElement.appendChild(dateElement);
	        
	        // Erstellen und Hinzufügen des Dauer-Elements
	        Element dauerElement = document.createElement("Dauer");
	        dauerElement.appendChild(document.createTextNode(String.valueOf(dauer)));
	        ticketElement.appendChild(dateElement);
	        
	        
	        // Hinzufügen des Ticket-Elements zum Root-Element
	        rootElement.appendChild(ticketElement);

	        // Dokument in XML transfomieren und speichern
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File("res/xml/formatierung.xslt")));
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(dateiPfad);
	        transformer.transform(source, result);
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (TransformerException e) {
	        e.printStackTrace();
	    } catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
