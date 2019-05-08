import java.util.*;

/**
 * Write a description of class ItemList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ItemList
{
    // instance variables - replace the example below with your own
    private HashSet<Item> aItemList;

    /**
     * Constructor for objects of class ItemList
     */
    public ItemList()
    {
        this.aItemList = new HashSet<Item>();
    }
    
    public void addItem (final Item pItem)
    {
        this.aItemList.add(pItem);
    }
    
    public void removeItem (final Item pItem)
    {
        this.aItemList.remove(pItem);
    }
    
    public boolean emptyList ()
    {
        return this.aItemList.isEmpty();
    }
    
    public String toStringList ()
    {
        String vItemList = "";
        if (this.aItemList.isEmpty())
            return "No item here" + ".\n";
        else   
            for(Item vItem : this.aItemList)
            {
                vItemList += vItem.getItemName() + " ";
            }
        return vItemList + ".\n";
    }
    
    public boolean ItemExist (final String pItemName)
    {
        boolean vItemExist = false;
        for(Item vItem : this.aItemList)
        {
            if (vItem.getItemName().equals(pItemName))
            {
                return vItemExist = true;
            }
        }
        return vItemExist;
    }
    
    public Item getItem (final String pItemName)
    {
        for(Item vItem : this.aItemList)
        {
            if (vItem.getItemName().equals(pItemName))
            {
                return vItem;
            }
        }
        return null;
    }
    
}
