import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
public class EditScreenManager extends JPanel implements ActionListener
{
  private static final String fwdEditAction1 = "fwdEditAction1", revEditAction1 = "revEditAction1", fwdEditAction2 = "fwdEditAction2", revEditAction2 = "revEditAction2";
  private ArrayList<GamePiece> entities;
  private int playerNum;
  
  public EditScreenManager(int player, ArrayList<GamePiece> pieces)
  {
    entities = pieces;
    playerNum = player;
    createButtons();
  }
  
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }
  
  //TODO: changes contents of arraylist (in corresponding player) by clicking button
  
  private void createButtons()
  {
    
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();
    
  }
}