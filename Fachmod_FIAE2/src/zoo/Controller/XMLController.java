package zoo.Controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private int zahlx;
	
	public XMLController (Ticketsystem ticketsystem) {
		this.ticketsystem = ticketsystem;
	}
	
	public String[][] xmlRead() {
		
		List <String[]> dataTemp = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(dateiPfad);
			document.normalize();
			
			NodeList nodeList = document.getElementsByTagName("Ticket");
						
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				String ticketID = element.getElementsByTagName("TicketID").item(0).getTextContent();
				String type = element.getElementsByTagName("Type").item(0).getTextContent();
				String dauer = element.getElementsByTagName("Dauer").item(0).getTextContent();
				String date = element.getElementsByTagName("Date").item(0).getTextContent();
				String price = element.getElementsByTagName("Price").item(0).getTextContent();
				
				String[] ticketData = {ticketID, type, dauer, date, price};
				dataTemp.add(ticketData);
			}
		
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
		
		String[][] data = new String[dataTemp.size()][];
		
		dataTemp.toArray(data);
		
		return data;
		
	
	}
	
	public int xmlReadTicketID() {
		int ticketID = 0;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
				try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				if (fileExists.exists()) {
				Document document = builder.parse(dateiPfad);
				document.normalize();
				
				NodeList nodeList = document.getElementsByTagName("Ticket");
				int i = nodeList.getLength()-1;
				Node node = nodeList.item(i);
				Element element = (Element) node;
				String ticketIDString = element.getElementsByTagName("TicketID").item(0).getTextContent();
				ticketID = Integer.valueOf(ticketIDString);
				ticketID = ticketID+1;
				
				} else {
				ticketID = 1;	
				}
				
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
				
		return ticketID;
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
	        ticket.setTicketID(xmlReadTicketID());
	        ticketIDElement.appendChild(document.createTextNode(String.valueOf(ticket.getTicketID())));
	        ticketElement.appendChild(ticketIDElement);
	        
	        // Erstellen und Hinzufügen des Type-Elements
	        Element typeElement = document.createElement("Type");
	        typeElement.appendChild(document.createTextNode(ticket.getType()));
	        ticketElement.appendChild(typeElement);
	        
	        // Erstellen und Hinzufügen des Dauer-Elements
	        Element dauerElement = document.createElement("Dauer");
	        dauerElement.appendChild(document.createTextNode(String.valueOf(dauer)));
	        ticketElement.appendChild(dauerElement);
             
	        // Erstellen und Hinzufügen des Date-Elements
	        Element dateElement = document.createElement("Date");
       
	        // Datum formatieren
	        String pattern = "dd.MM.yyyy";
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        String date = simpleDateFormat.format(ticket.getDate());
	        dateElement.appendChild(document.createTextNode(date));
	        ticketElement.appendChild(dateElement);
	        
	        // Erstellen und Hinzufügen des Price-Elements
	        Element priceElement = document.createElement("Price");
	        priceElement.appendChild(document.createTextNode(String.valueOf(ticket.getPrice())));
	        ticketElement.appendChild(priceElement);
	        
	        
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
