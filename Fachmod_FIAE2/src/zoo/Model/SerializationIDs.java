package zoo.Model;

import java.io.Serializable;

public class SerializationIDs implements Serializable{
	
	/**
	 * Serialization IDs für die benötigten Klassen hier einfügen
	 */
	
	private static final long serialVersionUID = 1L;
	public static final long ZOO_VIEW_UID = 2L;
	public static final long ANIMAL_VIEW_UID = 3L;
	public static final long TICKETS_SOLD_UID = 4L;

	
	private SerializationIDs() {
        // Private Konstruktor, um Instanziierung zu verhindern
    }
}
