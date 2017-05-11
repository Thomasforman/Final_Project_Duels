import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
public class GameWindow extends JFrame
{
    public static final int WIDTH = 500, HEIGHT = 500;
    private int BORDER_HEIGHT = 30, BORDER_WIDTH = 7;
    GameIO gameIO = new GameIO();

    public GameWindow()
    {
        add(gameIO);
    }
    
    public GameIO getIO()
    {
        return gameIO;
    }

    public void initialize()
    {
        setSize(WIDTH + BORDER_WIDTH, HEIGHT + BORDER_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Duels");
        setVisible(true);
    }
}