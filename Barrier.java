import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.ArrayList;
public class Barrier extends Obstacle
{
    public Barrier(int xStart, int yStart, int width, int height)
    {
        super();
        setCollision(true);
        bounds.add(new Rectangle(xStart, yStart, width, height));
    }

    public void doPlayerEffect(Player p)
    {

    }

    public void draw(Graphics g)
    {

    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {

    }
}