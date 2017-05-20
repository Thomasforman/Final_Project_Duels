import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class EditButton extends Button
{
    public EditButton(int xLoc, int yLoc)
    {
        super(new Rectangle(xLoc, yLoc, Constants.TILE_WIDTH, Constants.TILE_HEIGHT), Constants.PHASE_1, Constants.PHASE_2);
        super.setImage("EditIcon.png");
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {

    }
}