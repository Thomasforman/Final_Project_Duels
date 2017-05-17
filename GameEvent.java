import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
public abstract class GameEvent
{
    protected ArrayList<GamePiece> entities;
    
    public GameEvent()
    {
        entities = new ArrayList<GamePiece>();
    }
    
    public void draw(Graphics g)
    {
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            entities.get(i).draw(g);
        }
    }
    
    public void respondToKeyPressed(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyPressed(e);
            }
        }
    }
    
    public void respondToKeyReleased(KeyEvent e)
    {
        for (GamePiece g: entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyReleased(e);
            }
        }
    }
    
    public void updateGameState()
    {
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            entities.get(i).updateGameState(entities);
        }
    }
    
    public void addPiece(GamePiece g)
    {
        if (g instanceof Player)
        {
            entities.add(0, g);
        }
        else
        {
            entities.add(g);
        }
    }
}