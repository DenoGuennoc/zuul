 import java.util.*; 
 
/**
* This class creates all rooms, creates the parser and starts
* the game. It also evaluates and executes the commands that
* the parse returns.
*/

public class GameEngine
{
    private Parser aParser;
    private Room aCurrentRoom;
    private UserInterface gui;
    private HashMap <String, Room> aRooms;
     
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine ()
    {
        aParser = new Parser();
        this.createRooms();
        aRooms = new HashMap<String, Room>();
    }
    
    public void setGUI(UserInterface userInterface)
    {
       gui = userInterface;
       printWelcome();
    }
    
    /**
     * Affiche un message d'accueil au début du jeu ainsi que
     * la pièce corrante et sa description.
     */
    private void printWelcome ()
    {
       gui.print ("\n");
       gui.println("Welcome to the World of Zuul!");
       gui.println("World of Zuul is a new, incredibly boring adventure game.");
       gui.println("Type 'help' if you need help.");
       gui.println("\n");
       gui.println(aCurrentRoom.getLongDescription());
       gui.showImage(aCurrentRoom.getImageName());
    }
     
    /**
     * Créateur de salles :
     * Crée les Room et leur attribue des sorties.
     */
    private void createRooms ()
    {
       // Déclaration des différents lieux
       Room vOutside = new Room("main entrance");
       Room vTheatre = new Room("lecture theatre");
       Room vPub = new Room("campus pub");
       Room vLab = new Room("computing lab");
       Room vOffice = new Room("computing admin office");
       Room vPremier = new Room("first floor");
       
       /** Pour le jeu :
        Room vFr = new Room("France");
        Room vNZ = new Room("New Zealand");
        Room vAu = new Room("Australia");
        Room vIndo = new Room("Indonesia");
        Room vInde = new Room("India");
        Room vJo = new Room("Jordan");
        Room vKe = new Room("Kenya");
        Room vAS = new Room("South Africa");
        Room vCR = new Room("Costa Rica");
        Room vCa = new Room("Canada");
        Room vGr = new Room("Greenland");
        Room vIs = new Room("Iceland");
        Room vEc = new Room("Scotland");
        */
        
       // Positionnement des sorties
       vOutside.setExit ("east", vTheatre);
       vOutside.setExit ("south", vLab);
       vOutside.setExit ("west", vPub);
       vTheatre.setExit ("west", vOutside);
       vPub.setExit ("east", vOutside);
       vPub.setExit ("up", vPremier);
       vLab.setExit ("north", vOutside);
       vLab.setExit ("east", vOffice);
       vOffice.setExit ("west", vLab);
       vPremier.setExit ("down", vPub);
       
       /** vOutside.setExit ("north", vFr);
        
       //Pour le jeu :
       vFr.setExit("sail", vEc);
       vFr.setExit("fly to NewZeland", vNZ);
       vFr.setExit("fly to Costa Rica", vCR);
       vCR.setExit("fly to France", vFr);
       vEc.setExit("sail to France", vFr);
       vNZ.setExit("fly to France", vFr);
       */
        
       aRooms.put("Theatre", vTheatre);
       aRooms.put("Outside", vOutside);
       aRooms.put("Pub", vPub);
       aRooms.put("Lab", vLab);
       aRooms.put("Office", vOffice);
       aRooms.put("Premier", vPremier);
        
       // Initialisation du lieu courant
       this.aCurrentRoom = vOutside;
     }
    
    public void processCommand (String pCommandLine)
    { 
        gui.println(pCommandLine);
        Command aCommand = aParser.getCommand(pCommandLine);
         
        if (aCommand.isUnknown()) 
        {
            gui.println("I don't know what you mean...");
            return;
        }
        
        String vCommandWord = aCommand.getCommandWord();
        if (vCommandWord.equals("help"))
            printHelp();
        else if (vCommandWord.equals("go"))
            goRoom(aCommand);
        else if (vCommandWord.equals("quit")) {
            if(aCommand.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
        }
        else if (vCommandWord.equals("look")) 
            look();
        else if (vCommandWord.equals("eat"))
            eat();
    }
    
    /**
     * Commande d'aide :
     * Rapelle les commandes disponibles à l'utilisateur pour jouer.
     */
    private void printHelp ()
    {
        gui.println ("\n");
        gui.println ("You are lost. You are alone.");
        gui.println ("You wander around at the university.");
        gui.println ("\n");
        gui.println ("Your command words are:" + aParser.showCommands());
    }
    
    /**
     * Permet le déplacement entre les différente salles.
     */
    private void goRoom (final Command pDep)
    {
        // Cas 1 : pas de direction donnée
        if (!pDep.hasSecondWord())
        { gui.println("Go where ?"); return; }
        
        // Extraction du SecondWord pour connaître la direction choisie
        String vDirection = pDep.getSecondWord();
        vDirection = vDirection.toLowerCase();
        Room vNextRoom = aCurrentRoom.getExit(vDirection);
        
        // Ensemble des cas de déplacements possibles
        if (vNextRoom == null)
            gui.println("There is no door !");
        else {
            aCurrentRoom = vNextRoom;
            gui.println(aCurrentRoom.getLongDescription());
            if (aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
        }
    }
    
    /**
     * Commande look :
     * Permet à tout moment de visualiser la salle dans laquelle se
     * trouve le joueur et sa description longue.
     */
    private void look()
    {
        System.out.println(aCurrentRoom.getLongDescription());
    }
    
    /**
     * Commande eat :
     * Fait manger le personnage.
     */
    private void eat()
    {
        System.out.println("You have eaten now and you are not angry any more");
    }
    
    /**
     * Affiche le nom de la pièce corrante, la liste des sorties disponibles
     * et sa description longue.
     */
    private void printLocationInfo()
    {
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
        
    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
}