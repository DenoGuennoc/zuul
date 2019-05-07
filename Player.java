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
    private HashSet<Item> aCarriedItems;
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
        this.aCarriedItems = new HashSet<Item>();
        this.aPreviousRooms = new Stack<Room>();
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
    
    public HashSet<Item> getCarriedItems ()
    {
        return this.aCarriedItems;
    }
}
