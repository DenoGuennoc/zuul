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
        createRooms();
        
    }
    
    public void setGUI(UserInterface userInterface)
    {
       gui = userInterface;
       printWelcome();
    }
    
    /**
     * Prints out a welcome message at the begining of the game.
     * Also print the current location and its description.
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
     * Creates all the rooms and attributes their exits.
     * Also generate a catalog of all the rooms.
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
       
       aRooms = new HashMap<String, Room>();
       aRooms.put("Theatre", vTheatre);
       aRooms.put("Outside", vOutside);
       aRooms.put("Pub", vPub);
       aRooms.put("Lab", vLab);
       aRooms.put("Office", vOffice);
       aRooms.put("Premier", vPremier);
        
       // Initialisation du lieu courant
       this.aCurrentRoom = vOutside;
     }
    
    /**
     * Attributes to each command the user gave the right method.
     */
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
     * Prints out a list of the commands the user can rely on.
     */
    private void printHelp ()
    {
        gui.println ("\n");
        gui.println ("You are lost. You are alone.");
        gui.println ("You wander around at the university.");
        gui.println ("\n");
        gui.println ("Your command words are : " + aParser.showCommands());
    }
    
    /**
     * Allows to move from a room to another if an exit is available
     * in the direction chosen by the user.
     */
    private void goRoom (final Command pDep)
    {
        // Cas 1 : pas de direction donnée
        if (!pDep.hasSecondWord())
        { gui.println("Go where ?"); return; }
        
        // Extraction du SecondWord pour connaître la direction choisie
        String vDirection = pDep.getSecondWord();
        Room vNextRoom = null;
        
        // Ensemble des cas de déplacements possibles
        if (this.aCurrentRoom.getExit(vDirection) != null) {
            vNextRoom = aCurrentRoom.getExit(vDirection);
            aCurrentRoom = vNextRoom;
            this.printLocationInfo();
        }
        else
            gui.println("There is no door !");
    }
    
    /**
     * By using the look command, the user can see at anytime which room
     * he is in, and the long description of it.
     */
    private void look()
    {
        gui.println(aCurrentRoom.getLongDescription());
    }
    
    /**
     * So the character could eat.
     */
    private void eat()
    {
        gui.println("You have eaten now and you are not angry any more");
    }
    
    /**
     * Prints out the long description of the current room and the picture
     * attached to it if there's one.
     */
    private void printLocationInfo()
    {
        gui.println(aCurrentRoom.getLongDescription());
        if (aCurrentRoom.getImageName() != null)
            gui.showImage(aCurrentRoom.getImageName());
    }
        
    /**
     * Allows the user to quit the game.
     */
    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
}