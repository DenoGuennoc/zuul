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
    private HashSet<Item> aItemList;
    
    /**
     * Constructor of the Room class.
     */
    public Room (final String pDescription, final String pImageName) 
    {
        this.aDescription = pDescription;
        exits = new HashMap<String, Room>();
        this.aImageName = pImageName;
        this.aItemList = new HashSet<Item>();
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
     * It contains the name of the room, the list of its exits
     * and the list of the items in the room.
     */
    public String getLongDescription ()
    {
        return "You are in " + aDescription + ".\n" + getExitString() + ".\n" + getItemDescription();
    }
    
    /**
     * Returns a String describing the room's image name.
     */
    public String getImageName ()
    {
        return this.aImageName;
    }
    
    /**
     * Used to add an item to the current room.
     */
    public void addItem (final Item pItem)
    {
         this.aItemList.add(pItem);
    }
    
    /**
     * Returns the informations about the items located in the
     * current room, returns "Item : " + the list of all the 
     * name of the disponibles items.
     * 
     * If there's no item in the room, returns "No item here."
     */
    public String getItemDescription()
    {
        String vItemList = "Item : ";
        if (this.aItemList.isEmpty())
            return "No item here" + ".\n";
        else   
            for(Item vItem : aItemList)
            {
                vItemList += vItem.getItemName() + " ";
            }
        return vItemList + ".\n";
    }
    
    public HashSet<Item> getItemList ()
    {
        return this.aItemList;
    }
    
    
} // Room
