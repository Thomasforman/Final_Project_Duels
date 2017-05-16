import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
public class GameIO extends JComponent implements ActionListener, KeyListener
{
    public static final int cWidth = 50, cHeight = 50;
    private Timer t = new Timer(5, this);
    private ArrayList<GamePiece> entities = new ArrayList<GamePiece>();

    public GameIO()
    {
        super();
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
        //draws components on board
        for (GamePiece piece : entities)
        {
            piece.draw(g);
        }
        //draws gridlines
        g.setColor(Color.GREEN);
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
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyPressed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyReleased(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        for (GamePiece g : entities)
        {
            g.updateGameState(entities);
        }
    }
    
    public void addPiece(GamePiece g)
    {
        if (g instanceof Player)
        {
            entities.add(g);
        }
        else
        {
            entities.add(0, g);
        }
    }
}