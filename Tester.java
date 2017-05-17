import javax.swing.JFrame;
import java.awt.Color;
public class Tester
{
    public static void main(String[] args)
    {
        Maze maze = new Maze();
        Player p = new Player(0, 0, Constants.PLAYER_1, "R1.png");
        p.setSpeed(64, 64);
        maze.addPiece(p);
        maze.addPiece(new Wall(65, 65, ""));
        maze.addPiece(new Wall(250 + 64 + 65 + 10, 250, ""));
        GameIO io = new GameIO(50, maze);
        GameWindow window = new GameWindow();
        window.add(io);
        window.initialize();
    }
}