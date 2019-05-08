
/**
 * Class Item :
 * 
 * Creates an Item with a name, a description and a weight.
 * Also contains informations on the item as is it edible
 * or is it magic and in that case its power.
 * Contains the getters and setters for each parameter.
 *
 * @author Denoela Guennoc
 * @version 2019
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aItemName;
    private String aItemDescription;
    private int aItemWeight;
    private boolean aIsMagic;
    private boolean aIsEdible;
    private int aPower;

    /**
     * Constructor of the Item class.
     */
    public Item(final String pItemName, final String pItemDescription, final int pItemWeight, final boolean pEdible)
    {
        // initialisation des variables d'instance
        this.aItemName = pItemName;
        this.aItemDescription = pItemDescription;
        this.aItemWeight = pItemWeight;
        this.aIsMagic = false;
        this.aIsEdible = pEdible;
        this.aPower = 1;
    }
    
    /**
     * Returns true if the item is magic.
     * Returns false otherwise.
     */
    public boolean getIsMagic ()
    {
        return this.aIsMagic;
    }
    
    /**
     * Returns true if the item is edible.
     * Returns false otherwise.
     */
    public boolean getIsEdible ()
    {
        return this.aIsEdible;
    }
    
    /**
     * Used to access the power of the item.
     * The power is the number of times the weight the
     * player can carry would be multiply if the item
     * is eaten.
     */
    public int getPower ()
    {
        return this.aPower;
    }
    
    /**
     * Used to set an item as a magic one and to set its power.
     */
    public void setIsMagic (final boolean pMagic, final int pPower)
    {
        this.aIsMagic = pMagic;
        this.aPower = pPower;
    }
    
    /**
     * Accessor : used to access the name of the item.
     */
    public String getItemName ()
    {
        return this.aItemName;
    }
    
    /**
     * Accessor : used to access the description of the item.
     */
    public String getItemDescription ()
    {
        return this.aItemDescription;
    }
    
    /**
     * Accessor : used to access the weight of the item.
     */
    public int getItemWeight ()
    {
        return this.aItemWeight;
    }
    
    /**
     * Modifier : used to set the Item's name.
     */
    public void setItemName (final String pItemName)
    {
        this.aItemName = pItemName;
    }
    
    /**
     * Modifier : used to set the Item's description.
     */
    public void setItemDescription (final String pItemDescription)
    {
        this.aItemDescription = pItemDescription;
    }
    
    /**
     * Modifier : used to set the Item's weight.
     */
    public void setItemWeight (final int pItemWeight)
    {
        this.aItemWeight = pItemWeight;
    }
}
