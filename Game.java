 
/**
 * Classe du jeu :
 * Contient la création des salles et les actions associées
 * à chaque commande auxquelles l'utilisateur peut faire appel.
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    /**
     * Constructeur naturel de la classe.
     */
    public Game ()
    {
        this.createRooms();
        aParser = new Parser();
    }
    
    /**
     * Affiche un message d'accueil au début du jeu ainsi que
     * la pièce corrante et sa description.
     */
    private void printWelcome ()
    {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        this.printLocationInfo();
    }
    
    /**
     * Affiche le nom de la pièce corrante, la liste des sorties disponibles
     * et sa description longue.
     */
    private void printLocationInfo()
    {
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    /**
     * Commande d'aide :
     * Rapelle les commandes disponibles à l'utilisateur pour jouer.
     */
    private void printHelp ()
    {
        System.out.println ();
        System.out.println ("You are lost. You are alone.");
        System.out.println ("You wander around at the university.");
        System.out.println ();
        System.out.println ("Your command words are:");
        aParser.showCommands();
    }
    
    /**
     * Commande quit :
     * Permet de quitter le jeu.
     */
    private boolean quit (final Command pQuit)
    {
        if (pQuit.getSecondWord() != null)
        {
            System.out.println ("\n" + "Quit what ?");
            return false;
        }
        else { return true; }
    }
    
    /**
     * Commande look :
     * Permet à tout moment de visualiser la salle dans laquelle se
     * trouve le joueur et sa description longue.
     */
    private void look ()
    {
        System.out.println(aCurrentRoom.getLongDescription());
    }
    
    /**
     * Commande eat :
     * Fait manger le personnage.
     */
    private void eat ()
    {
        System.out.println("You have eaten now and you are not angry any more");
    }
    
    /**
     * Associe les commande existante à leurs méthodes respectives.
     * Appelle la bonne méthode en fonction de la commande entrée ou retourne
     * un message de commande inconnue.
     */
    private boolean processCommand (final Command pCom)
    {
        boolean vB = false;
        
        if (pCom.isUnknown())
        {
            System.out.println("I don't know what you mean...");
        }
        else if (pCom.getCommandWord().equals("go"))
        {
            goRoom(pCom);
        }
        else if (pCom.getCommandWord().equals("quit"))
        {
            vB = quit(pCom);
        }
        else if (pCom.getCommandWord().equals("help"))
        {
            printHelp();
        }
        else if (pCom.getCommandWord().equals("look"))
        {
            look();
        }
        else if (pCom.getCommandWord().equals("eat"))
        {
            eat();
        }
        
        return vB;
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
        Room vClemenceKoeurKoeur = new Room("Clemenceland");
        Room vLoic = new Room("Pars à Dit...");
        
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
        vClemenceKoeurKoeur. setExit ("north", vLab);
        vLab.setExit ("south", vClemenceKoeurKoeur);
        vLoic.setExit ("up", vPub);
        vPub.setExit ("down", vLoic);
        
        /** vOutside.setExit ("north", vFr);
        
        //Pour le jeu :
        vFr.setExit("sail", vEc);
        vFr.setExit("fly to NewZeland", vNZ);
        vFr.setExit("fly to Costa Rica", vCR);
        vCR.setExit("fly to France", vFr);
        vEc.setExit("sail to France", vFr);
        vNZ.setExit("fly to France", vFr);
        */
        
        
        // Initialisation du lieu courant
        this.aCurrentRoom = vOutside;
    }
    
    /**
     * Permet le déplacement entre les différente salles.
     */
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
        
    /** 
     * Permet de jouer au jeu.
     */
    public void play()
    {
        printWelcome();
        boolean vFinished = false;
        while (!vFinished)
        {
            Command vCmd = this.aParser.getCommand();
            vFinished = this.processCommand(vCmd);
        }
        System.out.println("\n" + "Thank you for playing.   Good bye.");
    }
} // Game
