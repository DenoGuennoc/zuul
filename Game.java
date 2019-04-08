 import java.util.*; 
 
/**
 * Game class.
 */
public class Game
{
    private UserInterface gui;
    private GameEngine aEngine;
    
    /**
     * Constructor of the Game class.
     */
    public Game ()
    {
        aEngine = new GameEngine();
        gui = new UserInterface(aEngine);
        aEngine.setGUI(gui);
    }
    
} // Game
