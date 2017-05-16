import javax.swing.JFrame;
import java.awt.Color;
public class Tester
{
    public static void main(String[] args)
    {
        GameWindow window = new GameWindow();
        GameIO io = window.getIO();
        io.addPiece(new Player(Player.PLAYER_1, Color.RED));
        window.initialize();
    }
}