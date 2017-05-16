import javax.swing.JFrame;
import java.awt.Color;
public class Tester
{
    public static void main(String[] args)
    {
        GameIO io = new GameIO();
        io.addPiece(new Player(0, 0, Constants.PLAYER_1, "doge.png"));
        io.addPiece(new Player(GameWindow.WIDTH - 64, GameWindow.HEIGHT - 64, Constants.PLAYER_2, "doge.png"));
       
        GameWindow window = new GameWindow();
        window.add(io);
        window.initialize();
    }
}