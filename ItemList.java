import java.util.*;

/**
 * Class ItemList :
 * 
 * Contains the methods related to items lists.
 *
 * @author Denoela Guennoc
 * @version 2019
 */
public class ItemList
{
    // instance variables - replace the example below with your own
    private HashSet<Item> aItemList;

    /**
     * Constructor for objects of class ItemList.
     */
    public ItemList()
    {
        this.aItemList = new HashSet<Item>();
    }
    
    /**
     * Used to add an item to the list.
     */
    public void addItem (final Item pItem)
    {
        this.aItemList.add(pItem);
    }
    
    /**
     * Used to remove an item from the list.
     */
    public void removeItem (final Item pItem)
    {
        this.aItemList.remove(pItem);
    }
    
    /**
     * @return true if there is no items in the list.
     */
    public boolean emptyList ()
    {
        return this.aItemList.isEmpty();
    }
    
    /**
     * @return a String containing the names of the items
     * in the list.
     * 
     * @return No item here if the list is empty.
     */
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
    
    /**
     * @return for each item in the list its name, description
     * and weight.
     */
    public String toLongStringList ()
    {
        String vItemList = "";
        if (this.aItemList.isEmpty())
            return vItemList;
        else
        {  
            vItemList += "Item's description : \n";
            for(Item vItem : this.aItemList)
            {
                vItemList += vItem.getItemName() + ", " + vItem.getItemDescription() + ", " + "needed space : " + vItem.getItemWeight() + "\n";
            }
        }
        return vItemList + ".\n";
    }
    
    /**
     * @return true if the item's name place as parameter is in the list.
     */
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
    
    /**
     * Used to access an item in the list based on its name.
     * @return the item with the given name
     */
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
