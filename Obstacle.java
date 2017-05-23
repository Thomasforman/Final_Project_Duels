public abstract class Obstacle extends GamePiece
{
    public Obstacle (String imageName)
    {
        super(imageName);
    }
    
    public Obstacle()
    {
        super();
    }
    
    public abstract void doPlayerEffect(Player p);
}