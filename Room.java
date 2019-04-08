import java.util.*; 

/**
 * Classe permettant la création des sorties des différentes salles.
 * Une Room est caractérisée par ses sorties et sa description longue.
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String aImageName;
    
    /**
     * Constructeur naturel de la classe.
     */
    public Room (final String pDescription) 
    {
        this.aDescription = pDescription;
        exits = new HashMap<String, Room>();
        aImageName = "image";
    }
    
    /**
     * Accesseur, permet d'accéder à la description de la Room et de
     * pouvoir s'en servir dans d'autres classes.
     */
    public String getDescription ()
    {
        return this.aDescription;
    }
    
    /**
     * Modificateur, place les sorties des Room en fonction de la direction
     * dans laquelle elles se trouvent et de la Room voisine, à laquelle alles
     * donnent accès.
     */
    public void setExit (final String pDirection, final Room pVoisin)
    {
        exits.put(pDirection, pVoisin);
    }
    
    /**
     * Accesseur, retourne la valeur de chaque sortie en fonction
     * de la direction souhaitée.
     */
    public Room getExit(String pDirection)
    {
        return exits.get(pDirection);
    }
    
    /**
     * Retourne la liste des sorties de la Room.
     */
    public String getExitString()
    {
        String returnString = "Exits : ";
        Set<String> keys = exits.keySet();
        for (String exit : keys)
        {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Retourne une description longue de la Room dans laquelle le joueur se trouve.
     * Cette description peut contenir plus que le simple nom de la pièce et la
     * liste de ses sorties.
     */
    public String getLongDescription ()
    {
        return "You are in the " + aDescription + ".\n" + getExitString();
    }
    
    /**
     * Return a string describing the room's image name.
     */
     public String getImageName ()
     {
         return this.aImageName;
     }
    
} // Room
