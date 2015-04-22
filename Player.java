import java.util.Stack;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Room currentRoom;
    private Stack<Room> visitedRooms;
    private ArrayList<Item> mochila;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        visitedRooms = new Stack<>();
        mochila = new ArrayList<>();
    }

    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * The player eats
     */  
    public void eat() 
    {
        System.out.println("You have eaten now and you are not hungry any more");
    }

    /** 
     * Print the room's long description 
     */   
    public void look()
    {
        printLocationInfo();
    }

    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());      
    }

    public void goRoom(String direccion)
    {
        
        
        // Try to leave current room.      
        Room nextRoom = currentRoom.getExit(direccion);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            
            visitedRooms.push(currentRoom);          
            currentRoom = nextRoom;
            look();
        }
    }
    
    /**
     * Return to the previous room
     */
    public void back()
    {
        if (!visitedRooms.empty()) {
            currentRoom = visitedRooms.pop();
            look();
        }
        else {
            System.out.println("You are at the beggining of the game");
            System.out.println();
        }
    }
    
    public void take(String idItem){
       Item objetoActual = currentRoom.removeItem(idItem);
       if(objetoActual != null){
           mochila.add(objetoActual); 
           
       }
       else{
           System.out.println("el objeto no se encuentra en la habitacion");
       }
    }
}






