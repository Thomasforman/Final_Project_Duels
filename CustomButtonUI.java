import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
public class CustomButtonUI extends BasicButtonUI
{
    private Shape buttonShape;
    
    @Override
    protected void installDefaults(AbstractButton b)
    {
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }
    
    @Override
    protected void installListeners(AbstractButton b)
    {
        
    }
}