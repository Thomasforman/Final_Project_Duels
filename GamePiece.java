import java.awt.Graphics;
import java.util.ArrayList;
import javafx.geometry.BoundingBox;
public abstract class GamePiece
{
    private boolean collision;
    protected ArrayList<BoundingBox> bounds;
    protected int xLoc, yLoc;

    public GamePiece()
    {
        collision = true;
        bounds = new ArrayList<BoundingBox>();
    }

    public void setCollision(boolean collides)
    {
        collision = collides;
    }

    public boolean doesCollide()
    {
        return collision;
    }

    public boolean collideAfterMovement(int xIncrement, int yIncrement, ArrayList<GamePiece> entities)
    {
        if (xIncrement == 0 && yIncrement == 0)
        {
            return false;
        }
        for (BoundingBox b : bounds)
        {
            BoundingBox newBox = new BoundingBox(b.getMinX() + xIncrement, b.getMinY() + yIncrement, b.getWidth(), b.getHeight());
            for (GamePiece g : entities)
            {
                if (g.doesCollide() && g != this)
                {
                    for (BoundingBox otherBox : g.getBounds())
                    {
                        if (newBox.intersects(otherBox))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void updateBoundingBox(int xIncrement, int yIncrement)
    {
        if (xIncrement == 0 && yIncrement == 0)
        {
            return;
        }
        for (int i = 0; i < bounds.size(); i++)
        {
            BoundingBox b = bounds.get(i);
            bounds.set(i, new BoundingBox(b.getMinX() + xIncrement, b.getMinY() + yIncrement, b.getWidth(), b.getHeight()));
        }
    }

    public abstract void updateGameState(ArrayList<GamePiece> entities);

    public abstract void draw(Graphics g);
    
    public ArrayList<BoundingBox> getBounds()
    {
        return new ArrayList<BoundingBox>(bounds);
    }
}