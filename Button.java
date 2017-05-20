import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
public abstract class Button
{
    protected Shape button;
    private boolean clicked;
    private int triggerPhase, nextPhase;
    protected BufferedImage image;

    public Button(Shape buttonShape, int triggerPhase, int nextPhase)
    {
        button = buttonShape;
        clicked = false;
        this.nextPhase = nextPhase;
        this.triggerPhase = triggerPhase;
        setImage("");
    }

    public void respondToClicked(MouseEvent e)
    {
        int xButton = e.getX();
        int yButton = e.getY();
        if (button.contains(xButton, yButton))
        {
            clicked = true;
        }
    }
    
    public boolean cursorOnButton(MouseEvent e)
    {
        return button.contains(e.getX(), e.getY());
    }

    public int getNextPhase()
    {
        return nextPhase;
    }

    public int getTriggerPhase()
    {
        return triggerPhase;
    }

    public void setPhase(int set)
    {
        nextPhase = set;
    }

    public boolean isPressed()
    {
        return clicked;
    }

    public void reset()
    {
        clicked = false;
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, (int) button.getBounds().getX(), (int) button.getBounds().getY(), null);
    }

    public void setImage(String imageName)
    {
        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
        }
    }

    public abstract void updateGameState(ArrayList<GamePiece> entities);
}