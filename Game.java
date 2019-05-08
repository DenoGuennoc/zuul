 import java.util.*; 
 
/**
 * Class Game :
 * 
 * Class of the game.
 * 
 * @author Denoela Guennoc
 * @version 2019
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
