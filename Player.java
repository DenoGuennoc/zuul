import java.util.*;

/**
 * Class Player :
 * Contains all the player related informations such as his name,
 * where he is, where he has been, what's in his bag or his timer.
 * 
 * @author  Denoela Guennoc
 * @version 2019
*/
public class Player
{
    // instance variables - replace the example below with your own
    private String aName;
    private int aCarriedWeight;
    private int aMaxWeight;
    private ItemList aCarriedItems;
    private Room aCurrentRoom;
    private Stack<Room> aPreviousRooms;
    final int aTimeLimit;
    private int aTimer;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aCarriedWeight = 0;
        this.aMaxWeight = 20;
        this.aPreviousRooms = new Stack<Room>();
        this.aCarriedItems = new ItemList();
        this.aTimeLimit= 50;
        this.aTimer = 0;
    }
    
    /**
     * Used to change the maximal weight the player can carry.
     */
    public void setMaxWeight (final int pNewWeight)
    {
        this.aMaxWeight = pNewWeight;
    }
    
    /**
     * Used to access the maximal weight the player can carry.
     * @return int aMaxWeight
     */
    public int getMaxWeight ()
    {
        return this.aMaxWeight;
    }
    
    /**
     * Used to access the current room the player is in.
     * @return Room aCurrentRoom
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
     * Used to change the current room the player is in.
     */
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom;
    }
    
    /**
     * Used to add a room to the stack containing all the
     * previous rooms the player has been in.
     */
    public void addPreviousRoom(final Room pRoom)
    {
        aPreviousRooms.push(pRoom);
    }
    
    /**
     * @return true if the stack containing the previous
     * rooms the player has been in is empty.
     * @return false otherwise.
     */
    public boolean noPreviousRoom()
    {
        return aPreviousRooms.empty();
    }
    
    /**
     * @return the last room the player has been in and
     * erases it from the stack.
     */
    public Room popPreviousRoom()
    {
        return aPreviousRooms.pop();
    }
    
    /**
     * Used to access the weight the player is already
     * carrying with him.
     * @return int aCarriedWeight
     */
    public int getCarriedWeight ()
    {
        return this.aCarriedWeight;
    }
    
    /**
     * Used to change the weight the player is carrying.
     */
    public void setCarriedWeight (final int pWeight)
    {
        this.aCarriedWeight = pWeight;
    }
    
    /**
     * Used to access the list of items the player has in
     * his bag.
     * @return ItemList aCarriedItems
     */
    public ItemList getCarriedItems ()
    {
        return this.aCarriedItems;
    }
    
    /**
     * @return the String of all the items the player has
     * in his bag, the weight it takes and the weight left.
     */
    public String BagInventory ()
    {
        return "Items in your bag : " + this.aCarriedItems.toStringList() + this.aCarriedItems.toLongStringList() + "Occupied spaces : " +this.aCarriedWeight + "\n" + "Unoccupied spaces : " + (this.aMaxWeight - this.aCarriedWeight);
    }
    
    /**
     * Used to access the player timer.
     * @return int aTimer
     */
    public int getTimer ()
    {
        return this.aTimer;
    }
    
    /**
     * Increment the player clock from one to one.
     */
    public void Clock ()
    {
        this.aTimer++;
    }
    
    
    /**
     * @return true if there is no door between the player's
     * current room and his previous one.
     */
    public boolean canGoBack ()
    {
        return this.aCurrentRoom.isExit(aPreviousRooms.peek());
    }
    
}
