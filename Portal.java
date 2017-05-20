import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Portal extends Obstacle
{
    public Portal(int xStart, int yStart, String imageName)
    {
        super(imageName);
        xLoc = xStart;
        yLoc = yStart;
        setCollision(false);
        bounds.add(new Rectangle(xStart, yStart, Constants.TILE_WIDTH-2, Constants.TILE_HEIGHT-2));
    }

    public void doPlayerEffect(Player p)
    {

    }

    public boolean collideAfterMovement(int row, int col, GamePiece [][] board)
    {
        return false;
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        GamePiece p = entities.get(0); //must be the player
        if (collide(p))
        {
            int i = 0;
            while (entities.get(i) != this)
                i++;
            entities.remove(i);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, xLoc, yLoc, null);
    }
    
    public String getName()
    {
        return "Portal";
    }
}