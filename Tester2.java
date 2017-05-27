import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Tester2
{
    public static void main(String[] args)
    {
        ArrayList<GamePiece> entities = new ArrayList<GamePiece>();
        MainScreenManager msm = new MainScreenManager(Utility.defaultList());
        msm.setOpaque(true);
        GameWindow w = new GameWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        w.setContentPane(msm);
        w.initialize();
        w.setVisible(true);
    }
}