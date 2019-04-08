 import java.util.*; 
 
/**
 * Classe du jeu :
 * Contient la création des salles et les actions associées
 * à chaque commande auxquelles l'utilisateur peut faire appel.
 */
public class Game
{
    private UserInterface gui;
    private GameEngine aEngine;
    
    /**
     * Constructeur naturel de la classe.
     */
    public Game ()
    {
        aEngine = new GameEngine();
        gui = new UserInterface(aEngine);
        aEngine.setGUI(gui);
    }
    
    /**
    
     * Permet le déplacement entre les différente salles.
    
    private void goRoom (final Command pDep)
    {
        // Cas 1 : pas de direction donnée
        if (!pDep.hasSecondWord())
        { System.out.println("Go where ?"); return; }
        
        // Extraction du SecondWord pour connaître la direction choisie
        Room vNextRoom = null;
        String vDirection = pDep.getSecondWord();
        vDirection = vDirection.toLowerCase();
        
        // Ensemble des cas de déplacements possibles
        if (vDirection.equals("north") && this.aCurrentRoom.getExit("north") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("north");
        }
        if (vDirection.equals("east") && this.aCurrentRoom.getExit("east") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("east");
        }
        if (vDirection.equals("south") && this.aCurrentRoom.getExit("south") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("south");
        }
        if (vDirection.equals("west") && this.aCurrentRoom.getExit("west") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("west");
        }
        if (vDirection.equals("up") && this.aCurrentRoom.getExit("up") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("up");
        }
        if (vDirection.equals("down") && this.aCurrentRoom.getExit("down") != null)
        {
            vNextRoom = this.aCurrentRoom.getExit("down");
        }
        if (vNextRoom == null)
        {
            System.out.println("There is no door !"); return;
        }
        else {
            // Actualisation du lieu corrant
            this.aCurrentRoom = vNextRoom;
            // Infos sur le nouveau lieu courrant
            this.printLocationInfo();
        } 
    }
    */
} // Game
