import java.awt.Graphics;
public abstract class GamePiece
{
    private boolean collision;
    
    public GamePiece()
    {
        collision = true;
    }
    
    public void setCollision(boolean collides)
    {
        collision = collides;
    }
    
    public boolean doesCollide()
    {
        return collision;
    }
    
    public abstract void updateGameState(int row, int col, GamePiece[][] board);
    
    public abstract boolean collideAfterMovement(int row, int col, GamePiece[][] board);
    
    public abstract void draw(int row, int col, Graphics g);
}