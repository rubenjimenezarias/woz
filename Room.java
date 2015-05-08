import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;   
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private boolean vacio;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        vacio = false;
    }

    public void setExit(String direction, Room nextRoom)
    {
        exits.put(direction, nextRoom);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String direction) 
    {               
        return exits.get(direction);
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()    
    {
        Set<String> namesOfDirections = exits.keySet();
        String exitsDescription = "Exit ";

        for (String direction : namesOfDirections) {
            exitsDescription += direction + " ";
        }

        return exitsDescription;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String longDescription = "You are " + description + ".\n" + getExitString() + "\n";
        longDescription += "There are " + items.size() + " items: \n";
        for (Item item : items) {
            longDescription += "- " + item.getLongDescription() + "\n";
        }
        return longDescription;
    }
    
    /**
     * Add an item to the room
     * 
     * @param item An item to be added to the room
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    // Devuelve el objeto correspondiente al idItem o null si no estuviera en la habitacion.
    public Item searchItem(String idItem){
        Item itemADevolver = null;
        int cont = 0;
        boolean encontrado = false;
        
        
        while(!encontrado && cont < items.size())
        {
            if(Integer.parseInt(idItem) == items.get(cont).getId())
            {
                itemADevolver = items.get(cont);
                encontrado = true;
            }
            cont++;
        }
        
        return itemADevolver;
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
    }
    
    public void setVacio(){
        vacio = true;
    }
    
    public boolean getVacio(){
        return vacio;
    }

    
    
}
