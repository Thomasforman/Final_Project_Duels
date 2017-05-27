import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class BattleManager extends JComponent implements ActionListener, KeyListener
{
    private Timer t;
    private ArrayList<GamePiece> entities;

    public BattleManager(int speed, ArrayList<GamePiece> pieces)
    {
        super();
        entities = pieces;
        t = new Timer(speed, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draws components on board
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            entities.get(i).draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyPressed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        for (GamePiece g : entities)
        {
            if (g instanceof Player)
            {
                ((Player) g).respondToKeyReleased(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            g.updateGameState(entities); //more GamePiece objects can be added in this step
            if (g instanceof Player && ((Player) g).getHealth() <= 0)
            {
                gameEnd();
                return;
            }
        }
    }

    private void gameEnd()
    {
        setEnabled(false);
        t.stop(); //disables the timer
        EndScreenManager esm = new EndScreenManager(entities);
        GameWindow w = new GameWindow(getWidth(), getHeight());
        w.setContentPane(esm);
        w.initialize();
        w.setVisible(true);
        JFrame parent = (JFrame) getTopLevelAncestor();
        parent.dispose(); //disposes battle screen after use
    }
}