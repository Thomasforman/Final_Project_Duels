import javax.swing.*;
public class Tester2
{
    public static void main(String[] args)
    {
        Duel game = new Duel("background.jpg");
        game.addButton(new EditButton(50, 50));
        game.addButton(new EditButton(300, 300));
        GameIO io = new GameIO(3, game);
        JFrame frame = new JFrame();
        frame.add(io);
        frame.setSize(512, 512);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GameWindow");
        frame.setVisible(true);
    }
}