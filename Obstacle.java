public abstract class Obstacle extends GamePiece
{
    public Obstacle (String imageName)
    {
        super(imageName);
    }
    
    public abstract void doPlayerEffect(Player p);
}