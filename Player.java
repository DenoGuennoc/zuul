import java.util.*;

/**
* Write a description of class Player here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class Player
{
    // instance variables - replace the example below with your own
    private String aName;
    private int aCarriedWeight;
    final int aMaxWeight;
    private ItemList aCarriedItems;
    private Room aCurrentRoom;
    private Stack<Room> aPreviousRooms;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aCarriedWeight = 0;
        this.aMaxWeight = 100;
        this.aPreviousRooms = new Stack<Room>();
        this.aCarriedItems = new ItemList();
    }
    
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom;
    }
    
    public void addPreviousRoom(final Room pRoom)
    {
        aPreviousRooms.push(pRoom);
    }
    
    public boolean noPreviousRoom()
    {
        return aPreviousRooms.empty();
    }
    
    public Room getPreviousRoom()
    {
        return aPreviousRooms.pop();
    }
    
    public int getCarriedWeight ()
    {
        return this.aCarriedWeight;
    }
    
    public void setCarriedWeight (final int pWeight)
    {
        this.aCarriedWeight = pWeight;
    }
    
    public ItemList getCarriedItems ()
    {
        return this.aCarriedItems;
    }
    
    public String BagInventory ()
    {
        return "Items in your bag : " + this.aCarriedItems.toStringList() + this.aCarriedWeight;
    }
    
}
