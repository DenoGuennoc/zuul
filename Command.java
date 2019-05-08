import java.util.*; 

/**
 * Class Command :
 * 
 * Creates a command. A command can be one or two words.
 * 
 * @author Denoela Guennoc
 * @version 2019
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
     * @return the first word of the command the user gave.
     */
    public String getCommandWord ()
    {
        return this.aCommandWord;
    }
    
    /**
     * @return the second word of the command the user gave.
     */
    public String getSecondWord ()
    {
        return this.aSecondWord;
    }
    
    /**
     * @return true if the command the user gave contains a second word.
     * @return false otherwise.
     */
    public boolean hasSecondWord ()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * @return true if the entered command is unknown.
     */
    public boolean isUnknown ()
    {
        return this.aCommandWord == null;
    }
    
} // Command
