import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
* Class GameEngine :
* 
* This class creates all rooms, creates the parser and starts
* the game. It also evaluates and executes the commands that
* the parser returns.
* 
* @author  Denoela Guennoc
* @version 2019
*/

public class GameEngine
{
    private Parser aParser;
    private UserInterface gui;
    private HashMap <String, Room> aRooms;
    private Player aPlayer;
     
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine ()
    {
        this.aParser = new Parser();
        this.aPlayer = new Player("Player 1");
        createRooms();
    }
    
    /**
     * Initializes the user interface.
     */
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
       gui.println("Welcome to No'mad, 8 months for lifetime memories !");
       gui.println("No'mad is a new, incredibly cool adventure game.");
       gui.println("Type 'help' if you need help or to remember all the commands you can use.");
       gui.println("\n");
       gui.println(this.aPlayer.getCurrentRoom().getLongDescription());
       gui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }
     
    /**
     * Creates all the rooms and attributes their exits.
     * Creates items and puts them in the desired room.
     * Also generate a catalog of all the rooms.
     */
    private void createRooms ()
    {
       // Déclaration des différents lieux
       /**
       Room vOutside = new Room("main entrance");
       Room vTheatre = new Room("lecture theatre");
       Room vPub = new Room("campus pub");
       Room vLab = new Room("computing lab");
       Room vOffice = new Room("computing admin office");
       Room vPremier = new Room("first floor");
       */
      
       // Pour le jeu :
       Room vConsulat = new Room ("Consulate", "Images/consulate.jpg");
       Room vAirFr = new Room ("Centre des Air transport center", "Images/bientot.gif");
       Room vSTFr = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirNz = new Room ("Centre des Air transport center", "Images/bientot.gif");
       Room vSTNz = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirAu = new Room ("Centre des Air transport center", "Images/bientot.gif");
       Room vSTAu = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirIndo = new Room ("Centre des Air transport center", "Images/bientot.gif");
       Room vSTIndo = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirInde = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTInde = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirJo = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTJo = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirKe = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTKe = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirAs = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTAs = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirCr = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTCr = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirCa = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTCa = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirGr = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTGr = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirIs = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTIs = new Room ("Underground transport center", "Images/bientot.gif");
       Room vAirEc = new Room ("Air transport center", "Images/bientot.gif");
       Room vSTEc = new Room ("Underground transport center", "Images/bientot.gif");
       Room vFr = new Room("France", "Images/france.jpg");
       Room vNz = new Room("New Zealand", "Images/newzealand.jpg");
       Room vAu = new Room("Australia", "Images/australia.jpg");
       Room vIndo = new Room("Indonesia", "Images/indonesia.jpg");
       Room vInde = new Room("India", "Images/india.jpg");
       Room vJo = new Room("Jordan", "Images/jordan.jpg");
       Room vKe = new Room("Kenya", "Images/kenya.jpg");
       Room vAs = new Room("South Africa", "Images/southafrica.jpg");
       Room vCr = new Room("Costa Rica", "Images/costarica.jpg");
       Room vCa = new Room("Canada", "Images/canada.jpg");
       Room vGr = new Room("Greenland", "Images/greenland.jpg");
       Room vIs = new Room("Iceland", "Images/iceland.jpg");
       Room vEc = new Room("Scotland", "Images/scotland.jpg");
       
        
       // Positionnement des sorties
       /**
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
       */
        
       //Pour le jeu :
       // Vers le consulate
       vNz.setExit ("consulate", vConsulat);
       vAu.setExit ("consulate", vConsulat);
       vIndo.setExit ("consulate", vConsulat);
       vInde.setExit ("consulate", vConsulat);
       vJo.setExit ("consulate", vConsulat);
       vKe.setExit ("consulate", vConsulat);
       vAs.setExit ("consulate", vConsulat);
       vCr.setExit ("consulate", vConsulat);
       vCa.setExit ("consulate", vConsulat);
       vGr.setExit ("consulate", vConsulat);
       vIs.setExit ("consulate", vConsulat);
       vEc.setExit ("consulate", vConsulat);
       vConsulat.setExit ("france", vFr);
       
       // Vers les Air transport center
       vFr.setExit ("up", vAirFr);
       vNz.setExit ("up", vAirNz);
       vAu.setExit ("up", vAirAu);
       vIndo.setExit ("up", vAirIndo);
       vInde.setExit ("up", vAirInde);
       vJo.setExit ("up", vAirJo);
       vKe.setExit ("up", vAirKe);
       vAs.setExit ("up", vAirAs);
       vCr.setExit ("up", vAirCr);
       vCa.setExit ("up", vAirCa);
       vGr.setExit ("up", vAirGr);
       vIs.setExit ("up", vAirIs);
       vEc.setExit ("up", vAirEc);
       
       vAirFr.setExit ("down", vFr);
       vAirNz.setExit ("down", vNz);
       vAirAu.setExit ("down", vAu);
       vAirIndo.setExit ("down", vIndo);
       vAirInde.setExit ("down", vInde);
       vAirJo.setExit ("down", vJo);
       vAirKe.setExit ("down", vKe);
       vAirAs.setExit ("down", vAs);
       vAirCr.setExit ("down", vCr);
       vAirCa.setExit ("down", vCa);
       vAirGr.setExit ("down", vGr);
       vAirIs.setExit ("down", vIs);
       vAirEc.setExit ("down", vEc);
       
       // Vers les Underground transport center
       vFr.setExit ("down", vSTFr);
       vNz.setExit ("down", vSTNz);
       vAu.setExit ("down", vSTAu);
       vIndo.setExit ("down", vSTIndo);
       vInde.setExit ("down", vSTInde);
       vJo.setExit ("down", vSTJo);
       vKe.setExit ("down", vSTKe);
       vAs.setExit ("down", vSTAs);
       vCr.setExit ("down", vSTCr);
       vCa.setExit ("down", vSTCa);
       vGr.setExit ("down", vSTGr);
       vIs.setExit ("down", vSTIs);
       vEc.setExit ("down", vSTEc);
       
       vSTFr.setExit ("up", vFr);
       vSTNz.setExit ("up", vNz);
       vSTAu.setExit ("up", vAu);
       vSTIndo.setExit ("up", vIndo);
       vSTInde.setExit ("up", vInde);
       vSTJo.setExit ("up", vJo);
       vSTKe.setExit ("up", vKe);
       vSTAs.setExit ("up", vAs);
       vSTCr.setExit ("up", vCr);
       vSTCa.setExit ("up", vCa);
       vSTGr.setExit ("up", vGr);
       vSTIs.setExit ("up", vIs);
       vSTEc.setExit ("up", vEc);
       
       // Reste des sorties
       vFr.setExit ("ferry", vEc);
       vEc.setExit ("ferry", vFr);
       vAirFr.setExit ("plane", vNz);
       vAirNz.setExit ("plane", vFr);
       vAirFr.setExit ("biplane", vIs);
       vAirIs.setExit ("biplane", vFr);
       vFr.setExit ("boat", vJo);
       vJo.setExit ("boat", vFr);
       vSTFr.setExit ("nautilus", vCr);
       vSTCr.setExit ("nautilus", vFr);
       vNz.setExit ("raft", vAu);
       vAu.setExit ("raft", vNz);
       vAu.setExit ("sail", vIndo);
       vIndo.setExit ("sail", vAu);
       vAirAu.setExit ("jet", vCr);
       vAirCr.setExit ("jet", vAu);
       vSTIndo.setExit ("submarine", vInde);
       vSTInde.setExit ("submarine", vIndo);
       vAirIndo.setExit ("glider", vKe);
       vAirKe.setExit ("glider", vIndo);
       vInde.setExit ("elephant", vJo);
       vJo.setExit ("dromedary", vInde);
       vAirInde.setExit ("chopper", vFr);
       vAirFr.setExit ("chopper", vInde);
       vJo.setExit ("caravan", vKe);
       vKe.setExit ("caravan", vJo);
       vAirAs.setExit ("ballooning", vKe);
       vAirKe.setExit ("ballooning", vAs);
       vAs.setExit ("catamaran", vCr);
       vCr.setExit ("catamaran", vAs);
       vSTAs.setExit ("jvernexpress", vGr);
       vSTGr.setExit ("jvernexpress", vAs);
       vCr.setExit ("jeep", vCa);
       vCa.setExit ("jeep", vCr);
       vCa.setExit ("icebreaker", vGr);
       vGr.setExit ("icebreaker", vCa);
       vAirCa.setExit ("seaplane", vIs);
       vAirIs.setExit ("seaplane", vCa);
       vSTGr.setExit ("whale", vIs);
       vSTIs.setExit ("whale", vGr);
       vIs.setExit ("rowing", vEc);
       vEc.setExit ("rowing", vIs);
      
       
       /**
       aRooms = new HashMap<String, Room>();
       aRooms.put("Theatre", vTheatre);
       aRooms.put("Outside", vOutside);
       aRooms.put("Pub", vPub);
       aRooms.put("Lab", vLab);
       aRooms.put("Office", vOffice);
       aRooms.put("Premier", vPremier);
       */
       
       aRooms = new HashMap<String, Room>();
       aRooms.put("Consulate", vConsulat);
       aRooms.put("Air transport center", vAirFr);
       aRooms.put("Underground transport center", vSTFr);
       aRooms.put("Air transport center", vAirNz);
       aRooms.put("Underground transport center", vSTNz);
       aRooms.put("Air transport center", vAirAu);
       aRooms.put("Underground transport center", vSTAu);
       aRooms.put("Air transport center", vAirIndo);
       aRooms.put("Underground transport center", vSTIndo);
       aRooms.put("Air transport center", vAirInde);
       aRooms.put("Underground transport center", vSTInde);
       aRooms.put("Air transport center", vAirJo);
       aRooms.put("Underground transport center", vSTJo);
       aRooms.put("Air transport center", vAirKe);
       aRooms.put("Underground transport center", vSTKe);
       aRooms.put("Air transport center", vAirAs);
       aRooms.put("Underground transport center", vSTAs);
       aRooms.put("Air transport center", vAirCr);
       aRooms.put("Underground transport center", vSTCr);
       aRooms.put("Air transport center", vAirCa);
       aRooms.put("Underground transport center", vSTCa);
       aRooms.put("Air transport center", vAirGr);
       aRooms.put("Underground transport center", vSTGr);
       aRooms.put("Air transport center", vAirIs);
       aRooms.put("Underground transport center", vSTIs);
       aRooms.put("Air transport center", vAirEc);
       aRooms.put("Underground transport center", vSTEc);
       aRooms.put("France", vFr);
       aRooms.put("New Zealand", vNz);
       aRooms.put("Australia", vAu);
       aRooms.put("Indonesia", vIndo);
       aRooms.put("India", vInde);
       aRooms.put("Jordan", vJo);
       aRooms.put("Kenya", vKe);
       aRooms.put("South Africa", vAs);
       aRooms.put("Costa Rica", vCr);
       aRooms.put("Canada", vCa);
       aRooms.put("Greenland", vGr);
       aRooms.put("Iceland", vIs);
       aRooms.put("Scotland", vEc);
       
       // Ajout d'item
       Item vPassport = new Item ("passport", "you need it to travel", 1, false);
       vFr.addItem(vPassport);
       Item vPhone = new Item ("phone", "could be usefull", 1, false);
       vFr.addItem(vPhone);
       Item vEnergyBar = new Item ("energybar", "you can eat it whenever you want, it will give you more energy", 1, true);
       vEnergyBar.setIsMagic(true, 2);
       vFr.addItem(vEnergyBar);
       
       // Initialisation du lieu courant
       //this.aCurrentRoom = vOutside;
       this.aPlayer.setCurrentRoom(vFr);
    }
    
    /** 
     * Checks if the player didn't already exeeded is time limit.
     * If so, the game ends. If not, this method attributes to each 
     * command the user gave the right method.
     */
     public void processCommand (final String pCommandLine)
    { 
        gui.println(pCommandLine);
        Command aCommand = aParser.getCommand(pCommandLine);
        
        if (this.aPlayer.getTimer() > this.aPlayer.aTimeLimit)
        {
            gui.println("Time is over, you loose...");
            gui.println("Try again you may win next time !");
            endGame();
            return;
        }
        
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
            if(!aCommand.hasSecondWord())
                gui.println("Eat what?");
            else    
                eat(aCommand);
        else if (vCommandWord.equals("back"))
            if(aCommand.hasSecondWord())
                gui.println("No second word after back");
            else
                back();
        else if (vCommandWord.equals("test"))
            if(! aCommand.hasSecondWord())
                gui.println("Test what ?");
            else
                test(aCommand);
        else if (vCommandWord.equals("take"))
            if(! aCommand.hasSecondWord())
                gui.println("Take what ?");
            else
                take(aCommand);
        else if (vCommandWord.equals("drop"))
            if(! aCommand.hasSecondWord())
                gui.println("Drop what ?");
            else
                drop(aCommand);
        else if (vCommandWord.equals("inventory"))
            if(aCommand.hasSecondWord())
                gui.println("No second word after inventory");
            else
                inventory();
        
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
     * Also increment the clock each time the player gets to an other
     * room except if it is one of the Air or Underground transport centers.
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
        if (this.aPlayer.getCurrentRoom().getExit(vDirection) != null) {
            vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection);
            this.aPlayer.addPreviousRoom(this.aPlayer.getCurrentRoom());
            this.aPlayer.setCurrentRoom(vNextRoom);
            this.printLocationInfo();
            if (pDep.getSecondWord() != "up" && pDep.getSecondWord() != "down")
                this.aPlayer.Clock();
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
        gui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    }
    
    /**
     * By using the eat command, the user can eat the edibles items he
     * has in his bag.
     * If this items are magic his strength is tenfold ans he can now
     * carry even more items with him.
     */
    private void eat(final Command pCom)
    {
        if (this.aPlayer.getCarriedItems().ItemExist(pCom.getSecondWord()))
        {
            if (this.aPlayer.getCarriedItems().getItem(pCom.getSecondWord()).getIsEdible())
            {
                if (! this.aPlayer.getCarriedItems().getItem(pCom.getSecondWord()).getIsMagic())
                    gui.println("You have eaten now and you are not angry any more");
                else
                {
                    gui.println("You've got plenty of energy now !");
                    Item vItem = this.aPlayer.getCarriedItems().getItem(pCom.getSecondWord());
                    int vMaxWeight = this.aPlayer.getMaxWeight() * vItem.getPower();
                    this.aPlayer.setMaxWeight(vMaxWeight);
                    int vCarriedWeight = this.aPlayer.getCarriedWeight() - vItem.getItemWeight();
                    this.aPlayer.setCarriedWeight(vCarriedWeight);
                    this.aPlayer.getCarriedItems().removeItem(vItem);
                    gui.println("You can carry " + vItem.getPower() + " times more weight than you could before !");
                }
            }
            else
                gui.println("You can't eat that...");
        }
        else
            gui.println("You don't have that in your bag...");
    }
    
    /**
     * Allows the user to go back to the previous room by only
     * entering "back" unless he trys to get back futher than
     * the first room of the game.
     * He can neighther go back to a room if there is no door 
     * between the room he is in and the previous one.
     */
    private void back()
    {
        if (this.aPlayer.noPreviousRoom())
            gui.println ("You can't go back any further");
        else if (!this.aPlayer.canGoBack())
        {
            gui.println ("You can't go back to the place you were before this way sorry...");
        }
        else
        {
            this.aPlayer.setCurrentRoom(this.aPlayer.popPreviousRoom());
            this.printLocationInfo();
        }
    }
    
    /**
     * Allows the player to take any items in the room with
     * him if it isn't to heavy for him to carry.
     */
    private void take (final Command pCom)
    {
        if (this.aPlayer.getCurrentRoom().getRoomItems().ItemExist(pCom.getSecondWord()))
        {
            Item vItem = this.aPlayer.getCurrentRoom().getRoomItems().getItem(pCom.getSecondWord());
            int vWeight = this.aPlayer.getCarriedWeight() + vItem.getItemWeight();
            if (vWeight <= this.aPlayer.getMaxWeight())
            {
                this.aPlayer.setCarriedWeight(vWeight);
                this.aPlayer.getCarriedItems().addItem(vItem);
                this.aPlayer.getCurrentRoom().getRoomItems().removeItem(vItem);
                gui.println("You took the " + vItem.getItemName() + " with you");
                return;
            }
            else
                gui.println ("This Item is to heavy for you to carry");
        }
        else
                gui.println ("There is no such item in here");
    }
    
    /**
     * Allows the player to drop any items he has in his bag
     * in his current room.
     */
    private void drop (final Command pCom)
    {
        if (this.aPlayer.getCarriedItems().ItemExist(pCom.getSecondWord()))
        {
            Item vItem = this.aPlayer.getCarriedItems().getItem(pCom.getSecondWord());
            int vWeight = this.aPlayer.getCarriedWeight() - vItem.getItemWeight();
            this.aPlayer.setCarriedWeight(vWeight);
            this.aPlayer.getCarriedItems().removeItem(vItem);
            this.aPlayer.getCurrentRoom().getRoomItems().addItem(vItem);
            gui.println("You drop the " + vItem.getItemName());
            return;
        }
        else
        gui.println ("You don't have such item with you... what do you mean ?");
    }
    
    /**
     * Used to test some of the game possibilities.
     * Basically, this method is used to read .txt files and
     * executes line by line the commands written in it.
     */
    private void test (final Command pCom)
    {
        File vFile = new File (pCom.getSecondWord() + ".txt");
        if (!vFile.exists())
        {
            gui.println ("The file you're trying to test doesn't exist");
            return;
        }
        else {
            Scanner vScanner;
            try {
                vScanner = new Scanner(vFile);
                while (vScanner.hasNext()) {
                    String vLine = vScanner.nextLine();
                    if(vLine.replaceAll(" ", "").replaceAll("\t", "").startsWith("#")) continue;
                    processCommand(vLine);
                }
            }
            catch (final FileNotFoundException pFNFE) {
            }
        }
    }
    
    /**
     * Allows the player to see what's in his bag and the weight
     * already used by this items.
     */
    private void inventory()
    {
        gui.println(this.aPlayer.BagInventory());
    }
    
    /**
     * Prints out the long description of the current room and the picture
     * attached to it if there's one.
     */
    private void printLocationInfo()
    {
        gui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if (this.aPlayer.getCurrentRoom().getImageName() != null)
            gui.showImage(this.aPlayer.getCurrentRoom().getImageName());
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