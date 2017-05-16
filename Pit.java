import java.awt.Color;
import java.awt.Graphics;
public abstract class Pit extends Obstacle
{
    public Pit(String imageName)
    {
        super(imageName);
        setCollision(false);
    }
    
    public void doPlayerEffect(Player p)
    {
        p.addHealth(-(p.getHealth()));
    }
    
    public boolean collideAfterMovement(int row, int col, GamePiece [][] board)
    {
        return false;
    }
    
    public void updateGameState(int row, int col, GamePiece[][] board)
    {
        
    }
    
    public void draw(int row, int col, Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(Utility.getXOnBoard(col), Utility.getYOnBoard(row), GameIO.cWidth, GameIO.cHeight);
    }
}