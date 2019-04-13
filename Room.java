import java.util.*; 

/**
 * Room class :
 * Contains all the needed accessors and modifiers concerning the rooms
 * and exits.
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String aImageName;
    
    /**
     * Constructor of the Room class.
     */
    public Room (final String pDescription) 
    {
        this.aDescription = pDescription;
        exits = new HashMap<String, Room>();
        aImageName = "image";
    }
    
    /**
     * Accessor : is used to reach the current room description.
     */
    public String getDescription ()
    {
        return this.aDescription;
    }
    
    /**
     * Modifier : set each room exits depending on the name of the exit
     * and the other room linked to it.
     */
    public void setExit (final String pDirection, final Room pVoisin)
    {
        exits.put(pDirection, pVoisin);
    }
    
    /**
     * Accessor : returns a value for each possible exit. Returns null 
     * if the exit doesn't exist in the current room.
     */
    public Room getExit(String pDirection)
    {
        return exits.get(pDirection);
    }
    
    /**
     * Returns a list of all the possible exits for the current room.
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
     * Returns a longer description of the current room.
     * It contains the name of the room and the list of its exits.
     */
    public String getLongDescription ()
    {
        return "You are in " + aDescription + ".\n" + getExitString();
    }
    
    /**
     * Returns a String describing the room's image name.
     */
     public String getImageName ()
     {
         return this.aImageName;
     }
    
} // Room
