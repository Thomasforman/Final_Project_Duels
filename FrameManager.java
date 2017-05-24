import javax.swing.*;
public class FrameManager
{
  //everything to keep track
  private JFrame frame1 = new JFrame(), frame2 = new JFrame(), frame3 = new JFrame();
  private JFrame[] frames = {frame1, frame2, frame3};
  
  public void displayGUI()
  {
    //default settings for all frames
    for (JFrame f : frames)
    {
      f.setSize(512, 512);
      f.setLocationRelativeTo(null);
      f.setResizable(false);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("GameWindow");
    }
    frame1.makeVisible(true);
    //making the start button (press it and the game starts)
    Custombutton startButton = new CustomButton(new Rectangle(50, 50, 50, 50));
    startButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        frame1.makeVisible(false);
        frame2.makeVisible(true);
        frame3.makeVisible(false);
      }
    });
    frame1.add(startButton);
  }
}