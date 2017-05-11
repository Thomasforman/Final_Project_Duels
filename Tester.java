import javax.swing.JFrame;
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
        window.initialize();
    }
}