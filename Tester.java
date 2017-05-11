import javax.swing.JFrame;
import java.awt.Color;
public class Tester
{
    public static void main(String[] args)
    {
        GameWindow window = new GameWindow();
        GamePiece[][] theBoard = window.getIO().getBoard();
        theBoard[5][5] = new Wall();
        theBoard[5][4] = new Wall();
        theBoard[4][5] = new Wall();
        theBoard[4][4] = new Wall();
        theBoard[0][0] = new Player(Player.PLAYER_1, Color.RED);
        theBoard[theBoard.length-1][theBoard[0].length-1] = new Player(Player.PLAYER_2, Color.BLUE);
        window.initialize();
    }
}