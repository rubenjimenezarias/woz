import java.util.Stack;
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
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        visitedRooms = new Stack<>();
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
}
