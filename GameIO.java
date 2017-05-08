import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
public class GameIO extends JComponent implements ActionListener, KeyListener
{
    public static final int PLAYER_1 = 1, PLAYER_2 = 2;
    public static final int cWidth = 50, cHeight = 50;
    private int xIncrement = 0, yIncrement = 0, xLoc = 0, yLoc = 0;
    private Timer t = new Timer(100, this);
    private int[] playerControls;
    private static final int[] player1Controls = {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D};
    private static final int[] player2Controls = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};

    public GameIO(int player)
    {
        super();
        if (player == 1)
            playerControls = player1Controls;
        if (player == 2)
            playerControls = player2Controls;
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT);
        g.setColor(Color.WHITE);
        g.fillRect(xLoc, yLoc, cWidth, cHeight);
        for (int row = 0; row <= GameWindow.HEIGHT; row += cHeight)
        {
            g.drawLine(0, row, GameWindow.WIDTH, row);
        }
        for (int col = 0; col <= GameWindow.WIDTH; col += cWidth)
        {
            g.drawLine(col, 0, col, GameWindow.HEIGHT);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode == playerControls[0])
            up();
        if(keyCode == playerControls[1])
            down();
        if(keyCode == playerControls[2])
            left();
        if(keyCode == playerControls[3])
            right();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        xLoc = Utility.truncate(xLoc + xIncrement, 0, GameWindow.WIDTH - cWidth);
        yLoc = Utility.truncate(yLoc + yIncrement, 0, GameWindow.HEIGHT - cHeight);
        xIncrement = 0;
        yIncrement = 0;
    }

    public void up()
    {
        xIncrement = 0;
        yIncrement = -cHeight;
    }

    public void down()
    {
        xIncrement = 0;
        yIncrement = cHeight;
    }

    public void left()
    {
        xIncrement = -cWidth;
        yIncrement = 0;
    }

    public void right()
    {
        xIncrement = cWidth;
        yIncrement = 0;
    }

    public void stay()
    {
        xIncrement = 0;
        yIncrement = 0;
    }
}