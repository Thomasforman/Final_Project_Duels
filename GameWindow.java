import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
public class GameWindow extends JFrame
{
    public static final int NUM_ROWS = 10, NUM_COLS = 10;
    public static final int WIDTH = NUM_ROWS * GameIO.cHeight, HEIGHT = NUM_COLS * GameIO.cWidth;
    private int BORDER_HEIGHT = 30, BORDER_WIDTH = 7;

    public void initialize()
    {
        setSize(WIDTH + BORDER_WIDTH, HEIGHT + BORDER_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GameWindow");
        setVisible(true);
    }
}