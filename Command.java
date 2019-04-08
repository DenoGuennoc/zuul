import java.util.*; 

/**
 * Command class :
 * 
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructor of the Command class.
     */
    public Command (final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /**
     * Accessor : returns the first word of the command the user gave.
     */
    public String getCommandWord ()
    {
        return this.aCommandWord;
    }
    
    /**
     * Accessor : returns the second word of the command the user gave.
     */
    public String getSecondWord ()
    {
        return this.aSecondWord;
    }
    
    /**
     * Returns true if the command the user gave contains a second word.
     * Returns false otherwise.
     */
    public boolean hasSecondWord ()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * Returns true if the entered command is unknown.
     */
    public boolean isUnknown ()
    {
        return this.aCommandWord == null;
    }
    
} // Command
