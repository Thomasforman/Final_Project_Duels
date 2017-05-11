import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
public class Player extends GamePiece
{
    private int health, recovery, attack;
    private int xIncrement, yIncrement, direction;
    private Color playerColor;
    public static final int PLAYER_1 = 1, PLAYER_2 = 2, NORTH = 1001, EAST = 1002, SOUTH = 1003, WEST = 1004;
    private int[] playerControls;
    public static final int[] player1Controls = {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D}, player2Controls = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};
    private static final int[] xSetNorth = {GameIO.cWidth/2, 0, GameIO.cWidth}, xSetSouth = xSetNorth, xSetWest = {0, GameIO.cWidth, GameIO.cWidth}, xSetEast = {GameIO.cWidth, 0, 0};
    private static final int[] ySetNorth = {0, GameIO.cHeight, GameIO.cHeight}, ySetSouth = {GameIO.cHeight, 0, 0}, ySetWest = {GameIO.cHeight/2, 0, GameIO.cHeight}, ySetEast = ySetWest;
    private static final int sides = 3;

    public Player(int player , Color c)
    {
        super();
        setCollision(true);
        player = Utility.truncate(player, PLAYER_1, PLAYER_2);
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
        playerColor = c;
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
            if (direction != WEST)
                direction = WEST;
            else
                left();
        }
        if (keyCode == playerControls[3])
        {
            if (direction != EAST)
                direction = EAST;
            else
                right();
        }
    }

    public boolean collideAfterMovement(int row, int col, GamePiece[][] board)
    {
        int newRow = Utility.truncate(row + yIncrement, 0, board.length - 1);
        int newCol = Utility.truncate(col + xIncrement, 0, board[row].length - 1);
        if (row == 0 && direction == NORTH || row == board.length-1 && direction == SOUTH || col == 0 && direction == WEST || col == board[row].length-1 && direction == EAST)
            return true;
        else if (board[newRow][newCol] == null)
            return false;
        else if (board[newRow][newCol].doesCollide())
            return true;
        else
            return false;
    }

    public void updateGameState(int row, int col, GamePiece[][] board)
    {
        if (!collideAfterMovement(row, col, board))
        {
            board[row + yIncrement][col + xIncrement] = (GamePiece) this;
            board[row][col] = null;
        }
        reset();
    }

    public void draw(int row, int col, Graphics g)
    {
        int xLoc = Utility.getXOnBoard(col);
        int yLoc = Utility.getYOnBoard(row);
        g.setColor(playerColor);
        int[] xLocs, yLocs;
        if (direction == NORTH)
        {
            xLocs = Utility.addToArray(xSetNorth, xLoc);
            yLocs = Utility.addToArray(ySetNorth, yLoc);
        }
        else if (direction == EAST)
        {
            xLocs = Utility.addToArray(xSetEast, xLoc);
            yLocs = Utility.addToArray(ySetEast, yLoc);
        }
        else if (direction == SOUTH)
        {
            xLocs = Utility.addToArray(xSetSouth, xLoc);
            yLocs = Utility.addToArray(ySetSouth, yLoc);
        }
        else
        {
            xLocs = Utility.addToArray(xSetWest, xLoc);
            yLocs = Utility.addToArray(ySetWest, yLoc);
        }
        g.fillPolygon(xLocs, yLocs, Math.min(xLocs.length, yLocs.length));
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