import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class SomeButton extends Button
{
    public SomeButton(int xLoc, int yLoc)
    {
        super(new Rectangle(xLoc, yLoc, Constants.TILE_WIDTH, Constants.TILE_HEIGHT), Constants.PHASE_1, Constants.PHASE_2);
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {

    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g; //temporary
        g2.draw(button);
    }
}