import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    private HashMap<String, Option> commands;


    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<>();
        commands.put("ir", Option.GO);
        commands.put("salir", Option.QUIT);
        commands.put("volver", Option.BACK);
        commands.put("ayuda", Option.HELP);
        commands.put("coger", Option.TAKE);
        commands.put("dejar", Option.DROP);
        commands.put("comer", Option.EAT);
        commands.put("mirar", Option.LOOK);
        commands.put("items", Option.ITEMS);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return commands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */    
    public void showAll()
    {
        for (String command : commands.keySet()) {
            System.out.print(command + " - ");
        }
    }
    
    /**
     * Return the object Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return the object Option correspondng to the paramater commandWord, or the object Option.UNKNOWN
     *         if it is not a valid command word
     */
    public Option getCommandWord(String commandWord)    
    {
        Option valueReturned = Option.UNKNOWN;
        if (isCommand(commandWord)) {
            valueReturned = commands.get(commandWord);
        }
        return valueReturned;
    }
    
    
    
}


















