import java.awt.Color;
import java.awt.Graphics;
public class Wall extends Obstacle
{
    public Wall()
    {
        super();
        setCollision(true);
    }

    public void doPlayerEffect(Player p)
    {

    }

    public void draw(int row, int col, Graphics g)
    {
        int xLoc = Utility.getXOnBoard(col);
        int yLoc = Utility.getYOnBoard(row);
        g.setColor(Color.WHITE);
        g.fillRect(xLoc, yLoc, GameIO.cWidth, GameIO.cHeight);
    }

    public boolean collideAfterMovement(int row, int col, GamePiece[][] board)
    {
        return false;
    }

    public void updateGameState(int row, int col, GamePiece[][] board)
    {

    }
}