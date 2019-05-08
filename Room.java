import java.util.*; 

/**
 * Class Room :
 * 
 * Contains all the needed accessors and modifiers concerning the rooms
 * and exits.
 * 
 * @author  Denoela Guennoc
 * @version 2019
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String aImageName;
    private ItemList aRoomItems;
    
    /**
     * Constructor of the Room class.
     */
    public Room (final String pDescription, final String pImageName) 
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.aImageName = pImageName;
        this.aRoomItems = new ItemList();
    }
    
    /**
     * Accessor : is used to reach the current room description.
     * @return String aDescription
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
     * Accessor : @return a value for each possible exit. @return null 
     * if the exit doesn't exist in the current room.
     */
    public Room getExit(final String pDirection)
    {
        return exits.get(pDirection);
    }
    
    /**
     * @return a list of all the possible exits for the current room.
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
     * @return a longer description of the current room.
     * It contains the name of the room, the list of its exits
     * and the list of the items in the room.
     */
    public String getLongDescription ()
    {
        return "You are in " + aDescription + ".\n" + getExitString() + ".\n" + getItemDescription() + "\n" + getItemLongDescription();
    }
    
    /**
     * @return a String describing the room's image name.
     */
    public String getImageName ()
    {
        return this.aImageName;
    }
    
    /**
     * Used to add an item to the room.
     */
    public void addItem (final Item pItem)
    {
        this.aRoomItems.addItem(pItem);
    }
    
    /**
     * @return the informations about the items located in the
     * current room, returns "Item : " + the list of all the 
     * name of the disponibles items.
     * 
     * If there's no item in the room, @return "No item here."
     */
    public String getItemDescription()
    {
        return "Items avalable here : " + aRoomItems.toStringList();
    }
    
    /**
     * @return the informations about the items located in the
     * current room, returns "Item description : " + the name of 
     * the disponibles items, there description and its weight.
     */
    public String getItemLongDescription()
    {
        return aRoomItems.toLongStringList();
    }
    
    /**
     * Used to access the list of all the items in the room.
     * @return ItemList aRoomItems
     */
    public ItemList getRoomItems ()
    {
        return this.aRoomItems;
    }
    
    /**
     * @return true if there is a door between the current room
     * and the room placed as the parameter.
     */
    public boolean isExit (final Room pRoom)
    {
        return this.exits.containsValue(pRoom);
    }
    
} // Room
