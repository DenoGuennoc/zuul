
/**
 * Item class :
 * Create an Item with a name, a description and a weight.
 * Contains the getters and setters for each parameter.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
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
     * Constructor of the Item class
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
    
    public boolean getIsMagic ()
    {
        return this.aIsMagic;
    }
    
    public boolean getIsEdible ()
    {
        return this.aIsEdible;
    }
    
    public int getPower ()
    {
        return this.aPower;
    }
    
    public void setIsMagic (final boolean pMagic, final int pPower)
    {
        this.aIsMagic = pMagic;
        this.aPower = pPower;
    }
    
    /**
     * Accessor : used to access the name of the item
     */
    public String getItemName ()
    {
        return this.aItemName;
    }
    
    /**
     * Accessor : used to access the description of the item
     */
    public String getItemDescription ()
    {
        return this.aItemDescription;
    }
    
    /**
     * Accessor : used to access the weight of the item
     */
    public int getItemWeight ()
    {
        return this.aItemWeight;
    }
    
    /**
     * Modifier : used to set the Item's name
     */
    public void setItemName (final String pItemName)
    {
        this.aItemName = pItemName;
    }
    
    /**
     * Modifier : used to set the Item's description
     */
    public void setItemDescription (final String pItemDescription)
    {
        this.aItemDescription = pItemDescription;
    }
    
    /**
     * Modifier : used to set the Item's weight
     */
    public void setItemWeight (final int pItemWeight)
    {
        this.aItemWeight = pItemWeight;
    }
}
