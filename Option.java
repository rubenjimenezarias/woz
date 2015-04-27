
/**
 * Enumeration class Option - Los comandos del juego
 * 
 */
public enum Option
{
    GO("ir"), QUIT("salir"), BACK("volver"), HELP("ayuda"), 
    TAKE("coger"), DROP("soltar"), EAT("comer"), LOOK ("mirar"),
    ITEMS("items"), UNKNOWN("");
    
    private String comando;
    
    Option(String comando)
    {
        this.comando = comando;
    }
    
    public String getComando()
    {
        return comando;
    }
}
