import java.util.*; 

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    private static final String[] sValidCommands = {
        "go", "quit", "help", "look", "eat"
    };
    
    /**
     * Create a String with a list of all the valid commands.
     */
    public String getCommandList ()
    {
        String ComList = "";
        for (String pCommand : sValidCommands) {
            ComList += pCommand + " ";
        }
        return ComList;
    }
    
    
    /**
     * Constructor of the class CommandWords.
     */
    public CommandWords()
    {
        // rien a faire pour le moment...
    } // CommandWords()

    /**
     * Check if a given String is a valid command.
     * Returns true if pString (tested String) is a valid command.
     * Returns false otherwise.
     */
    public boolean isCommand( final String pString )
    {
        // pour chacune des commandes valides (du tableau constant)
        for ( int i=0; i<sValidCommands.length; i++ ) {
            // si elle est egale a pString
            if ( sValidCommands[i].equals( pString ) )
                return true;
        } // for
        // si nous arrivons la, c'est que la commande
        // n'a pas ete trouvee dans le tableau
        return false;
    } // isCommand()
} // CommandWords
