import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
public class GameIO extends JComponent implements ActionListener, KeyListener
{
    public static final int cWidth = 50, cHeight = 50;
    private int xIncrement = 0, yIncrement = 0, xLoc = 0, yLoc = 0;
    private Timer t = new Timer(5, this);
    private Player player1, player2; //two separate players
    private boolean keyIsDown1, keyIsDown2; //checks if the player is pressing a button

    public GameIO()
    {
        super();
        player1 = new Player(1);
        player1.setLoc(0, 0);
        player2 = new Player(2);
        player2.setLoc(GameWindow.WIDTH - cWidth, GameWindow.HEIGHT - cHeight);
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
        g.setColor(Color.BLUE);
        g.fillOval(player1.getX(), player1.getY(), cWidth, cHeight);
        g.setColor(Color.WHITE);
        g.fillOval(player2.getX(), player2.getY(), cWidth, cHeight);
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
        int keyCode = e.getKeyCode();
        //player1 controls
        boolean canMove1 = !player1.collideAfterMovement(player2, e);
        boolean canMove2 = !player2.collideAfterMovement(player1, e);
        if(keyCode == player1.getControls()[0]) //up for player 1
        {
            if (player1.getDirection() != Player.NORTH)
                player1.changeDirection(Player.NORTH);
            else if (canMove1)
                player1.setInc(0, -cHeight);
        }
        if(keyCode == player1.getControls()[1]) //down for player 1
        {
            if (player1.getDirection() != Player.SOUTH)
                player1.changeDirection(Player.SOUTH);
            else if (canMove1)
                player1.setInc(0, cHeight);
        }
        if(keyCode == player1.getControls()[2])
        {
            if (player1.getDirection() != Player.WEST)
                player1.changeDirection(Player.WEST);
            else if (canMove1)
                player1.setInc(-cWidth, 0);
        }
        if(keyCode == player1.getControls()[3])
        {
            if (player1.getDirection() != Player.WEST)
                player1.changeDirection(Player.WEST);
            else if (canMove1)
                player1.setInc(cWidth, 0);
        }
        //player2 controls
        if(keyCode == player2.getControls()[0])
        {
            player2.setInc(0, -cHeight);
        }
        if(keyCode == player2.getControls()[1])
        {
            player2.setInc(0, cHeight);
        }
        if(keyCode == player2.getControls()[2])
        {
            player2.setInc(-cWidth, 0);
        }
        if(keyCode == player2.getControls()[3])
        {
            player2.setInc(cWidth, 0);
        }
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
        player1.move();
        player2.move();
        player1.setInc(0, 0);
        player2.setInc(0, 0);
    }
}