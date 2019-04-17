
/**
 * Décrivez votre classe Item ici.
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

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(final String pItemName, final String pItemDescription, final int pItemWeight)
    {
        // initialisation des variables d'instance
        this.aItemName = pItemName;
        this.aItemDescription = pItemDescription;
        this.aItemWeight = pItemWeight;
    }
    
    public String getItemName ()
    {
        return this.aItemName;
    }
    
    public String getItemDescription ()
    {
        return this.aItemDescription;
    }
    
    public int getItemWeight ()
    {
        return this.aItemWeight;
    }
    
    public void setItemName (final String pItemName)
    {
        this.aItemName = pItemName;
    }
    
    public void setItemDescription (final String pItemDescription)
    {
        this.aItemDescription = pItemDescription;
    }
    
    public void setItemWeight (final int pItemWeight)
    {
        this.aItemWeight = pItemWeight;
    }
}
