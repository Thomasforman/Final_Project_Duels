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
    private Timer t = new Timer(5, this);
    private GamePiece[][] board = new GamePiece[GameWindow.HEIGHT / cHeight][GameWindow.WIDTH / cWidth];

    public GameIO()
    {
        super();
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        board[0][0] = new Player(Player.PLAYER_1, Color.RED);
        board[board.length-1][board[0].length-1] = new Player(Player.PLAYER_2, Color.BLUE);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT); //draws the background
        //draws components on board
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (board[row][col] != null)
                {
                    board[row][col].draw(row, col, g);
                }
            }
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
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                GamePiece g = board[row][col];
                if (g != null && g instanceof Player)
                {
                    ((Player) g).respondToKeyPressed(row, col, e);
                }
            }
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
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                GamePiece g = board[row][col];
                if (g != null)
                {
                    g.updateGameState(row, col, board);
                }
            }
        }
    }
    
    public GamePiece[][] getBoard()
    {
        return board;
    }
}