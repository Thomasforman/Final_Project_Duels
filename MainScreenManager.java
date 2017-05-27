import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.*;
public class MainScreenManager extends JPanel implements ActionListener
{
    private static final String battleAction = "battleAction";
    private ArrayList<GamePiece> entities;
    private JButton startButton;

    public MainScreenManager(ArrayList<GamePiece> pieces)
    {
        super(new BorderLayout());
        entities = pieces;
        createButtons();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    private void createButtons()
    {
        //makes the start button, starts game(battle) when pressed
        //CustomButton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
        JButton startButton = new JButton("The Button");
        startButton.setActionCommand(battleAction);
        startButton.addActionListener(this);
        add(startButton, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if (command.equals(battleAction))
        {
            setEnabled(false);
            BattleManager bm = new BattleManager(3, entities);
            GameWindow w = new GameWindow(getWidth(), getHeight());
            w.setContentPane(bm);
            w.initialize();
            w.setVisible(true);
            JFrame parent = (JFrame) getTopLevelAncestor();
            parent.remove(this);
            parent.setVisible(false);
            parent.dispose();
        }
    }
}