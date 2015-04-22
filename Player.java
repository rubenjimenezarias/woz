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
    private double maxCarry;
    /**
     * Constructor for objects of class Player
     */
    public Player(double maxCarry)
    {
        visitedRooms = new Stack<>();
        mochila = new ArrayList<>();
        this.maxCarry = maxCarry;
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
        Item objetoActual = currentRoom.searchItem(idItem);
        if(objetoActual != null){
            if((currentCarry() + objetoActual.getWeight()) < maxCarry)
            {
                mochila.add(objetoActual); 
                currentRoom.removeItem(objetoActual);
            }
            else
            {
                System.out.println("No puedes coger ese objeto porque llevas mucho peso");
            }
        }
        else{
            System.out.println("el objeto no se encuentra en la habitacion");
        }
    }

    private double currentCarry()
    {
        double currentCarry = 0F;
        for(int i = 0; i < mochila.size(); i++)
        {
            currentCarry += mochila.get(i).getWeight();
        }
        return currentCarry;
    }   

        
        
        
}



