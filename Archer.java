public class Archer extends GameClass
{
    public Archer()
    {
        super(100, 150, 100);
    }
    
    public String getDescription()
    {
        return "Archer";
    }
    
    @Override
    public void damageTaken(int damage) //can put conditions
    {
        addHealth(-damage);
    }
    
    @Override
    public int damageDealt() //can add multipliers
    {
        return getAttack();
    }
}