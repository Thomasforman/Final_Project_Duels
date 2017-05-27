import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;

public class CustomButton extends JButton implements MouseListener, MouseMotionListener
{
    private Shape buttonShape;

    public CustomButton(Shape s)
    {
        super();
        buttonShape = s;
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ((Graphics2D) g).draw(buttonShape);
    }

    @Override
    protected void paintBorder(Graphics g)
    {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).draw(buttonShape);
    }

    @Override
    public boolean contains(int x, int y)
    {
        return buttonShape.contains(x, y);
    }

    @Override
    public void updateUI()
    {
        super.updateUI();
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Area a = new Area(buttonShape);
        if (a.contains(e.getX(), e.getY()))
        {
            doClick();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        Area a = new Area(buttonShape);
        if (a.contains(e.getX(), e.getY()))
        {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else
        {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }
}