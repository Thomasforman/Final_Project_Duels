import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Duel extends GameEvent
{
    private int phase;
    private ArrayList<Button> buttons;
    private BufferedImage image;

    public Duel(String imageName)
    {
        super();
        phase = Constants.PHASE_1;
        buttons = new ArrayList<Button>();
        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
        }
    }

    @Override
    public void draw(Graphics g)
    {
        if (phase == Constants.PHASE_3)
        {
            g.drawImage(image, 0, 0, null);
            for (int i = entities.size() - 1; i >= 0; i--)
            {
                entities.get(i).draw(g);
            }
        }
        for (Button b : buttons)
        {
            if (b.getTriggerPhase() == phase)
            {
                b.draw(g);
            }
        }
    }

    @Override
    public void respondToKeyPressed(KeyEvent e)
    {
        if (phase == Constants.PHASE_3)
        {
            for (GamePiece g : entities)
            {
                if (g instanceof Player)
                {
                    ((Player) g).respondToKeyPressed(e);
                }
            }
        }
    }

    @Override
    public void respondToKeyReleased(KeyEvent e)
    {
        if (phase == Constants.PHASE_3)
        {
            for (GamePiece g: entities)
            {
                if (g instanceof Player)
                {
                    ((Player) g).respondToKeyReleased(e);
                }
            }
        }
    }

    @Override
    public void respondToMouseClicked(MouseEvent e)
    {
        for (Button b : buttons)
        {
            if (b.getTriggerPhase() == phase)
            {
                b.respondToClicked(e);
            }
        }
        if (phase == Constants.PHASE_1)
        {
            for(Button b : buttons)
            {
                b.respondToClicked(e);
            }
        }
    }

    @Override
    public void updateGameState(ActionEvent e)
    {
        for (Button b : buttons)
        {
            if (b.getTriggerPhase() == phase && b.isPressed())
            {
                phase = b.getNextPhase();
                b.updateGameState(entities);
                b.reset();
            }
        }
        if (phase == Constants.PHASE_3)
        {
            for (int i = entities.size() - 1; i >= 0; i--)
            {
                entities.get(i).updateGameState(entities);
            }
        }
    }

    public boolean hoverOverButtons(MouseEvent e)
    {
        for (Button b : buttons)
        {
            if (b.getTriggerPhase() == phase && b.cursorOnButton(e))
            {
                return true;
            }
        }
        return false;
    }

    public void setPhase(int newPhase)
    {
        phase = newPhase;
    }

    public void addButton(Button newButton)
    {
        buttons.add(newButton);
    }
    
    private void defaultSetting()
    {
        addPiece(new Barrier(-2, -2, 1, GameWindow.HEIGHT+2));
        addPiece(new Barrier(-2, -2, GameWindow.WIDTH+2, 1));
        addPiece(new Barrier(GameWindow.WIDTH+1, -2, 1, GameWindow.HEIGHT+2));
        addPiece(new Barrier(-2, GameWindow.HEIGHT, GameWindow.WIDTH+2, 1));
        addPiece(new Swordsman(0, 0, Constants.PLAYER_1));
        addPiece(new Cannoneer(GameWindow.WIDTH - Constants.TILE_WIDTH, GameWindow.HEIGHT - Constants.TILE_HEIGHT, Constants.PLAYER_2));
    }
}