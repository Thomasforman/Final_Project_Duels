import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class SelectButton extends Button
{
    private Player set, changePlayer;
    
    public SelectButton(int xLoc, int yLoc, Player setPlayer, Player change)
    {
        super(new Rectangle(xLoc, yLoc, Constants.TILE_WIDTH, Constants.TILE_HEIGHT), Constants.PHASE_2, Constants.PHASE_2);
        set = setPlayer;
        changePlayer = change;
    }

    public void updateGameState(ArrayList<GamePiece> entities)
    {
        int i = 0;
        while (entities.get(i) != changePlayer)
        {
            i++;
        }
        entities.set(i, (GamePiece) set);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(button);
    }
}