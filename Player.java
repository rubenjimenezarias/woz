import java.util.Stack;
import java.util.ArrayList;
import java.lang.System;
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
    
    private int gasolina;
    private long tiempoUltimoMovimiento;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(double maxCarry)
    {
        visitedRooms = new Stack<>();
        mochila = new ArrayList<>();
        this.maxCarry = maxCarry;
        gasolina = 6;
        tiempoUltimoMovimiento = System.currentTimeMillis();
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
        System.out.println("Te quedan " + gasolina + " litros de gasolina.");
    }

    private void printLocationInfo()
    {
        if (currentRoom.getVacio()){
            System.out.println("ENHORABUENA YA HAS APARCADO");
            
        }
        else{
            System.out.println(currentRoom.getLongDescription());
        }
    }

    public void goRoom(String direccion)
    {
        if (((System.currentTimeMillis()-tiempoUltimoMovimiento)/1000) < 2){
            System.out.println("GAME OVER.Has ido muy rapido te ha pillado la policia");
        }
        else if(gasolina == 0){
            System.out.println("GAME OVER SIN GASOLINA!");
        }
        else{
            gasolina --;
            tiempoUltimoMovimiento = System.currentTimeMillis();
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

    /**
     * Return to the previous room
     */
    public void back()
    {
        if (((System.currentTimeMillis()-tiempoUltimoMovimiento)/1000) > 8){
            System.out.println("Has ido muy rapido te ha pillado la policia");
        }
        if (gasolina == 0){
            System.out.println("GAME OVER SIN GASOLINA!");
        }
        gasolina --;
        tiempoUltimoMovimiento = System.currentTimeMillis();
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
            if(objetoActual.puedeCogerse())
            {
                if((currentCarry() + objetoActual.getWeight()) < maxCarry)
                {
                    mochila.add(objetoActual); 
                    currentRoom.removeItem(objetoActual);
                    System.out.println("Has cogido el objeto" + objetoActual.getLongDescription());
                }
                else
                {
                    System.out.println("No puedes coger ese objeto porque llevas mucho peso");
                }
            }
            else{
                System.out.println("El objeto no puede cogerse");
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

    public void drop(String item){
        if(item != null){
            Item buscado = null;
            int idBuscada = Integer.parseInt(item);
            for (int i=0; i < mochila.size() && buscado == null; i++){
                if(idBuscada == mochila.get(i).getId()){
                    buscado = mochila.get(i);
                }
            }
            if(buscado == null){
                System.out.println("Ese objeto no esta en la mochila");
            }else{
                System.out.println("Has dejado: " + buscado.getLongDescription());
                currentRoom.addItem(buscado);
                mochila.remove(buscado);
            }
        }else{
            System.out.println("Necesito que indiques que soltar");
        }
    }
    
    public void listItems(){
        for(Item obj : mochila){
            System.out.println(obj.getLongDescription());
        }
    }
}

