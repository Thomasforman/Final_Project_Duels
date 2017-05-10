import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
public class Player extends GamePiece
{
    private int health, recovery, attack;
    private int xIncrement, yIncrement, direction;
    public static final int PLAYER_1 = 1, PLAYER_2 = 2, NORTH = 1001, EAST = 1002, SOUTH = 1003, WEST = 1004;
    private int[] playerControls;
    public static final int[] player1Controls = {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D}, player2Controls = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};

    public Player(int player)
    {
        super();
        setCollision(true);
        if (player == 1)
        {
            playerControls = player1Controls;
            direction = SOUTH;
        }
        if (player == 2)
        {
            playerControls = player2Controls;
            direction = NORTH;
        }
    }

    public void respondToKeyPressed(int row, int col, KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if (keyCode == playerControls[0])
        {
            if (direction != NORTH)
            direction = NORTH;
            else
            up();
        }
        if (keyCode == playerControls[1])
        {
            if (direction != SOUTH)
            direction = SOUTH;
            else
            down();
        }
        if (keyCode == playerControls[2])
        {
            if (direction == NORTH)
            direction = EAST;
            else
            left();
        }
        if (keyCode == playerControls[3])
        {
            if (direction == NORTH)
            direction = NORTH;
            else
            up();
        }
    }

    public boolean collideAfterMovement(int row, int col, GamePiece[][] board)
    {
        return false;
    }

    public void updateGameState(int row, int col, GamePiece[][] board)
    {
        if (!collideAfterMovement(row, col, board))
        {
            board[row + yIncrement][col + xIncrement] = (GamePiece) this;
            board[row][col] = null;
        }
    }

    public void up()
    {
        xIncrement = 0;
        yIncrement = -1;
    }

    public void down()
    {
        xIncrement = 0;
        yIncrement = 1;
    }

    public void left()
    {
        xIncrement = -1;
        yIncrement = 0;
    }

    public void right()
    {
        xIncrement = 1;
        yIncrement = 0;
    }

    public void reset()
    {
        xIncrement = 0;
        yIncrement = 0;
    }
    
    public int getDirection()
    {
        return direction;
    }
}